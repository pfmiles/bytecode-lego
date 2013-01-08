package com.github.pfmiles.bytecodelego;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @author pf-miles
 * 
 */
public class MethodBuilder {

    private MethodVisitor methodVisitor;

    public MethodBuilder(MethodVisitor methodVisitor) {
        this.methodVisitor = methodVisitor;
    }

    public MethodBuilder return_() {
        this.methodVisitor.visitInsn(Opcodes.RETURN);
        return this;
    }

    public MethodBuilder invokespecial(String owner, String name, String desc) {
        this.methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, owner, name, desc);
        return this;
    }

    public MethodBuilder invokevirtual(String owner, String name, String desc) {
        this.methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, owner, name, desc);
        return this;
    }

    public MethodBuilder getstatic(String owner, String name, String desc) {
        this.methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, owner, name, desc);
        return this;
    }

    public MethodBuilder checkcast(String type) {
        this.methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, type);
        return this;
    }

    /**
     * <pre>
     * opcodes, from asm 4.0:
     *     int NOP = 0; // visitInsn
     *     int ACONST_NULL = 1; // -
     *     int ICONST_M1 = 2; // -
     *     int ICONST_0 = 3; // -
     *     int ICONST_1 = 4; // -
     *     int ICONST_2 = 5; // -
     *     int ICONST_3 = 6; // -
     *     int ICONST_4 = 7; // -
     *     int ICONST_5 = 8; // -
     *     int LCONST_0 = 9; // -
     *     int LCONST_1 = 10; // -
     *     int FCONST_0 = 11; // -
     *     int FCONST_1 = 12; // -
     *     int FCONST_2 = 13; // -
     *     int DCONST_0 = 14; // -
     *     int DCONST_1 = 15; // -
     *     int BIPUSH = 16; // visitIntInsn
     *     int SIPUSH = 17; // -
     *     int LDC = 18; // visitLdcInsn
     *     // int LDC_W = 19; // -
     *     // int LDC2_W = 20; // -
     *     int ILOAD = 21; // visitVarInsn
     *     int LLOAD = 22; // -
     *     int FLOAD = 23; // -
     *     int DLOAD = 24; // -
     *     int ALOAD = 25; // -
     *     // int ILOAD_0 = 26; // -
     *     // int ILOAD_1 = 27; // -
     *     // int ILOAD_2 = 28; // -
     *     // int ILOAD_3 = 29; // -
     *     // int LLOAD_0 = 30; // -
     *     // int LLOAD_1 = 31; // -
     *     // int LLOAD_2 = 32; // -
     *     // int LLOAD_3 = 33; // -
     *     // int FLOAD_0 = 34; // -
     *     // int FLOAD_1 = 35; // -
     *     // int FLOAD_2 = 36; // -
     *     // int FLOAD_3 = 37; // -
     *     // int DLOAD_0 = 38; // -
     *     // int DLOAD_1 = 39; // -
     *     // int DLOAD_2 = 40; // -
     *     // int DLOAD_3 = 41; // -
     *     // int ALOAD_0 = 42; // -
     *     // int ALOAD_1 = 43; // -
     *     // int ALOAD_2 = 44; // -
     *     // int ALOAD_3 = 45; // -
     *     int IALOAD = 46; // visitInsn array load
     *     int LALOAD = 47; // -
     *     int FALOAD = 48; // -
     *     int DALOAD = 49; // -
     *     int AALOAD = 50; // -
     *     int BALOAD = 51; // -
     *     int CALOAD = 52; // -
     *     int SALOAD = 53; // -
     *     int ISTORE = 54; // visitVarInsn store
     *     int LSTORE = 55; // -
     *     int FSTORE = 56; // -
     *     int DSTORE = 57; // -
     *     int ASTORE = 58; // -
     *     // int ISTORE_0 = 59; // -
     *     // int ISTORE_1 = 60; // -
     *     // int ISTORE_2 = 61; // -
     *     // int ISTORE_3 = 62; // -
     *     // int LSTORE_0 = 63; // -
     *     // int LSTORE_1 = 64; // -
     *     // int LSTORE_2 = 65; // -
     *     // int LSTORE_3 = 66; // -
     *     // int FSTORE_0 = 67; // -
     *     // int FSTORE_1 = 68; // -
     *     // int FSTORE_2 = 69; // -
     *     // int FSTORE_3 = 70; // -
     *     // int DSTORE_0 = 71; // -
     *     // int DSTORE_1 = 72; // -
     *     // int DSTORE_2 = 73; // -
     *     // int DSTORE_3 = 74; // -
     *     // int ASTORE_0 = 75; // -
     *     // int ASTORE_1 = 76; // -
     *     // int ASTORE_2 = 77; // -
     *     // int ASTORE_3 = 78; // -
     *     int IASTORE = 79; // visitInsn array store and arithmatic
     *     int LASTORE = 80; // -
     *     int FASTORE = 81; // -
     *     int DASTORE = 82; // -
     *     int AASTORE = 83; // -
     *     int BASTORE = 84; // -
     *     int CASTORE = 85; // -
     *     int SASTORE = 86; // -
     *     int POP = 87; // -
     *     int POP2 = 88; // -
     *     int DUP = 89; // -
     *     int DUP_X1 = 90; // -
     *     int DUP_X2 = 91; // -
     *     int DUP2 = 92; // -
     *     int DUP2_X1 = 93; // -
     *     int DUP2_X2 = 94; // -
     *     int SWAP = 95; // -
     *     int IADD = 96; // -
     *     int LADD = 97; // -
     *     int FADD = 98; // -
     *     int DADD = 99; // -
     *     int ISUB = 100; // -
     *     int LSUB = 101; // -
     *     int FSUB = 102; // -
     *     int DSUB = 103; // -
     *     int IMUL = 104; // -
     *     int LMUL = 105; // -
     *     int FMUL = 106; // -
     *     int DMUL = 107; // -
     *     int IDIV = 108; // -
     *     int LDIV = 109; // -
     *     int FDIV = 110; // -
     *     int DDIV = 111; // -
     *     int IREM = 112; // -
     *     int LREM = 113; // -
     *     int FREM = 114; // -
     *     int DREM = 115; // -
     *     int INEG = 116; // -
     *     int LNEG = 117; // -
     *     int FNEG = 118; // -
     *     int DNEG = 119; // -
     *     int ISHL = 120; // -
     *     int LSHL = 121; // -
     *     int ISHR = 122; // -
     *     int LSHR = 123; // -
     *     int IUSHR = 124; // -
     *     int LUSHR = 125; // -
     *     int IAND = 126; // -
     *     int LAND = 127; // -
     *     int IOR = 128; // -
     *     int LOR = 129; // -
     *     int IXOR = 130; // -
     *     int LXOR = 131; // -
     *     int IINC = 132; // visitIincInsn
     *     int I2L = 133; // visitInsn conversion and compare
     *     int I2F = 134; // -
     *     int I2D = 135; // -
     *     int L2I = 136; // -
     *     int L2F = 137; // -
     *     int L2D = 138; // -
     *     int F2I = 139; // -
     *     int F2L = 140; // -
     *     int F2D = 141; // -
     *     int D2I = 142; // -
     *     int D2L = 143; // -
     *     int D2F = 144; // -
     *     int I2B = 145; // -
     *     int I2C = 146; // -
     *     int I2S = 147; // -
     *     int LCMP = 148; // -
     *     int FCMPL = 149; // -
     *     int FCMPG = 150; // -
     *     int DCMPL = 151; // -
     *     int DCMPG = 152; // -
     *     int IFEQ = 153; // visitJumpInsn
     *     int IFNE = 154; // -
     *     int IFLT = 155; // -
     *     int IFGE = 156; // -
     *     int IFGT = 157; // -
     *     int IFLE = 158; // -
     *     int IF_ICMPEQ = 159; // -
     *     int IF_ICMPNE = 160; // -
     *     int IF_ICMPLT = 161; // -
     *     int IF_ICMPGE = 162; // -
     *     int IF_ICMPGT = 163; // -
     *     int IF_ICMPLE = 164; // -
     *     int IF_ACMPEQ = 165; // -
     *     int IF_ACMPNE = 166; // -
     *     int GOTO = 167; // -
     *     int JSR = 168; // -
     *     int RET = 169; // visitVarInsn ret
     *     int TABLESWITCH = 170; // visiTableSwitchInsn
     *     int LOOKUPSWITCH = 171; // visitLookupSwitch
     *     int IRETURN = 172; // visitInsn return
     *     int LRETURN = 173; // -
     *     int FRETURN = 174; // -
     *     int DRETURN = 175; // -
     *     int ARETURN = 176; // -
     *     int RETURN = 177; // -
     *     int GETSTATIC = 178; // visitFieldInsn
     *     int PUTSTATIC = 179; // -
     *     int GETFIELD = 180; // -
     *     int PUTFIELD = 181; // -
     *     int INVOKEVIRTUAL = 182; // visitMethodInsn
     *     int INVOKESPECIAL = 183; // -
     *     int INVOKESTATIC = 184; // -
     *     int INVOKEINTERFACE = 185; // -
     *     // int UNUSED = 186; // NOT VISITED
     *     int NEW = 187; // visitTypeInsn new
     *     int NEWARRAY = 188; // visitIntInsn new primitive array
     *     int ANEWARRAY = 189; // visitTypeInsn new reference array
     *     int ARRAYLENGTH = 190; // visitInsn arr length
     *     int ATHROW = 191; // -
     *     int CHECKCAST = 192; // visitTypeInsn cast
     *     int INSTANCEOF = 193; // -
     *     int MONITORENTER = 194; // visitInsn monitor
     *     int MONITOREXIT = 195; // -
     *     // int WIDE = 196; // NOT VISITED
     *     int MULTIANEWARRAY = 197; // visitMultiANewArrayInsn
     *     int IFNULL = 198; // visitJumpInsn goto
     *     int IFNONNULL = 199; // -
     *     // int GOTO_W = 200; // -
     *     // int JSR_W = 201; // -
     * </pre>
     */
    public MethodBuilder nop() {
        this.methodVisitor.visitInsn(Opcodes.NOP);
        return this;
    }

    public MethodBuilder aconst_null() {
        this.methodVisitor.visitInsn(Opcodes.ACONST_NULL);
        return this;
    }

    public MethodBuilder iconst_m1() {
        this.methodVisitor.visitInsn(Opcodes.ICONST_M1);
        return this;
    }

    public MethodBuilder iconst_0() {
        this.methodVisitor.visitInsn(Opcodes.ICONST_0);
        return this;
    }

    public MethodBuilder iconst_1() {
        this.methodVisitor.visitInsn(Opcodes.ICONST_1);
        return this;
    }

    public MethodBuilder iconst_2() {
        this.methodVisitor.visitInsn(Opcodes.ICONST_2);
        return this;
    }

    public MethodBuilder iconst_3() {
        this.methodVisitor.visitInsn(Opcodes.ICONST_3);
        return this;
    }

    public MethodBuilder iconst_4() {
        this.methodVisitor.visitInsn(Opcodes.ICONST_4);
        return this;
    }

    public MethodBuilder iconst_5() {
        this.methodVisitor.visitInsn(Opcodes.ICONST_5);
        return this;
    }

    public MethodBuilder lconst_0() {
        this.methodVisitor.visitInsn(Opcodes.LCONST_0);
        return this;
    }

    public MethodBuilder lconst_1() {
        this.methodVisitor.visitInsn(Opcodes.LCONST_1);
        return this;
    }

    public MethodBuilder fconst_0() {
        this.methodVisitor.visitInsn(Opcodes.FCONST_0);
        return this;
    }

    public MethodBuilder fconst_1() {
        this.methodVisitor.visitInsn(Opcodes.FCONST_1);
        return this;
    }

    public MethodBuilder fconst_2() {
        this.methodVisitor.visitInsn(Opcodes.FCONST_2);
        return this;
    }

    public MethodBuilder dconst_0() {
        this.methodVisitor.visitInsn(Opcodes.DCONST_0);
        return this;
    }

    public MethodBuilder dconst_1() {
        this.methodVisitor.visitInsn(Opcodes.DCONST_1);
        return this;
    }

    public MethodBuilder bipush(int operand) {
        this.methodVisitor.visitIntInsn(Opcodes.BIPUSH, operand);
        return this;
    }

    public MethodBuilder sipush(int operand) {
        this.methodVisitor.visitIntInsn(Opcodes.SIPUSH, operand);
        return this;
    }

    public MethodBuilder ldc(Object cst) {
        this.methodVisitor.visitLdcInsn(cst);
        return this;
    }

    public MethodBuilder ldc_w(Object cst) {
        this.methodVisitor.visitLdcInsn(cst);
        return this;
    }

    public MethodBuilder ldc2_w(Object cst) {
        this.methodVisitor.visitLdcInsn(cst);
        return this;
    }

    public MethodBuilder iload(int var) {
        this.methodVisitor.visitVarInsn(Opcodes.ILOAD, var);
        return this;
    }

    public MethodBuilder lload(int var) {
        this.methodVisitor.visitVarInsn(Opcodes.LLOAD, var);
        return this;
    }

    public MethodBuilder fload(int var) {
        this.methodVisitor.visitVarInsn(Opcodes.FLOAD, var);
        return this;
    }

    public MethodBuilder dload(int var) {
        this.methodVisitor.visitVarInsn(Opcodes.DLOAD, var);
        return this;
    }

    public MethodBuilder aload(int var) {
        this.methodVisitor.visitVarInsn(Opcodes.ALOAD, var);
        return this;
    }

    public MethodBuilder iload_0() {
        this.methodVisitor.visitVarInsn(Opcodes.ILOAD, 0);
        return this;
    }

    public MethodBuilder iload_1() {
        this.methodVisitor.visitVarInsn(Opcodes.ILOAD, 1);
        return this;
    }

    public MethodBuilder iload_2() {
        this.methodVisitor.visitVarInsn(Opcodes.ILOAD, 2);
        return this;
    }

    public MethodBuilder iload_3() {
        this.methodVisitor.visitVarInsn(Opcodes.ILOAD, 3);
        return this;
    }

    public MethodBuilder lload_0() {
        this.methodVisitor.visitVarInsn(Opcodes.LLOAD, 0);
        return this;
    }

    public MethodBuilder lload_1() {
        this.methodVisitor.visitVarInsn(Opcodes.LLOAD, 1);
        return this;
    }

    public MethodBuilder lload_2() {
        this.methodVisitor.visitVarInsn(Opcodes.LLOAD, 2);
        return this;
    }

    public MethodBuilder lload_3() {
        this.methodVisitor.visitVarInsn(Opcodes.LLOAD, 3);
        return this;
    }

    public MethodBuilder fload_0() {
        this.methodVisitor.visitVarInsn(Opcodes.FLOAD, 0);
        return this;
    }

    public MethodBuilder fload_1() {
        this.methodVisitor.visitVarInsn(Opcodes.FLOAD, 1);
        return this;
    }

    public MethodBuilder fload_2() {
        this.methodVisitor.visitVarInsn(Opcodes.FLOAD, 2);
        return this;
    }

    public MethodBuilder fload_3() {
        this.methodVisitor.visitVarInsn(Opcodes.FLOAD, 3);
        return this;
    }

    public MethodBuilder dload_0() {
        this.methodVisitor.visitVarInsn(Opcodes.DLOAD, 0);
        return this;
    }

    public MethodBuilder dload_1() {
        this.methodVisitor.visitVarInsn(Opcodes.DLOAD, 1);
        return this;
    }

    public MethodBuilder dload_2() {
        this.methodVisitor.visitVarInsn(Opcodes.DLOAD, 2);
        return this;
    }

    public MethodBuilder dload_3() {
        this.methodVisitor.visitVarInsn(Opcodes.DLOAD, 3);
        return this;
    }

    public MethodBuilder aload_0() {
        this.methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
        return this;
    }

    public MethodBuilder aload_1() {
        this.methodVisitor.visitVarInsn(Opcodes.ALOAD, 1);
        return this;
    }

    public MethodBuilder aload_2() {
        this.methodVisitor.visitVarInsn(Opcodes.ALOAD, 2);
        return this;
    }

    public MethodBuilder aload_3() {
        this.methodVisitor.visitVarInsn(Opcodes.ALOAD, 3);
        return this;
    }

    public MethodBuilder iaload() {
        this.methodVisitor.visitInsn(Opcodes.IALOAD);
        return this;
    }

    public MethodBuilder laload() {
        this.methodVisitor.visitInsn(Opcodes.LALOAD);
        return this;
    }

    public MethodBuilder faload() {
        this.methodVisitor.visitInsn(Opcodes.FALOAD);
        return this;
    }

    public MethodBuilder daload() {
        this.methodVisitor.visitInsn(Opcodes.DALOAD);
        return this;
    }

    public MethodBuilder aaload() {
        this.methodVisitor.visitInsn(Opcodes.AALOAD);
        return this;
    }

    public MethodBuilder baload() {
        this.methodVisitor.visitInsn(Opcodes.BALOAD);
        return this;
    }

    public MethodBuilder caload() {
        this.methodVisitor.visitInsn(Opcodes.CALOAD);
        return this;
    }

    public MethodBuilder saload() {
        this.methodVisitor.visitInsn(Opcodes.SALOAD);
        return this;
    }

    public MethodBuilder istore(int var) {
        this.methodVisitor.visitVarInsn(Opcodes.ISTORE, var);
        return this;
    }

    public MethodBuilder lstore(int var) {
        this.methodVisitor.visitVarInsn(Opcodes.LSTORE, var);
        return this;
    }

    public MethodBuilder fstore(int var) {
        this.methodVisitor.visitVarInsn(Opcodes.FSTORE, var);
        return this;
    }

    public MethodBuilder dstore(int var) {
        this.methodVisitor.visitVarInsn(Opcodes.DSTORE, var);
        return this;
    }

    public MethodBuilder astore(int var) {
        this.methodVisitor.visitVarInsn(Opcodes.ASTORE, var);
        return this;
    }

    public MethodBuilder istore_0() {
        this.methodVisitor.visitVarInsn(Opcodes.ISTORE, 0);
        return this;
    }

    public MethodBuilder istore_1() {
        this.methodVisitor.visitVarInsn(Opcodes.ISTORE, 1);
        return this;
    }

    public MethodBuilder istore_2() {
        this.methodVisitor.visitVarInsn(Opcodes.ISTORE, 2);
        return this;
    }

    public MethodBuilder istore_3() {
        this.methodVisitor.visitVarInsn(Opcodes.ISTORE, 3);
        return this;
    }

    public MethodBuilder lstore_0() {
        this.methodVisitor.visitVarInsn(Opcodes.LSTORE, 0);
        return this;
    }

    public MethodBuilder lstore_1() {
        this.methodVisitor.visitVarInsn(Opcodes.ISTORE, 1);
        return this;
    }

    public MethodBuilder lstore_2() {
        this.methodVisitor.visitVarInsn(Opcodes.ISTORE, 2);
        return this;
    }

    public MethodBuilder lstore_3() {
        this.methodVisitor.visitVarInsn(Opcodes.ISTORE, 3);
        return this;
    }

    public MethodBuilder fstore_0() {
        this.methodVisitor.visitVarInsn(Opcodes.FSTORE, 0);
        return this;
    }

    public MethodBuilder fstore_1() {
        this.methodVisitor.visitVarInsn(Opcodes.FSTORE, 1);
        return this;
    }

    public MethodBuilder fstore_2() {
        this.methodVisitor.visitVarInsn(Opcodes.FSTORE, 2);
        return this;
    }

    public MethodBuilder fstore_3() {
        this.methodVisitor.visitVarInsn(Opcodes.FSTORE, 3);
        return this;
    }

    public MethodBuilder dstore_0() {
        this.methodVisitor.visitVarInsn(Opcodes.DSTORE, 0);
        return this;
    }

    public MethodBuilder dstore_1() {
        this.methodVisitor.visitVarInsn(Opcodes.DSTORE, 1);
        return this;
    }

    public MethodBuilder dstore_2() {
        this.methodVisitor.visitVarInsn(Opcodes.DSTORE, 2);
        return this;
    }

    public MethodBuilder dstore_3() {
        this.methodVisitor.visitVarInsn(Opcodes.DSTORE, 3);
        return this;
    }

    public MethodBuilder astore_0() {
        this.methodVisitor.visitVarInsn(Opcodes.ASTORE, 0);
        return this;
    }

    public MethodBuilder astore_1() {
        this.methodVisitor.visitVarInsn(Opcodes.ASTORE, 1);
        return this;
    }

    public MethodBuilder astore_2() {
        this.methodVisitor.visitVarInsn(Opcodes.ASTORE, 2);
        return this;
    }

    public MethodBuilder astore_3() {
        this.methodVisitor.visitVarInsn(Opcodes.ASTORE, 3);
        return this;
    }

    /*
     * int IASTORE = 79; // visitInsn array store and arithmatic int LASTORE =
     * 80; // - int FASTORE = 81; // - int DASTORE = 82; // - int AASTORE = 83;
     * // - int BASTORE = 84; // - int CASTORE = 85; // - int SASTORE = 86; // -
     * int POP = 87; // - int POP2 = 88; // - int DUP = 89; // - int DUP_X1 =
     * 90; // - int DUP_X2 = 91; // - int DUP2 = 92; // - int DUP2_X1 = 93; // -
     * int DUP2_X2 = 94; // - int SWAP = 95; // - int IADD = 96; // - int LADD =
     * 97; // - int FADD = 98; // - int DADD = 99; // - int ISUB = 100; // - int
     * LSUB = 101; // - int FSUB = 102; // - int DSUB = 103; // - int IMUL =
     * 104; // - int LMUL = 105; // - int FMUL = 106; // - int DMUL = 107; // -
     * int IDIV = 108; // - int LDIV = 109; // - int FDIV = 110; // - int DDIV =
     * 111; // - int IREM = 112; // - int LREM = 113; // - int FREM = 114; // -
     * int DREM = 115; // - int INEG = 116; // - int LNEG = 117; // - int FNEG =
     * 118; // - int DNEG = 119; // - int ISHL = 120; // - int LSHL = 121; // -
     * int ISHR = 122; // - int LSHR = 123; // - int IUSHR = 124; // - int LUSHR
     * = 125; // - int IAND = 126; // - int LAND = 127; // - int IOR = 128; // -
     * int LOR = 129; // - int IXOR = 130; // - int LXOR = 131; // -
     */
    public MethodBuilder iastore() {
        this.methodVisitor.visitInsn(Opcodes.IASTORE);
        return this;
    }

    public MethodBuilder lastore() {
        this.methodVisitor.visitInsn(Opcodes.LASTORE);
        return this;
    }

    public MethodBuilder fastore() {
        this.methodVisitor.visitInsn(Opcodes.FASTORE);
        return this;
    }

    public MethodBuilder dastore() {
        this.methodVisitor.visitInsn(Opcodes.DASTORE);
        return this;
    }

    public MethodBuilder aastore() {
        this.methodVisitor.visitInsn(Opcodes.AASTORE);
        return this;
    }

    public MethodBuilder bastore() {
        this.methodVisitor.visitInsn(Opcodes.BASTORE);
        return this;
    }

    public MethodBuilder castore() {
        this.methodVisitor.visitInsn(Opcodes.CASTORE);
        return this;
    }

    public MethodBuilder sastore() {
        this.methodVisitor.visitInsn(Opcodes.SASTORE);
        return this;
    }

    public MethodBuilder pop() {
        this.methodVisitor.visitInsn(Opcodes.POP);
        return this;
    }

    public MethodBuilder pop2() {
        this.methodVisitor.visitInsn(Opcodes.POP2);
        return this;
    }

    public MethodBuilder dup() {
        this.methodVisitor.visitInsn(Opcodes.DUP);
        return this;
    }

    public MethodBuilder dup_x1() {
        this.methodVisitor.visitInsn(Opcodes.DUP_X1);
        return this;
    }

    public MethodBuilder dup_x2() {
        this.methodVisitor.visitInsn(Opcodes.DUP_X2);
        return this;
    }

    public MethodBuilder dup2() {
        this.methodVisitor.visitInsn(Opcodes.DUP2);
        return this;
    }

    public MethodBuilder dup2_x1() {
        this.methodVisitor.visitInsn(Opcodes.DUP2_X1);
        return this;
    }

    public MethodBuilder dup2_x2() {
        this.methodVisitor.visitInsn(Opcodes.DUP2_X2);
        return this;
    }

    public MethodBuilder swap() {
        this.methodVisitor.visitInsn(Opcodes.SWAP);
        return this;
    }
}
