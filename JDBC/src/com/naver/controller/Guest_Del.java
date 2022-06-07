package com.naver.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Guest_Del {

	public static void main(String[] args) {
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@222.103.178.219:1521:XE";
		String user="week";
		String password="1234";
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
			Scanner scan=new Scanner(System.in);
			System.out.println("방명록삭제");
			System.out.println("삭제할 번호 입력>>");
			int no=Integer.parseInt(scan.nextLine());
			sql="select * from tbl_guest where g_no=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				sql="delete from tbl_guest where g_no=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, no);
				int re=pstmt.executeUpdate();
				if(re==1) {
					System.out.println("삭제성공");
				}
			}else {
				System.out.println("번호가 없어서 삭제 실패");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(con!=null)con.close();
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
