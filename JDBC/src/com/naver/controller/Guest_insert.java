package com.naver.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Guest_insert {

	public static void main(String[] args) {
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@222.103.178.219:1521:XE";
		String user="week";
		String password="1234";
		
		Connection con=null;
		Statement stmt=null;
		String sql=null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
			stmt=con.createStatement();
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("방명록저장");
		System.out.println("작성자 입력>>");
		String name=reader.readLine();
		System.out.println("제목 입력>>");
		String title=reader.readLine();
		System.out.println("내용 입력>>");
		String cont=reader.readLine();
		sql="insert into tbl_guest values(g_no_seq.nextval,'"+name+"','"+title+"','"+cont+"',sysdate)";
		int re=stmt.executeUpdate(sql);
		if(re==1) {
			System.out.println("저장 성공!");
		}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt!=null)stmt.close();
				if(con!=null)con.close();
				}catch(Exception e) {
					e.printStackTrace();
			}
		}

	}

}
