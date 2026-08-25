package com.Strings;

import java.util.Scanner;

public class excelSheet {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your string: ");

        String  columnTitle= sc.nextLine();
        String columnTitleUpperCase = columnTitle.toUpperCase();
        int ans;
     ans = titleToNumber(columnTitleUpperCase);
        System.out.println(ans);

    }

        public static int titleToNumber(String columnTitleUpperCase) {
            int result = 0;

            for (int i = 0; i < columnTitleUpperCase.length(); i++) {
                result = result * 26 + (columnTitleUpperCase.charAt(i) - 'A' + 1);
            }

            return result;
        }
}
