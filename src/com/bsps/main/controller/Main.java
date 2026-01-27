package com.bsps.main.controller;



import com.bsps.board.controller.BoardController;
import com.bsps.rent.controller.RentController;
import com.bsps.util.io.In;


public class Main {

	public static void main(String[] args) throws Exception {

		// 환영 인사
		System.out.println("---------------------------------");
		System.out.println(" 방갑습니다. 좋은 시간 되세요.~~~~~~");
		System.out.println("---------------------------------\n");

		while (true) { // for(;;)
			// 메인 처리
			// 1. 메인 메뉴 출력
			System.out.println("<<< 메인 메뉴 >>>");
			System.out.println("=========================================");
			System.out.println(" 1. 회원관리  2. 도서관리  3. 대출반납관리");
			System.out.println(" 0. 프로그램 종료");
			System.out.println("=========================================");
			// 2. 메인 메뉴 입력
			String menu = In.getStr("메뉴 입력");
			System.out.println(); // 줄바꿈
			// 3. 메인 메뉴 처리
			switch (menu) {
			case "1":
				// System.out.println("일반게시판 처리");
				// System.out.println("BoardController 실행 전.---------");
				new BoardController().execute();
				// System.out.println("BoardController 실행 후.---------");
				break;
			case "2":
				System.out.println("회원관리");

				break;
			case "3":
				new RentController().execute();

				break;
			case "0":
				System.out.println("+---------------------------------------------------+");
				System.out.println("  즐거운 시간되셨나요. 불편한 점이 있으시면 글등록 부탁드립니다.");
				System.out.println("  프로그램을 종료합니다.");
				System.out.println("+---------------------------------------------------+");

				// 완전 종료
				System.exit(0);

			default:
				//
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
				System.out.println(" 잘못된 메뉴를 입력하셨습니다. 다시 입력해 주세요.");
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
				break;
			} // switch ~ case 라벨: ~ default 의 끝
			System.out.println(); // 화면을 구분하는 빈줄 출력
		} // while(true) 의 끝

	} // main()의 끝


}
