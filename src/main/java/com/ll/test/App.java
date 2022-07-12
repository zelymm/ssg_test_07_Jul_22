package com.ll.test;
import java.util.Scanner;

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

            Rq rq = new Rq(cmd);

            switch (rq.getPath()) {
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
                case "delete":
                    // URL에 입력된 id 얻기
                    int paramId = rq.getIntParam("id", 0);

                    // URL에 입력된 id가 없다면 작업중지
                    if (paramId == 0) {
                        System.out.println("id를 입력해주세요.");
                        continue;
                    }

                    // URL에 입력된 id에 해당하는 명언객체 찾기
                    WiseSaying wiseSaying__ = null;

                    for (WiseSaying wiseSaying___ : wiseSayings) {
                        if (wiseSaying___.id == paramId) {
                            wiseSaying__ = wiseSaying___;
                        }
                    }

                    // 찾지 못했다면 중지
                    if (wiseSaying__ == null) {
                        System.out.printf("%d번 명언은 존재하지 않습니다..\n", paramId);
                        continue;
                    }

                    // 입력된 id에 해당하는 명언객체를 리스트에서 삭제
                    wiseSayings.remove(wiseSaying__);

                    System.out.printf("%d번 명언이 삭제되었습니다.\n", paramId);
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