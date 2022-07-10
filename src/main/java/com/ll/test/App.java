package com.ll.test;
import java.util.Scanner;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class App {
    public void run() {
        System.out.println("== The Quotes SSG ==");

        Scanner sc = new Scanner(System.in);

        //가장 마지막 명언글의 번호
        List<WiseSaying> wiseSayings = new ArrayList<>();
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
                    wiseSayings.add(wiseSaying);

                    System.out.printf("No.%d quote has been registered, successfully.\n", id);
                    break;
                case "list":
                    System.out.println("No. / Quote / Author");
                    System.out.println("-------------------");
                    for (int i = wiseSayings.size() - 1; i >= 0; i--) {
                        WiseSaying wiseSaying_ = wiseSayings.get(i);
                        System.out.printf("%d / %s / %s\n", wiseSaying_.id, wiseSaying_.content, wiseSaying_.author);
                    }
                    break;
                case "finish":
                    break outer;
            }
        }

        sc.close();
    }
}