package com.bsps.main.controller;

import com.bsps.board.controller.BoardController;
import com.bsps.book.controller.BookController;
import com.bsps.member.controller.MemberController;
import com.bsps.util.io.In;

public class Main {

    public static void main(String[] args) throws Exception {

        // 환영 인사
        System.out.println("---------------------------------");
        System.out.println(" 반갑습니다. 좋은 시간 되세요.~~~~~~");
        System.out.println("---------------------------------\n");

        // DB 클래스 로딩 확인
        try {
            Class.forName("com.bsps.util.db.DB");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("DB 클래스가 존재하지 않아 시스템을 종료합니다.");
            System.exit(1);
        }

        while (true) {
            // 메인 메뉴 출력
            System.out.println("<<< 메인 메뉴 >>>");
            System.out.println("=========================================");
            System.out.println(" 1. 회원관리  2. 일반게시판  3. 도서관리");
            System.out.println(" 0. 프로그램 종료");
            System.out.println("=========================================");

            String menu = In.getStr("메뉴 입력");
            System.out.println();

            switch (menu) {
            case "1":
                new MemberController().execute();
                break;

            case "2":
                new BoardController().execute();
                break;

            case "3":
                new BookController().execute();
                break;

            case "0":
                System.out.println("+---------------------------------------------------+");
                System.out.println(" 프로그램을 종료합니다.");
                System.out.println("+---------------------------------------------------+");
                System.exit(0);

            default:
                invalidMenuPrint();
            }

            System.out.println();
        }
    }

    private static void invalidMenuPrint() {
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println(" 잘못된 메뉴를 입력하셨습니다. 다시 입력해 주세요.");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    }
}
