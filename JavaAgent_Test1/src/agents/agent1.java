package agents;

import javassist.*;
import javassist.expr.*;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
public class agent1 {

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static void premain(String agentArgs, Instrumentation instr) {
        System.out.println("Premain Start!");


        System.out.println("Premain End!");
    }



}
