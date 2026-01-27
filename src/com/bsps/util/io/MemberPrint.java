package com.bsps.util.io;

import java.util.List;

public class MemberPrint {
	
	public static void print(List<MemberVO>list) {
		System.out.println("*****************************");
		System.out.println("회원 리스트");
		System.out.println("*****************************");
		System.out.println("+================================================+");
		System.out.println(" 아이디  / 이름  / 성별  / 생년월일  / 연락처  / 이메일  / 상태  / 등급명(번호)");
	}

}
