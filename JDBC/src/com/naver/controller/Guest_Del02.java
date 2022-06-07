package com.naver.controller;

import java.util.Scanner;

import com.naver.dao.GuestDAOImpl;
import com.naver.vo.GuestVO;

public class Guest_Del02 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		GuestDAOImpl gdao=new GuestDAOImpl();
		
		System.out.println("방명록삭제");
		System.out.print("번호입력>>");
		int delNo=Integer.parseInt(scan.nextLine());
		GuestVO db_no=gdao.findNo(delNo);
		if(db_no==null) {
			System.out.println("번호가 없어서 삭제 불가");
		}else {
			System.out.println("검색된 번호:"+db_no.getG_no());
			int re=gdao.delGu(delNo);
			if(re==1) {
				System.out.println("삭제 성공");
			}else {
				System.out.println("삭제 실패");
			}
		}
		

	}

}
