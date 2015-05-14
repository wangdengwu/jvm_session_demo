package com.thoughtworks.session;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;

/**
 * -verbose：class -Xnoclassgc -XX:PermSize=5M -XX:MaxPermSize=5M
 */
public class JavaMethodAreaOOM {

    public static void main(String[] args) throws ClassNotFoundException {
        int i = 0;
        MySelfClassLoader classLoader = new MySelfClassLoader();
        while (true) {
            ClassNode cn = new ClassNode();
            cn.version = Opcodes.V1_6;
            cn.access = Opcodes.ACC_PUBLIC;
            cn.name = "com/thoughtworks/session/Demo"+i++;
            cn.superName = "java/lang/Object";
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
            cn.accept(cw);
            classLoader.defineClass(cw.toByteArray());
        }
    }
}

class MySelfClassLoader extends ClassLoader {

    protected Class<?> defineClass(byte[] classBytes) throws ClassNotFoundException {
        if (classBytes != null) {
            return defineClass(null, classBytes, 0, classBytes.length);
        }
        return null;
    }
}
