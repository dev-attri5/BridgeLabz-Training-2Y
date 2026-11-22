package com.String_Level3;

import java.util.Scanner;

public class Program9 {

    public static boolean isLeapYear(int year) {

        if (year % 400 == 0) {
            return true;
        }
        else if (year % 100 == 0) {
            return false;
        }
        else if (year % 4 == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public static int getDays(int month, int year) {

        if (month == 1 || month == 3 || month == 5 ||
                month == 7 || month == 8 || month == 10 ||
                month == 12) {

            return 31;
        }
        else if (month == 4 || month == 6 ||
                month == 9 || month == 11) {

            return 30;
        }
        else if (month == 2) {

            if (isLeapYear(year)) {
                return 29;
            }
            else {
                return 28;
            }
        }

        return 0;
    }

    public static String getMonthName(int month) {

        if (month == 1) {
            return "January";
        }
        else if (month == 2) {
            return "February";
        }
        else if (month == 3) {
            return "March";
        }
        else if (month == 4) {
            return "April";
        }
        else if (month == 5) {
            return "May";
        }
        else if (month == 6) {
            return "June";
        }
        else if (month == 7) {
            return "July";
        }
        else if (month == 8) {
            return "August";
        }
        else if (month == 9) {
            return "September";
        }
        else if (month == 10) {
            return "October";
        }
        else if (month == 11) {
            return "November";
        }
        else {
            return "December";
        }
    }

    public static int getFirstDay(int month, int year) {

        int totalDays = 0;

        for (int i = 1; i < year; i++) {

            if (isLeapYear(i)) {
                totalDays = totalDays + 366;
            }
            else {
                totalDays = totalDays + 365;
            }
        }

        for (int i = 1; i < month; i++) {
            totalDays = totalDays + getDays(i, year);
        }

        return (totalDays + 1) % 7;
    }

    public static void printCalendar(int month, int year) {

        String monthName = getMonthName(month);
        int days = getDays(month, year);
        int firstDay = getFirstDay(month, year);

        System.out.println("\n       " + monthName + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }

        for (int day = 1; day <= days; day++) {

            if (day < 10) {
                System.out.print("  " + day + " ");
            }
            else {
                System.out.print(" " + day + " ");
            }

            if ((day + firstDay) % 7 == 0) {
                System.out.println();
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();

        System.out.print("Enter year: ");
        int year = sc.nextInt();

        if (month >= 1 && month <= 12 && year >= 1) {
            printCalendar(month, year);
        }
        else {
            System.out.println("Invalid month or year!");
        }

        sc.close();
    }
}