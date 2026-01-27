package com.bsps.main.controller;


import com.bsps.board.controller.BoardController;
import com.bsps.book.controller.BookController;
import com.bsps.member.controller.MemberController;
import com.bsps.util.io.In;

public class Main {

      public static void main(String[] args) throws Exception {
         
         // 환영 인사
         System.out.println("---------------------------------");
         System.out.println(" 방갑습니다. 좋은 시간 되세요.~~~~~~");
         System.out.println("---------------------------------\n");
         
     	try {
			Class.forName("com.bsps.util.db.DB");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("DB 클래스가 존재하지 않아 시스템을 종료합니다. ------");
			System.exit(1);
		}
         while(true) { // for(;;)
            // 메인 처리
            // 1. 메인 메뉴 출력
            System.out.println("<<< 메인 메뉴 >>>");
            System.out.println("=========================================");
            System.out.println(" 1. 회원관리  2. 일반게시판  3. 대출반납관리");
            System.out.println(" 0. 프로그램 종료");
            System.out.println("=========================================");
            // 2. 메인 메뉴 입력
            String menu = In.getStr("메뉴 입력");
            System.out.println(); // 줄바꿈
            // 3. 메인 메뉴 처리
            switch (menu) {
            case "1":
            	    new MemberController().execute();
               // System.out.println("일반게시판 처리");
               // System.out.println("BoardController 실행 전.---------");
               // System.out.println("BoardController 실행 후.---------");
               break;
            case "2":
               System.out.println("일반게시판");
               new BoardController().execute();

               break;
            case "3":
            		new BookController().execute();
               
               break;
            case "0":
               System.out.println("+---------------------------------------------------+");
               System.out.println("  즐거운 시간되셨나요. 불편한 점이 있으시면 글등록 부탁드립니다.");
               System.out.println("  프로그램을 종료합니다.");
               System.out.println("+---------------------------------------------------+");
               
               // 완전 종료
               System.exit(0);
            default:
				invalidMenuPrint();
				break;
            } // switch ~ case 라벨: ~ default 의 끝
            System.out.println(); // 화면을 구분하는 빈줄 출력
         }// while(true) 의 끝
      }// main
  			public static void invalidMenuPrint() {
               System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
               System.out.println(" 잘못된 메뉴를 입력하셨습니다. 다시 입력해 주세요.");
               System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
              
           
  			}
  
}// 클래스의 끝