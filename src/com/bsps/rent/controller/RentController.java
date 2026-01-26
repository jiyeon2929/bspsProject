package com.bsps.rent.controller;

import java.util.List;

import com.bsps.rent.service.RentService;
import com.bsps.rent.vo.RentVO;
import com.bsps.util.io.In;

public class RentController {

    private RentService service = new RentService();

    public void execute() throws Exception {
        while (true) {
            System.out.println("\n<<< 대출/반납 하기 >>>");
            System.out.println("1. 도서대출  2. 도서반납  3. 리스트  0. 이전");
            String menu = In.getStr("메뉴");

            switch (menu) {
            case "1":
                rent();
                break;
            case "2":
                returnBook();
                break;
            case "3":
                list();
                break;
            case "0":
                return;
            }
        }
    }

    private void rent() throws Exception {
        int bookNo = Integer.parseInt(In.getStr("도서 번호"));
        String name = In.getStr("이름");
        String pw = In.getStr("비밀번호");

        RentVO vo = new RentVO(bookNo, name, pw);
        service.rent(vo);

        System.out.println("******* 대출 완료 ********");
    }

    private void returnBook() throws Exception {
        int no = Integer.parseInt(In.getStr("글 번호"));
        String pw = In.getStr("비밀번호");

        boolean result = service.returnBook(no, pw);
        System.out.println(result ? "******* 반납 완료 ********" : "비밀번호 오류");
    }

    private void list() throws Exception {
        List<RentVO> list = service.list();

        System.out.println("이름 / 대출일 / 상태");
        for (RentVO vo : list) {
            System.out.println(
                vo.getMemberNm() + " / " +
                vo.getRentDate() + " / " +
                vo.getStatus()
            );
        }
    }
}
