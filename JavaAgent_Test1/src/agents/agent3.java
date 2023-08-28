package agents;

import javassist.*;
import javassist.bytecode.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.lang.reflect.Field;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.security.ProtectionDomain;
import java.util.*;
import org.apache.commons.io.IOUtils;

public class agent3 {

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

//    public static void premain(String agentArgs, Instrumentation instr) {
//        System.out.println("Premain Start!");
//
//        ActionNameES ActionName304 = new ActionNameES();
//        for(String ActName : ActionName304.ActionName)
//        {
//            instr.addTransformer(new agent3.Transformer(ActName), true);
//
//        }
//
//        System.out.println("Premain End!");
//    }

    public static void agentmain(String agentArgs, Instrumentation instr) throws ClassNotFoundException, UnmodifiableClassException {
        System.out.println("Agentmain Start!");

//        ActionNameES ActionName304 = new ActionNameES();
//        for(String ActName : ActionName304.ActionName)
//        {
//            instr.addTransformer(new agent3.Transformer(ActName), false);
//
//        }

        //To monitor the field NAME of those actions
        TransportActionNameES TransportNames = new TransportActionNameES();
        for(String TransportName : TransportNames.TransportActionName)
        {
            instr.addTransformer(new agent3.Transformer(TransportName), false);
        }

        System.out.println("Agentmain End!");
    }


    public static boolean isEmpty(CtMethod method) {
        return Modifier.isNative(method.getModifiers()) || Modifier.isAbstract(method.getModifiers());
    }

    static class Transformer implements ClassFileTransformer
    {
        private final String targetActionName;

        public Transformer(String targetActionName) {
            this.targetActionName = targetActionName;
        }

        public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
            className = className.replaceAll("/", ".");

            if(!className.equals("org.elasticsearch.xpack.core.action.TransportXPackInfoAction"))
            {
                return null;
            }

            if (!className.equals(targetActionName)) {
                return null;
            }
            System.out.println("\nTransforming: " + className);



            try {
                    ClassPool classPool = ClassPool.getDefault();
                    classPool.insertClassPath(new LoaderClassPath(loader));
                    String javaHome = System.getProperty("java.home");
                    classPool.appendClassPath(javaHome + "/lib/jrt-fs.jar"); //policy

                    CtClass ctClass = classPool.get(className);


                    // TODO, following are the available ways to add fields and methods
//                    // add field
//                    CtField z = new CtField(CtClass.intType, "z", ctClass);
//                    ctClass.addField(z, "0");
//
//                    // add method
//                    CtMethod m = CtNewMethod.make(
//                            "public int move(int dx) {  return  z + dx ; }",
//                            ctClass);
//                    ctClass.addMethod(m);

                    for (CtField ctField : ctClass.getDeclaredFields()) {

                        String fieldName = ctField.getName();
                        System.out.println("FieldName: " + fieldName);
                    }

                    for(CtConstructor ctConstructor : ctClass.getConstructors())
                    {
                        System.out.println("(un-insert mode) ctConstrutor name: " + ctConstructor.getName());

                        ctConstructor.insertAfter("System.out.println(\"(inserted) Class: " +  ctClass.getName() + " \");",false);
                        ctConstructor.insertAfter("System.out.println(\"(inserted) construtor: " +  ctConstructor.getName() + " \\n \");",false);
                        
                    }

                    for (CtMethod ctMethod : ctClass.getDeclaredMethods()) {
//                        System.out.println("(un-insert mode) ctMethod name: " + ctMethod.getName());
                        System.out.println("(un-insert mode) ctMethodInfo: " + ctMethod.getMethodInfo());


                        if(isEmpty(ctMethod))
                        {
                            System.out.println("\tTrying to insert code in Native/Abstract Method(empty method body), aborting...");
                            continue;
                        }

                        ctMethod.insertAfter("System.out.println(\"(inserted) Class: " +  ctClass.getName() + " \");",false);
                        ctMethod.insertAfter("System.out.println(\"(inserted) Method: " +  ctMethod.getName() + " \\n \");", false);



                        //TODO, only for highlight
                        //1. When inserted, it won't be called, unless the method is called again in the following processes
                        //2. Pay attention to the sequence of inserting, so the one last inserted would be first printed
                        //3. Pay attention to \n, to successfully insert, should be \\n
                        //4. Could not insert in Native or Abstract code, so should check it first, otherwise warning of 'no method body' occurs
                    }

                    for (CtClass subCtClass : ctClass.getNestedClasses()) {
                        System.out.println("subCtClass: " + subCtClass.getName());

                        // constructor of subclass
                        for(CtConstructor ctConstructor : subCtClass.getConstructors())
                        {
                            System.out.println("(un-insert mode) ctConstrutor name: " + ctConstructor.getName());

                            ctConstructor.insertAfter("System.out.println(\"(inserted) Class: " +  ctClass.getName() + " \");",false);
                            ctConstructor.insertAfter("System.out.println(\"(inserted) subClass: " +  subCtClass.getName() + " \");",false);
                            ctConstructor.insertAfter("System.out.println(\"(inserted) subconstrutor: " +  ctConstructor.getName() + " \\n \");",false);

                        }

                        for (CtMethod subCtMethod : subCtClass.getDeclaredMethods()) {
//                            System.out.println("(un-insert mode) subCtMethod name: " + subCtMethod.getName());
                            System.out.println("(un-insert mode) subCtMethodInfo: " + subCtMethod.getMethodInfo());


                            if(isEmpty(subCtMethod))
                            {
                                System.out.println("\tTrying to insert code in Native/Abstract Method(empty method body), aborting...");
                                continue;
                            }
                            
                            subCtMethod.insertAfter("System.out.println(\"(inserted) Class: " +  ctClass.getName() + " \");",false);
                            subCtMethod.insertAfter("System.out.println(\"(inserted) subClass: " +  subCtClass.getName() + " \");",false);
                            subCtMethod.insertAfter("System.out.println(\"subMethod: " +  subCtMethod.getName() + " \\n \");",false);

                        }

                    }
                    System.out.println("Finished\n");



                ctClass.writeFile("C:\\elasticsearch\\elasticsearch-7.5.2\\server\\build-idea\\classes\\main");
//                ctClass.writeFile("C:\\Users\\22071\\Desktop\\javacode\\verify");
//                ctClass.writeFile();
                ctClass.defrost();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return classfileBuffer;
        }


    }



}
