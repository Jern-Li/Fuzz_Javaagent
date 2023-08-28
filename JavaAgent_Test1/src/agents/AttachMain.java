package agents;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.ArrayList;
import java.util.List;

public class AttachMain {

    public static void main(String[] args) throws Exception {
        List<VirtualMachineDescriptor> listBefore = VirtualMachine.list();
        // jar of agentmain()
        String jar = "C:\\Users\\22071\\Desktop\\javacode\\JavaAgent_Test1\\out\\artifacts\\agent3\\JavaAgent_Test1.jar";

        System.out.println("GET in !");

        for (VirtualMachineDescriptor virtualMachineDescriptor : VirtualMachine.list()) {

            // ES should have more than one node
            if (virtualMachineDescriptor.displayName().equals("org.elasticsearch.bootstrap.Elasticsearch")) {
                System.out.println("Target VM pid=" + virtualMachineDescriptor.id());

                VirtualMachine vm = VirtualMachine.attach(virtualMachineDescriptor);
                vm.loadAgent(jar);
                vm.detach();
            }
        }

        RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
        String jvmName = runtimeMxBean.getName();
        String jvmSpecVersion = System.getProperty("java.vm.specification.version");
        String jvmImplVersion = System.getProperty("java.vm.version");
        String jvmVendor = runtimeMxBean.getVmVendor();

        // info of self JVM
        System.out.println("JVM Name: " + jvmName);
        System.out.println("JVM Specification Version: " + jvmSpecVersion);
        System.out.println("JVM Implementation Version: " + jvmImplVersion);
        System.out.println("JVM Vendor: " + jvmVendor);

        System.out.println(System.getProperty("java.class.path"));

    }


}
