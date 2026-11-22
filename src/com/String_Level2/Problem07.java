package com.String_Level2;
import java.util.Scanner;
public class Problem07 {

    public static int[] findTrimIndexes(String text) {
        int start = 0;
        int end = text.length() - 1;
        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }

        return new int[] { start, end };
    }
    public static String createSubstring(String text, int start, int end) {

        String result = "";

        for (int i = start; i <= end; i++) {
            result = result + text.charAt(i);
        }
        return result;
    }
    public static boolean compareStrings(String first, String second) {

        if (first.length() != second.length()) {
            return false;
        }

        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text with spaces at beginning or end: ");
        String text = sc.nextLine();
        int[] indexes = findTrimIndexes(text);
        String userTrimmed;
        if (indexes[0] > indexes[1]) {
            userTrimmed = "";
        } else {
            userTrimmed = createSubstring(text, indexes[0], indexes[1]);
        }

        String builtInTrimmed = text.trim();

        System.out.println("\nTrimmed using charAt(): [" + userTrimmed + "]");
        System.out.println("Trimmed using trim():   [" + builtInTrimmed + "]");

        System.out.println(
                "Both results are same: "
                        + compareStrings(userTrimmed, builtInTrimmed));

        sc.close();
    }
}