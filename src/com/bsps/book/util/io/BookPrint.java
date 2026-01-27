package com.bsps.book.util.io;

import java.util.List;

import com.bsps.book.vo.BookVO;

public class BookPrint {
	
	public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
	
	// 1. list - 리스트
	public static void print(List<BookVO> list) {
		
		System.out.println(" <도서 리스트>");
		System.out.println("+=========================================================+");
		System.out.println("번호| 제목 |  출판사 |  작성자 |   작성일    |  상태");
		System.out.println("+=========================================================+");
		
		
		
		// 가져온 데이터 출력하기
		for (BookVO vo : list) {
	        String color = ANSI_RESET; // 기본 색상

	          if ("대출중".equals(vo.getStatus())) {
	              color = ANSI_RED;
	          } else if ("반납".equals(vo.getStatus())) {
	              color = ANSI_GREEN;
	          }
	                
			System.out.print(" " + vo.getNo());
			System.out.print(" | " + vo.getTitle());
			System.out.print(" | " + vo.getContent());
			System.out.print(" | " + vo.getWriter());
			System.out.print(" | " + vo.getWriteDate());
			System.out.print(" | " + color + vo.getStatus() + ANSI_RESET);
			System.out.println();
			
		} // for의 끝
		
		System.out.println("+==========================================================+\n");

	} // print(list)의 끝

}
