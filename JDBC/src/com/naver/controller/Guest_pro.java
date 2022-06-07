package com.naver.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import com.naver.dao.GuestDAOImpl;
import com.naver.vo.GuestVO;

public class Guest_pro {

	public static void main(String[] args) {
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@222.103.178.219:1521:XE";
		String user="week";
		String password="1234";
		
		Connection con=null;
		CallableStatement cs=null;
		String sql=null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
			Scanner scan=new Scanner(System.in);
			System.out.print("번호입력>>");
			int no=Integer.parseInt(scan.nextLine());
			
			GuestDAOImpl gdao=new GuestDAOImpl();
			GuestVO db_no=gdao.findNo(no);
			if(db_no != null) {
				System.out.println("검색된번호:"+db_no.getG_no());
				sql="{call sel_gu(?,?,?,?)}";
				cs=con.prepareCall(sql);
				cs.setInt(1, no);
				cs.registerOutParameter(2,java.sql.Types.VARCHAR);
				cs.registerOutParameter(3,java.sql.Types.VARCHAR);
				cs.registerOutParameter(4,java.sql.Types.VARCHAR);
				cs.execute();
				System.out.println("번호 \t 제목 \t 글쓴이 \t 내용 \t");
				System.out.println("=====================================>");
				System.out.println(no+" \t"+cs.getString(3)+" \t"+cs.getString(2)+" \t"+cs.getString(4)+" \t");
			}else {
				System.out.println("검색된 번호가 없어서 저장된 프로시저 수행 안됨");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(cs!=null)cs.close();
				if(con!=null)con.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
