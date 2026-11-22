package com.String_Level3;

import java.util.Scanner;

public class Program4 {

    public static String[][] getCharFrequency(String text) {
        int[] freq = new int[256];

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch] = freq[ch] + 1;
        }

        int count = 0;
        boolean[] visited = new boolean[256];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (!visited[ch]) {
                visited[ch] = true;
                count++;
            }
        }

        String[][] result = new String[count][2];
        boolean[] added = new boolean[256];
        int row = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (!added[ch]) {
                result[row][0] = "" + ch;
                result[row][1] = "" + freq[ch];
                added[ch] = true;
                row++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String[][] data = getCharFrequency(text);

        System.out.println("\nCharacter\tFrequency");
        System.out.println("-------------------------");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1]);
        }

        sc.close();
    }
}
