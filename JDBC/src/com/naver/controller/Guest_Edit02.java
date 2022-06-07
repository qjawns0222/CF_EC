package com.naver.controller;

import java.util.Scanner;

import com.naver.dao.GuestDAOImpl;
import com.naver.vo.GuestVO;

public class Guest_Edit02 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		GuestDAOImpl gdao=new GuestDAOImpl();
		
		System.out.println("방명록 수정");
		System.out.println("번호입력>>");
		int g_no= Integer.parseInt(scan.nextLine());
		GuestVO db_g=gdao.findNo(g_no);
		if(db_g!=null) {
			System.out.println("검색된 번호:"+db_g.getG_no());
			System.out.print("수정할 글쓴이 입력>>");
			String name=scan.nextLine().trim();
			System.out.print("수정할 제목 입력>>");
			String title=scan.nextLine().trim();
			System.out.print("수정할 내용 입력>>");
			String cont=scan.nextLine().trim();
			GuestVO ev=new GuestVO();
			ev.setG_no(g_no);
			ev.setG_name(name);
			ev.setG_title(title);
			ev.setG_cont(cont);
			
			int re=gdao.editGu(ev);
			if(re==1) {
				System.out.println("수정 성공~");
			}else {
				System.out.println("수정 실패");
			}
		}else {
			System.out.println("번호가 없어서 검색 안됨");
		}

	}

}
