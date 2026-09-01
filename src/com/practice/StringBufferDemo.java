package com.practice;


    public class StringBufferDemo {
        public static void main(String[] args) {

            StringBuffer sb = new StringBuffer("Hello");

            sb.append(" World");
            System.out.println("append(): " + sb);

            sb.insert(5, ",");
            System.out.println("insert(): " + sb);

            sb.replace(0, 5, "Hi");
            System.out.println("replace(): " + sb);

            sb.delete(2, 3);
            System.out.println("delete(): " + sb);

            sb.deleteCharAt(2);
            System.out.println("deleteCharAt(): " + sb);

            System.out.println("charAt(1): " + sb.charAt(1));

            sb.setCharAt(0, 'B');
            System.out.println("setCharAt(): " + sb);

            System.out.println("length(): " + sb.length());

            System.out.println("capacity(): " + sb.capacity());

            sb.reverse();
            System.out.println("reverse(): " + sb);

            String str = sb.toString();
            System.out.println("toString(): " + str);
        }
    }
