package com.naver.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Guest_select {

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
			sql="select * from tbl_guest order by g_no desc";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			System.out.println("no \t title\t name \t cont \t date");
			System.out.println("=================>");
			while(rs.next()) {
				int no=rs.getInt(1);
				String title=rs.getString(3);
				String name=rs.getString("g_name");
				String cont=rs.getString("g_cont");
				String date=rs.getString("g_date");
				System.out.println(no+" \t"+name+" \t"+title+" \t"+cont+" \t"+date+" \t");
			
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
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
