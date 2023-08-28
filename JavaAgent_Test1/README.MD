## README

​	本仓库中，`agent1.java`为简单的`premain`示例，`agent3.java`,`agent4.java`,`agent5.java`则为`agentmain`模式。其中，`agent3.java`为基于`javassist`的，`agent4.java`,`agent5.java`为基于`asm`的。`AttachMain.java`是`agentmain`模式下将agent附着到目标程序的实现。（一些程序里面加了TODO只是希望注释高亮点）

​	顺便附有304个ActionName。

​	其他介绍与使用流程见下。



### 1. 两种Javaagent插桩模式与使用流程

#### 1. premain

​	`premain`版`javaagent`是在主程序启动前执行的。选择`premain`版`javaagent`，需要在你的agent类下创建一个名为`premain`的函数，如：

``` java
public static void premain(String agentArgs, Instrumentation instr) {
        System.out.println("Premain Start!");

        System.out.println("Premain End!");
    }
```

​	将`premain`函数编写完成，确认可以用作`javaagent`插桩工具后，请确认`MANIFEST.MF`中选定的`premain`类为你的`premain`函数所在类。如：

``` MF
Premain-Class:  agents.agent1
```

​	接着可以进行jar包的打包。在此过程中`MANIFEST.MF`可能会被`IntelliJ`自动覆盖，请注意观察。

​	

​	下面以`elasticsearch`为例演示如何利用打包好的`premain`jar包进行插桩处理。

 1. 在`IntelliJ`中选择`Edit Configuration`，并添加`Application`指定为`elasticsearch`。（这个网上应该都有，不在此详述了）

 2. 在该`Application`下，通过`Modify options`选择添加`Add VM options`。`VM options`的示例如下：

    ``` java
    -Des.path.conf=C:\elasticsearch\elasticsearch-7.5.2-faxing\elasticsearch-7.5.2\config
    -Des.path.home=C:\elasticsearch\elasticsearch-7.5.2-faxing\elasticsearch-7.5.2
    -Dlog4j2.disable.jmx=true
    -Xmx4g
    -Xms4g
    -javaagent:"C:\Users\22071\Desktop\javacode\JavaAgent_Test1\out\artifacts\JavaAgent_Test1_jar\JavaAgent_Test1.jar"
    ```

    ​	其中，`-javaagent: `后面的路径为`premain`jar包所在路径。`-Des.path.home=`与`-Des.path.conf=`则分别指定`elastichsearch`发行版的根目录与config目录。请注意是发行版，即从`elasticsearch`官网上下载的版本，而非我们在`IntelliJ`中使用的来自github的源码版，发行版与源码版的版本应相同。

    ​	对于指定的发行版config目录，其中含有一个名为`elasticsearch.yml`的文件，请将其中的`node.name`所在的那一行取消注释（默认是被注释掉的）。

	3. 至此，运行`elastichsearch`源码版的主程序，`premain`的jar包即被插桩上。



#### 2. agentmain

​	与`premain`不同，`agentmain`支持在目标程序运行的任何时间段插桩。除了要打包成jar包外，还需要一个额外的程序用作jar包附着使用。

​	同样的，使用`agentmain`，需要在你使用的`agent`类下创建一个名为`agentmain`的函数，如：

``` java
public static void agentmain(String agentArgs, Instrumentation instr) throws ClassNotFoundException, UnmodifiableClassException {
        System.out.println("Agentmain Start!");

        ActionNameES ActionName304 = new ActionNameES();
        for(String ActName : ActionName304.ActionName)
        {
            instr.addTransformer(new agent3.Transformer(ActName), true);

        }

        System.out.println("Agentmain End!");
    }
```

​	编写完`agentmain`函数后，需要在`MANIFEST.MF`中选定的`agentmain`类为`agentmain`函数所在的类。如：

``` java
Agent-Class: agents.agent3
```

​	接着进行jar包打包，同样注意`MANIFEST.MF`不要被覆盖。

