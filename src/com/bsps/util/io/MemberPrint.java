package com.bsps.util.io;

import java.util.List;

import com.bsps.member.vo.MemberVO;

public class MemberPrint {
	
	public static void print(List<MemberVO>list) {
		System.out.println("*****************************");
		System.out.println("회원 리스트");
		System.out.println("*****************************");
		System.out.println("+==================================================================+");
		System.out.println(" 아이디  / 이름  / 성별  / 생년월일  / 연락처  / 이메일  / 상태  / 등급명(번호)");
		System.out.println("+==================================================================+");
		
		for (MemberVO vo: list) {
			System.out.println(" " + vo. getId());
			System.out.println(" " + vo. getName());
			System.out.println(" " + vo. getGender());
			System.out.println(" " + vo. getBirth());
			System.out.println(" " + vo. getTel());
			System.out.println(" " + vo. getEmail());
			System.out.println(" " + vo. getStatus());
			System.out.println(" " + vo. getGradeName());
			System.out.println(" " + vo. getGradeNo());
			System.out.println();
		}
		
		System.out.println("+==================================================================+\n");
	}

	
	public static void print(MemberVO vo, Integer my) {
		System.out.println();
		System.out.println("--------------------------");
		System.out.println("--------"+((my==1)?"내":"회원")+ "정보 보기--");
		System.out.println("--------------------------");
		System.out.println("+-----------------------------------------+");
		System.out.println("+아이디: "+vo.getId());
		System.out.println("+아이디: "+vo.getName());
		System.out.println("+아이디: "+vo.getGender());
		System.out.println("+아이디: "+vo.getBirth());
		System.out.println("+아이디: "+vo.getTel());
		System.out.println("+아이디: "+vo.getEmail());
		System.out.println("+아이디: "+vo.getGradeName());
		System.out.println("+-----------------------------------------+\n");
		
	}
}
