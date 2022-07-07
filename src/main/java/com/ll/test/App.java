package com.ll.test;
import java.util.Scanner;

public class App {
    public void run() {
        System.out.println("== The Quotes SSG ==");

        Scanner sc = new Scanner(System.in);

        //가장 마지막 명언글의 번호
        int wiseSayingLastId = 0;

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
                    int id = ++wiseSayingLastId; //명언 글 번호 증가

                    WiseSaying wiseSaying = new WiseSaying(id, content, author);
                    System.out.println(wiseSaying);

                    System.out.printf("No.%d quote has been registered, successfully.\n", id);
                    break;
                case "finish":
                    break outer;
            }
        }

        sc.close();
    }
}