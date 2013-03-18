package com.github.pfmiles.bytecodelego;

import java.lang.reflect.Method;

import junit.framework.TestCase;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;

import com.github.pfmiles.bytecodelego.util.ClassLoadingUtil;

/**
 * @author pf-miles
 * 
 */
public class SimpleTryCatchTest extends TestCase {
    public void testSimpleTryCatch() throws Exception {
        ClsBuilder b = new ClsBuilder(Opcodes.V1_7, Opcodes.ACC_PUBLIC, "test/TestGen", null, "java/lang/Object", null, ClassWriter.COMPUTE_FRAMES);
        MethodBuilder method = b.newMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC, "method", "()V", null, null, 0, 0);
        method.new_("java/lang/Exception");
        method.dup();
        method.ldc("Hello Exception!");
        method.invokespecial("java/lang/Exception", "<init>", "(Ljava/lang/String;)V");
        Label begin = method.newLabel();
        method.athrow();
        Label end = method.newLabel();
        Label handle = method.newLabel();

        method.getstatic("java/lang/System", "out", "Ljava/io/PrintStream;");
        method.ldc("Exception catched: ");
        method.invokevirtual("java/io/PrintStream", "println", "(Ljava/lang/String;)V");
        method.astore_0();
        method.getstatic("java/lang/System", "out", "Ljava/io/PrintStream;");
        method.aload_0();
        method.invokevirtual("java/lang/Throwable", "getMessage", "()Ljava/lang/String;");
        method.invokevirtual("java/io/PrintStream", "println", "(Ljava/lang/String;)V");

        method.tryCatchBlock(begin, end, handle, "java/lang/Exception");

        method.return_();

        byte[] bytes = b.toByteArray();
        Class<?> cls = ClassLoadingUtil.loadClsInstantly("test.TestGen", bytes);
        Method m = cls.getMethod("method");
        m.invoke(null);
    }
}
