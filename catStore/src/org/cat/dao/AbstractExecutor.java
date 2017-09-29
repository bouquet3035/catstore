package org.cat.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractExecutor {

	static {
		try {
			// 드라이버 클래스를 메모리상에 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public final void execute() throws RuntimeException {// RuntimeException  
		//오버라이드 안되게 파이널
		Connection con = null; 
		PreparedStatement pstmt = null ;  // 인설트 
		ResultSet rs = null ;  // 셀렉트 
		
		try {
			
		 con = 
					DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.36:1521:XE", 
					"user10","java96");
			
			
			System.out.println("try");
	
			System.out.println(con);
			
			con.setAutoCommit(false) ; 
					
			doJob(con,pstmt,rs);
	
			con.commit();   //마지막에 커밋 
			
			
		} catch (Exception e) {
			try {
				con.rollback();// 코밋이 안되면 롤백
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			e.printStackTrace();
			throw new RuntimeException(e.getMessage()) ;  // 트라이 캐취 인셉셥 같이 쓰는 
								//언체크드 한다  
			
		}finally {
			System.out.println("finally");
			
			if(rs != null ) {
				try {rs.close() ;} catch (Exception e) {}
				}
			if(pstmt != null ) {
				try {pstmt.close() ;} catch (Exception e) {}
				}
						
			if(con != null ) {
				try {con.close() ;} catch (Exception e) {}
				}
			}
		 //커넥션,리절트 셋, 프리페어 
	}
	
	protected abstract void doJob(Connection con, PreparedStatement pstmt, ResultSet rs) throws Exception ; 
	
}

