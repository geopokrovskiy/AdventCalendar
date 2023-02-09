package com.geopokrovskiy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] sweets = new String[24];
        for (int i = 0; i < 24; i++) {
            sweets[i] = "\uD83C\uDF6C";
        }
        //day 0
        System.out.println("\uD83C\uDF84 \uD83C\uDF84 \uD83C\uDF84 \uD83C\uDF84 \uD83C\uDF84 WELCOME TO THE ADVENT CALENDAR! HO-HO-HO! " +
                "\uD83C\uDF84 \uD83C\uDF84 \uD83C\uDF84 \uD83C\uDF84 \uD83C\uDF84");
        AdventCalendar calendar = new AdventCalendar(sweets);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Today is day " + calendar.getDay() + " .Here is your advent calendar: ");
            System.out.println(calendar);
            System.out.println("What do you want to do?");
            System.out.println("1---TAKE A CANDY");
            System.out.println("2---SLEEP");
            System.out.println("3---GO BACK TO NOVEMBER, 30");
            System.out.println("4---EXIT");
            int input = scanner.nextInt();
            if (input == 1) {
                System.out.println(" \uD83C\uDF85 Which candy do you want to take, my child? \uD83C\uDF85");
                int numberOfCandy = scanner.nextInt();
                if (numberOfCandy > calendar.getDay()) {
                    System.out.println("\uD83C\uDF85 It's too early to take it, my darling! \uD83C\uDF85 ");
                } else if (numberOfCandy > 24 || numberOfCandy < 1) {
                    System.out.println(" \uD83E\uDD8C HO-HO-HO!...Try to choose correctly! \uD83E\uDD8C ");
                } else {
                    if (calendar.isDoorOpen(numberOfCandy)) {
                        System.out.println("You've taken that one!");
                    } else {
                        calendar.openDoor(numberOfCandy);
                        System.out.println("You've being a good child this year! Enjoy your candy.");
                    }
                }
            } else if (input == 2) {
                System.out.println(" ❄❄❄❄❄ For how many days do you want to sleep? ❄❄❄❄❄");
                int numberOfDays = scanner.nextInt();
                if (calendar.getDay() + numberOfDays > 24 || numberOfDays < 1) {
                    System.out.println("You cannot sleep too long or give your dreams to anyone!");
                } else {
                    calendar.nextDays(numberOfDays);
                }
            } else if (input == 3) {
                calendar.reset();
            } else if (input == 4) {
                break;
            }
        }
    }
}