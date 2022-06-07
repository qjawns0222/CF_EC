package com.naver.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.naver.vo.GuestVO;

public class GuestDAOImpl {
	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@222.103.178.219:1521:XE";
	String user="week";
	String password="1234";
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	Statement stmt=null;
	String sql=null;
	public GuestDAOImpl(){
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	public List<GuestVO> getList(){
		List<GuestVO> list=new ArrayList<>();
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
			sql="select * from tbl_guest order by g_no desc";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				GuestVO g=new GuestVO();
				g.setG_no(rs.getInt(1));
				g.setG_name(rs.getString(2));
				g.setG_title(rs.getString(3));
				g.setG_cont(rs.getString(4));
				g.setG_date(rs.getString(5));
				list.add(g);
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
		return list;
	}
	
	public int insertGu(GuestVO gvo) {
		int re=-1;
		try {
			sql="insert into tbl_guest values(g_no_seq.nextval,?,?,?,sysdate)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, gvo.getG_name());
			pstmt.setString(2, gvo.getG_title());
			pstmt.setString(3, gvo.getG_cont());
			re=pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt !=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return re;
	}

	public GuestVO findNo(int g_no) {
		GuestVO dg=null;
		try {
			sql="select * from tbl_guest where g_no="+g_no;
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			if(rs.next()) {
				dg=new GuestVO();
				dg.setG_no(rs.getInt("g_no"));
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(stmt != null)stmt.close();
				if(con!=null)con.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return dg;
	}

	public int editGu(GuestVO ev) {
		int re=-1;
		try {
			con=DriverManager.getConnection(url,user,password);
			sql="update tbl_guest set g_name=?,g_title=?,g_cont=? where g_no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, ev.getG_name());
			pstmt.setString(2, ev.getG_title());
			pstmt.setString(3, ev.getG_cont());
			pstmt.setInt(4, ev.getG_no());
			re=pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt != null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return re;
	}

	public int delGu(int delNo) {
		int re=-1;
		try {
			con=DriverManager.getConnection(url,user,password);
			sql="delete from tbl_guest where g_no="+delNo;
			stmt=con.createStatement();
			re=stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt != null)stmt.close();
				if(con!=null)con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return re;
	}

}
