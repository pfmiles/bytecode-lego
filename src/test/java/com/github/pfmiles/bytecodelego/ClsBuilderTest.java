package com.github.pfmiles.bytecodelego;

import java.lang.reflect.Method;

import junit.framework.TestCase;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import com.github.pfmiles.bytecodelego.util.ClassLoadingUtil;

/**
 * @author pf-miles
 * 
 */
public class ClsBuilderTest extends TestCase {

    public void testBuild() throws Throwable {
        ClsBuilder b = new ClsBuilder(Opcodes.V1_6, Opcodes.ACC_PUBLIC, "test/TestGenCls", null, "java/lang/Object", null, ClassWriter.COMPUTE_FRAMES);

        MethodBuilder c = b.newMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null, 0, 0);
        c.aload_0();
        c.invokespecial("java/lang/Object", "<init>", "()V");
        c.return_();

        MethodBuilder main = b.newMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null, 0, 0);
        main.getstatic("java/lang/System", "out", "Ljava/io/PrintStream;");
        main.ldc("Hello World!");
        main.invokevirtual("java/io/PrintStream", "println", "(Ljava/lang/String;)V");
        main.return_();

        byte[] bytes = b.toByteArray();
        Class<?> cls = ClassLoadingUtil.loadClsInstantly("test.TestGenCls", bytes);
        Method m = cls.getMethod("main", String[].class);
        m.invoke(null, new Object[] { new String[0] });
        assertTrue(true);// this program should print out 'Hello world!'
    }
}
