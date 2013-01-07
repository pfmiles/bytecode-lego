package com.github.pfmiles.bytecodelego.impl;

import org.objectweb.asm.MethodVisitor;

/**
 * @author pf-miles
 * 
 */
public class MethodDef {
    private MethodVisitor methodVisitor;
    private int maxStack;
    private int maxLocals;

    public MethodDef(MethodVisitor mv, int maxStack, int maxLocals) {
        this.methodVisitor = mv;
        this.maxStack = maxStack;
        this.maxLocals = maxLocals;
    }

    public MethodVisitor getMethodVisitor() {
        return this.methodVisitor;
    }

    public int getMaxStack() {
        return maxStack;
    }

    public int getMaxLocals() {
        return maxLocals;
    }

}
