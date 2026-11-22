package com.Java_Strings;

public class Program04_Compare_StringBuffer_StringBuilder {

    public static void main(String[] args) {
        int iterations = 1000000;

        StringBuffer sbf = new StringBuffer();
        long startBuffer = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            sbf.append("hello");
        }
        long endBuffer = System.nanoTime();
        long bufferTime = endBuffer - startBuffer;

        StringBuilder sbd = new StringBuilder();
        long startBuilder = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            sbd.append("hello");
        }
        long endBuilder = System.nanoTime();
        long builderTime = endBuilder - startBuilder;

        System.out.println("Time taken for 1,000,000 concatenations:");
        System.out.println("StringBuffer time (ns) : " + bufferTime);
        System.out.println("StringBuilder time (ns): " + builderTime);
    }
}
