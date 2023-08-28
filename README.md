### Updated_README

基础技术部分可借鉴JavaAgent_Test1文件夹中的README，但在实际实现上有一些修改。

1. 目前完全采用了`javassist`形式的`javaagent`，而完全抛弃了`asm`形式。其中`agent1`为`premain`类型，`agent3`为`agentmain`类型，目前主体采用的还是`agent3`。

2. 除了`ActionNameES.java`中提到的各种继承于`ActionType`类的类名，在深入研究ES的代码结构后，发现在这些`Action`之上还存在着一些 “ 高级Action ”，其类名大部分为`TransportXXXAction`，主要调用那些继承于`ActionType`的`Action`的`Instance`与`NAME`2种field。于是经过检索，将这些高级Action类名存入到一个`TransportActionNameES.java`，并也是插入了`transformer`（仍可见于`agent3`）

3. 原来的JavaAgent_Test1在实际实现上存在着一点问题，但目前更新的JavaAgent_Test1已经能够正常实现插桩功能。

   

   更新内容主要在于：

   (1)

   ``````java
   ClassPool classPool = ClassPool.getDefault();
   classPool.insertClassPath(new LoaderClassPath(loader));
   String javaHome = System.getProperty("java.home");
   classPool.appendClassPath(javaHome + "/lib/jrt-fs.jar");
   ``````

   加入了使用的jdk目录下`"/lib/jrt-fs.jar"`的类路径添加，从而可以确保java的系统通用功能类能够正常使用。值得注意的是，为了能够正常添加该类路径，还应该先到使用的jdk目录下的`/conf/security/java.policy`，在`grant{}`种添加一句`permission java.io.FilePermission "${java.home}/lib/-", "read";`.

   

   (2)

   在`try`块的最后，还得再加上一句`ctClass.writeFile("C:\\elasticsearch\\elasticsearch-7.5.2\\server\\build-idea\\classes\\main");`，用以保存被修改的类，并且还应保存在ES下的`/server/build-idea/classes`目录下，用以覆盖先前被编译后的类。

   之后，只要启动ES与javaagent，就能够转换类并保存到该目录位置。值得注意的是，这些新的类需要重新启动ES（此时就不用再启动javaagent了）才会发挥作用。

   

   (3) 目前还存在的一些问题。

   通过JDgui这个反编译.class文件的工具，打开被修改的类后，可以发现类已经被正确插入了目标语句。

   但是，ES除了单纯的会被编译成.class的.java源码文件外，还存在着xpack, license, painless这3种插件，这3种插件中有很多.java文件也归属于`ActionType`或者`TransportXXXAction`的属别下。这些插件中的.java文件并不是先被编译成.class文件，再被加载到ES中的，而是直接被ES中的处理插件的模块直接加载.java文件。`/server/build-idea/classes`目录下更不存在这3种插件的.class文件。

   而javaagent修改类后，本身就是以.class文件的形式保存被修改的类。

   这便代表着，尽管我们能够利用javaagent去修改xpack, license, painless这3种插件，并获得被修改后的类文件，但这些被修改后的类文件无法取代原插件的程序。（我曾尝试过将这些修改后的类保存在`/server/build-idea/classes`目录下，之后启动ES便会出现`jar hell`这种jar包冲突的报错，无法启动）

   所以，如果真的要去对这些`Action`进行监控修改，单纯javaagent修改类是行不通的，但可能有以下2种可行的道路：

   a. 仍然使用javaagent修改类，并获得被修改后的类文件。但对于xpack, license, painless这3种插件，获得被修改的类文件后，通过JDgui又重新保存为.java文件，然后直接取代原来这3种插件中的.java文件。当然非这3种插件的可以直接用被修改后的类文件取代原类文件。

   b. 放弃javaagent的操作方式，而是直接利用`python`等批量处理各个.java文件，直接进行修改。但这里涉及到method等判断，或许会遇到许多不必要的问题。

   

