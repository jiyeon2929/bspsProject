package com.bsps.rent.controller;

import com.bsps.rent.service.RentService;
import com.bsps.util.io.In;

public class RentController {

    private RentService service = new RentService();

    // ⭐ 대출/반납 메인 메뉴 (입구)
    public void execute() throws Exception {

        while (true) {
            System.out.println("\n<<< 대출 / 반납 관리 >>>");
            System.out.println("=========================================");
            System.out.println(" 1. 도서 대출");
            System.out.println(" 2. 도서 반납");
            System.out.println(" 0. 이전 메뉴");
            System.out.println("=========================================");

            String menu = In.getStr("메뉴 입력");

            switch (menu) {
            case "1":
                rent();
                break;
            case "2":
                returnBook();
                break;
            case "0":
                return;
            default:
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    // 대출
    private void rent() throws Exception {

        System.out.println("\n<책 대출 처리>");

        String title = In.getStr("제목");
        In.getStr("출판사");
        In.getStr("작성자");
        String pw = In.getStr("비밀번호");

        service.rentBook("test", title, pw);

        System.out.println("******* 대출 완료 되었습니다. ********");
    }

    // 반납
    private void returnBook() throws Exception {

        System.out.println("\n<책 반납 처리>");

        int no = Integer.parseInt(In.getStr("글 번호"));
        String pw = In.getStr("본인 확인용 비밀번호");

        boolean result = service.returnBook(no, pw);

        if (result) {
            System.out.println("******* 반납 완료 되었습니다. ********");
        } else {
            System.out.println("⚠ 글 번호 또는 비밀번호가 올바르지 않습니다.");
        }
    }
}
