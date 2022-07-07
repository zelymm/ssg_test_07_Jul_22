package com.ll.test;
import java.util.Scanner;

public class App {
    public void run() {
        System.out.println("== The Quotes SSG ==");

        Scanner sc = new Scanner(System.in);

        outer:
        while (true) {
            System.out.printf("Input) ");
            String cmd = sc.nextLine().trim();

            switch (cmd) {
                case "insert":
                    System.out.printf("Quote : ");
                    String content = sc.nextLine().trim();
                    System.out.printf("Author : ");
                    String author = sc.nextLine().trim();
                    System.out.println("The quote has been registered.");
                    break;
                case "finish":
                    break outer;
            }
        }

        sc.close();
    }
}