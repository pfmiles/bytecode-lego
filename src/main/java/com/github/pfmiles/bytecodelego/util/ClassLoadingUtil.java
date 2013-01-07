package com.github.pfmiles.bytecodelego.util;

/**
 * @author pf-miles
 * 
 */
public class ClassLoadingUtil {

    private static class ByteClassloader extends ClassLoader {

        private String name;
        private byte[] bs;

        public ByteClassloader(String name, byte[] clsBytes) {
            this.name = name;
            this.bs = clsBytes;
        }

        protected Class<?> findClass(String name) throws ClassNotFoundException {
            if (this.name.equals(name))
                return this.defineClass(name, bs, 0, bs.length);
            else
                return super.loadClass(name);
        }

    }

    public static Class<?> loadClsInstantly(String name, byte[] clsBytes) {
        ByteClassloader loader = new ByteClassloader(name, clsBytes);
        try {
            return loader.loadClass(name);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
