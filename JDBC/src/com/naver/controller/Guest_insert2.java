package com.naver.controller;

import java.util.Scanner;

import com.naver.dao.GuestDAOImpl;
import com.naver.vo.GuestVO;

public class Guest_insert2 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		GuestDAOImpl gdao= new GuestDAOImpl();
		GuestVO gvo=new GuestVO();
		System.out.println("방명록 저장하기");
		System.out.println("===============>");
		System.out.print("글쓴이 입력>>");
		String g_name=scan.nextLine();
		System.out.print("제목 입력>>");
		String g_title=scan.nextLine();
		System.out.print("내용 입력>>");
		String g_cont=scan.nextLine();
		gvo.setG_name(g_name);
		gvo.setG_title(g_title);
		gvo.setG_cont(g_cont);
		int re=gdao.insertGu(gvo);
		if(re==1) {
			System.out.println("방명록 저장 성공!");
		}

	}

}
