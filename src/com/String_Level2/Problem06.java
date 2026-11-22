package com.String_Level2;
import java.util.Scanner;
public class Problem06 {

    public static String checkCharacter(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }
        if (ch >= 'a' && ch <= 'z') {

            if (ch == 'a' || ch == 'e' || ch == 'i'
                    || ch == 'o' || ch == 'u') {
                return "Vowel";
            }
            return "Consonant";
        }
        return "Not a Letter";
    }
    public static String[][] getCharacterTypes(String text) {

        String[][] result = new String[text.length()][2];

        for (int i = 0; i < text.length(); i++) {
            result[i][0] = "" + text.charAt(i);
            result[i][1] = checkCharacter(text.charAt(i));
        }
        return result;
    }
    public static void displayTable(String[][] data) {
        System.out.println("\nCharacter\tType");

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[][] data = getCharacterTypes(text);

        displayTable(data);

        sc.close();
    }
}