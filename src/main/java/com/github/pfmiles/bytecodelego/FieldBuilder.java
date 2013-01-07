package com.github.pfmiles.bytecodelego;

import org.objectweb.asm.FieldVisitor;

/**
 * @author pf-miles
 * 
 */
public class FieldBuilder {

    private FieldVisitor fieldVisitor;

    public FieldBuilder(FieldVisitor fieldVisitor) {
        this.fieldVisitor = fieldVisitor;
    }

}
