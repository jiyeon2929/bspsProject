package com.bsps.book.controller;

import java.util.List;

import com.bsps.book.Service.BookListService;
import com.bsps.book.Service.BookUpdateService;
import com.bsps.book.Service.BookWriteService;
import com.bsps.book.util.io.BookPrint;
import com.bsps.book.util.io.In;
import com.bsps.book.vo.BookVO;
import com.bsps.main.service.Execute;

public class BookController {
<<<<<<< HEAD

	


=======
>>>>>>> branch 'master' of https://github.com/jiyeon2929/bspsProject.git

	// PL이 메서드 이름을 정한다.
	public void execute() {

		while (true) { // for(;;)
			try { // 정상처리
					// 일반게시판 처리
					// 1. 일반게시판 메뉴 출력
				System.out.println("<<<대출/반납 하기 >>>");
				System.out.println("=========================================");
				System.out.println(" 1. 리스트  2. 대출  3. 반납");
				System.out.println(" 0. 이전 메뉴");
				System.out.println("=========================================");
				// 2. 일반게시판 메뉴 입력
				String menu = In.getStr("메뉴 입력");
				System.out.println(); // 줄바꿈

				// 3. 일반게시판 메뉴 처리
				BookVO vo;
				Integer result;

				switch (menu) {
				case "1"://
					@SuppressWarnings("unchecked")
					List<BookVO> list = (List<BookVO>) Execute.execute(new BookListService(), null);
					BookPrint.print(list);
					break;

				case "2":
					System.out.println("< 대출 하기 >");
					vo = new BookVO();
					vo.setTitle(In.getStr("책제목"));
					vo.setContent(In.getStr("출판사"));
					vo.setWriter(In.getStr("작성자"));
					vo.setPw(In.getStr("비밀번호"));
					result = (Integer) Execute.execute(new BookWriteService(), vo);
					if (result >= 1)
						System.out.println("\n******* 대출 완료 되었습니다. *********");
					break;
				case "3":
					System.out.println("< 반납 하기 >");
					vo = new BookVO();
					vo.setWriter(In.getStr("이름"));
					vo.setTitle(In.getStr("책 제목"));
					vo.setPw(In.getStr("본인 확인용 비밀번호"));
					result = (Integer) Execute.execute(new BookUpdateService(), vo);
					if (result >= 1)
						System.out.println("\n******* 반납 완료 되었습니다. *********");
					else
						System.out.println("****** 반납 실패 : 정보를 다시 확인해 주세요. *******");
					break;

				case "0": // 이전 메뉴
					return;

				default:
					//
					System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
					System.out.println(" 잘못된 메뉴를 입력하셨습니다. 다시 입력해 주세요.");
					System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
					break;
				} // switch ~ case 라벨: ~ default 의 끝
				System.out.println(); // 화면을 구분하는 빈줄 출력
			} // try 정상처리 의 끝
			catch (Exception e) { // 예외 처리
				e.printStackTrace(); // 개발자를 위한 예외 상세 출력
				// 사용자를 위한 예외 코드 작성
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
				System.out.println(" 일반 게시판 처리 중 오류가 발생되었습니다.");
				System.out.println(" 다시 한번 실행해 주시고 오류가 계속되면 오류 게시판에 남겨 주세요.");
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
			} // catch 의 끝
		} // while(true) 의 끝

	} // execute()의 끝

}// 클래스의 끝