​	

​	下面同样以`elastichsearch`为例演示如何进行`agentmain`的插桩。

​	1. 进入仓库中的`AttachMain.java`，将`String`类型的`jar`变量赋值为自己的`agentmain`jar包所在路径，如：

``` java
String jar = "C:\\Users\\22071\\Desktop\\javacode\\JavaAgent_Test1\\out\\artifacts\\agent3\\JavaAgent_Test1.jar";

```

 2. 选定要附着的目标JVM，如：

    ``` java
    if (virtualMachineDescriptor.displayName().equals("org.elasticsearch.bootstrap.Elasticsearch")) 
    ```

	3. 先行启动`elasticsearch`源码，确认`elastichsearch`启动后，运行`AttachMain.java`。`agentmain`的jar包即被插桩上。`agentmain`中所打印的信息将出现在`elastichsearch`那边的输出中，即插桩后这个`AttachMain.java`就可以不管了。



​	可能会出现的问题：

​	由于`AttachMain.java`是通过搜寻正在运行的JVM后进行插桩的，所以要确保JVM搜寻功能的可用性。这在命令行中体现为`jps`命令。

​	对于windows用户，如果发现运行`elasticsearch`后，当前的JVM列表仍为空，即`VirtualMachine.list()`为空，或者在命令行中使用`jps`命令发现返回为空，可以找到`C:\Users\22071\AppData\Local\Temp\hsperfdata_22071`这个`hsperdata`文件夹，修改其权限为“当前用户完全控制”，应该就能解决该问题。



#### 3. 其他语法

​	虽然`premain`与`agentmain`在插桩使用时机上有些许不同，但它们都实现了这样的功能：

 1. 向目标要插桩的类添加一个转换器`Transformer`，如：

    ``` java
    instr.addTransformer(new agent3.Transformer(ActName), true);
    ```

    这个`Transformer`类是自己实现的，所以其各种Field与构造函数都可以自己根据需要指定。

	2. 目标类添加上`Transformer`后，当这个类第一次被加载，即会调用`Transformer`类中的`transform`函数，对目标类进行转换，从而实现插桩功能。

	3. 在`transform`中，我们可以实现各种功能，包括获取目标类的Field、Method，目标类子类的Field与Method，也可以添加Field、Method，与修改Method。依赖不同的库，一般会有不同的`transform`实现方式。



### 2. Javaagent插桩的2种依赖库

​	2种库对应的jar包都需要到`maven repository`中下载并导入到项目中。

#### 1. 基于javaassit的

​	一般来说比较推荐这一种，因为这种更容易理解，可拓展性也更强。基于javassist的可见`agent3.java`示例。

​	在`transform`中，我们需要建立起一个类池`ClassPool`，该类池将要容纳我们要修改的目标类，及其他会用到的通用功能类，以便我们在之后进行修改的工作。

​	类池`ClassPool`的初始化与进行类的添加如下：

``` java
ClassPool classPool = new ClassPool(true);// or "= ClassPool.getDefault()"
classPool.insertClassPath(new LoaderClassPath(loader));

//the below insert or import should work theoretically, but actually not, which bothers me a lot
classPool.insertClassPath(new LoaderClassPath(ClassLoader.getSystemClassLoader()));
classPool.appendSystemPath();
classPool.insertClassPath(new ClassClassPath(ArrayList.class));
classPool.insertClassPath(new ClassClassPath(java.util.List.class));
classPool.importPackage("java.util");
classPool.importPackage("java.lang");
classPool.appendClassPath(System.getProperty("java.home") + "/jre/lib/jrt-fs.jar"); //should modify the policy

```

