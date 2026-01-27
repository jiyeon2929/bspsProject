package com.bsps.book.util.io;

import java.util.List;

import com.bsps.book.vo.BookVO;

public class BookPrint {
	
	// 1. list - 리스트
	public static void print(List<BookVO> list) {
		System.out.println(" <도서 리스트>");
		System.out.println("+=========================================================+");
		System.out.println("번호| 제목 |  출판사 |  작성자 |   작성일    |  상태");
		System.out.println("+=========================================================+");
		// 가져온 데이터 출력하기
		for (BookVO vo : list) {
			System.out.print(" " + vo.getNo());
			System.out.print(" | " + vo.getTitle());
			System.out.print(" | " + vo.getContent());
			System.out.print(" | " + vo.getWriter());
			System.out.print(" | " + vo.getWriteDate());
			System.out.print(" | " + vo.getStatus());
			System.out.println();
		} // for의 끝

		System.out.println("+==========================================================+\n");

	} // print(list)의 끝

}
