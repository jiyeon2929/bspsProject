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

	public static long getLong(String string) {
		// TODO Auto-generated method stub
		return 0;
	}
}