​	其中，`ClassPool classPool = new ClassPool(true)`或``ClassPool classPool = ClassPool.getDefault()`理论上是获得一个存有默认通用功能类（如`java.util`)的类池。

​	接着，`classPool.insertClassPath(new LoaderClassPath(loader))`则是存入`loader`中的类，一般便是将`elastichsearch`的相关类存入类池了。

​	正常来说，有这两句便可以了，但如果在实际运行中发现缺少类，可以通过`classPool.insertClassPath()`，`classPool.appendClassPath`，`classPool.importPackage()`等语句将类，或者自己的jar包加入其中。

​	值得注意的是，在额外添加jar包的时候，请确保jar包所在的目录是“当前用户完全控制的”，并且请确保自己的JDK对这些目录下的jar包有可读权限。该可读权限可以在自己JDK `C:\Program Files\Java\jdk1.8.0_351\conf\security`目录下修改`java.policy`获得。如在`policy`文件后添加下述示例语句：

``` policy
permission java.io.FilePermission "${java.home}/lib/-", "read";
permission java.util.PropertyPermission "java.home", "read";
permission java.io.FilePermission "${java.home}/jre/lib/*", "read";
permission java.util.PropertyPermission "java.home", "read";
permission java.io.FilePermission "C:\\elasticsearch\\elasticsearch-7.5.2\\server\\src\\main\\java\\org\\elasticsearch\\bootstrap\\-", "read";
```

​	其中，`-`代表该目录下的所有文件（包括子文件夹的子文件夹的子文件....）

​	（理论上上面的这些操作就可以保证池子中有需要用到的类，但是我在实现中总是会出问题，甚至会缺失`java.lang`，`java.util`这种通用功能类，我怀疑是我电脑环境的问题QAQ，可能换台电脑就不会了啊吧啊吧。不过类缺失的报错只出现在`insertBefore`，`setBody`等修改method的语句，对其他的功能不产生影响。目前仍在艰苦地Debugging）



​	然后，利用类池与目标类名，可以获得自己想要的目标类：

``` java
CtClass ctClass = classPool.get(className);
```

​	其他功能可见`agent3.java`中。



​	进行一个`javassist`优缺点评判。

​    优点：易理解，易拓展，对目标类的子类也可以实现监控与修改。

​	缺点（似乎是我个人环境问题导致的，因为网上完全找不出这样的情况）：`CtConstructor`获取不到构造函数，类池中通用功能类的缺失。目前正在努力Debugging。



#### 2. 基于ASM的

​	该方式相较于`javassist`会复杂麻烦一下，可拓展性不强。基于ASM的可见`agent4.java`与`agent5.java`示例。`agent4.java`写的比较乱，可以看`agent5.java`。

​	这个其实就是利用了已有的`MethodNode`，`ClassVisitor`，`MethodVisitor`，`FieldVisitor`这些类去实现（见名知义）。然后通过编写自己的`visitMethod`，`visitField`，`visitMethodInsn`，`visitFieldInsn`，`visitInsn`，`visitCode`等方法实现对想要的插桩功能。

​	为了方便理解，可以先去阅读一下`MethodNode.class`。

​	主要的功能体现为：

``` java
ClassReader reader = new ClassReader(classfileBuffer);
ClassWriter writer = new ClassWriter(reader, ClassWriter.COMPUTE_MAXS);
ClassVisitor visitor = new MyClassVisitor(writer);
reader.accept(visitor, ClassReader.EXPAND_FRAMES);
```

​	可以理解为从类缓冲区中读出目标类，进行`visit`访问，这个`visit`访问的过程中，通过自己编写的相关`visit`类与方法，即可以实现各种对目标类的修改。

​	值得一提的是，对代码插入的实现体现为：

``` java
visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
visitLdcInsn("Exiting method " + name);
visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            
```

​	虽然也能理解，但显然比`javassist`麻烦多了。



​	优点：无

​	缺点：复杂麻烦，可拓展性不强，无法访问目标类的子类（`elasticsearch`的各种类中有很多子类，所以这个基本上激就是判了死刑。当然也可能是我找不到正确的实现方式，但哪怕是不好实现其实也说明了复杂麻烦），且代码的插入似乎也实现不了（可能也是我环境的问题吧）