package com.bsps.util.io;

import java.util.Scanner;

public class In {
	private static Scanner sc = new Scanner(System.in);

    public static String getStr(String msg) {
        System.out.print(msg + " : ");
        return sc.nextLine();
    }

    public static int getInt(String msg) {
        System.out.print(msg + " : ");
        return Integer.parseInt(sc.nextLine());
    }

    //-- 수정본
    public static long getLong(String msg) {
        System.out.print(msg + " : "); // 메시지 출력
        // 문자열로 입력받아 long 타입으로 변환 (버퍼 문제를 방지하기 위해 nextLine 사용)
        return Long.parseLong(sc.nextLine()); 
    }
	//public static long getLong(String string) {
		// TODO Auto-generated method stub
		//return 0;
	//}
}
