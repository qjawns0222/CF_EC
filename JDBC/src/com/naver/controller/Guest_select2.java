package com.naver.controller;

import java.util.List;

import com.naver.dao.GuestDAOImpl;
import com.naver.vo.GuestVO;

public class Guest_select2 {

	public static void main(String[] args) {
		GuestDAOImpl gdao=new GuestDAOImpl();
		List<GuestVO> glist=gdao.getList();
		System.out.println("no \t title\t name \t cont \t date");
		System.out.println("=================>");
		for(GuestVO g:glist) {
			System.out.println(g.getG_no()+"\t"+g.getG_title()+"\t"+g.getG_name()+"\t"+g.getG_cont()+"\t"+g.getG_date().substring(0, 10));
		}

	}

}
