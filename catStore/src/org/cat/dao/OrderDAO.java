package org.cat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.cat.domain.PreOrderDTO;


public class OrderDAO {
	static final String INSERT_ORDER ="insert into tbl_order (ono,customer) values (seq_order.nextval, 'user10')";
	static final String INSERT_DETAIL = 
			"insert into tbl_order_detail (dno, ono, ino, amount)"
			+ " values (seq_order_detail.nextval, seq_order.currval, ? ,?)";
	
	static final String ORDER_SEQ = "select seq_order.currval from dual";
	
	public int insert(final List<PreOrderDTO> orderList) throws Exception {
		final StringBuffer buffer = new StringBuffer();
		new AbstractExecutor() {
			
			@Override
			protected void doJob(final Connection con, PreparedStatement pstmt, ResultSet rs) throws Exception {
				
				pstmt = con.prepareStatement(INSERT_ORDER);
				int count = pstmt.executeUpdate();
				
				System.out.println("INSERT ORDER : " + count);
				if(count < 1) {
					throw new Exception("ORDER ERROR");
				}
				
				pstmt.close();
				pstmt = null;
				
				for (PreOrderDTO preOrderDTO : orderList) {
					pstmt = con.prepareStatement(INSERT_DETAIL);
					pstmt.setInt(1,preOrderDTO.getInoInt());
					pstmt.setInt(2,preOrderDTO.getAmount());
					
					count = pstmt.executeUpdate();
					if(count < 1) {	throw new Exception("DETAIL ERROR");}
					pstmt.close();
					pstmt = null;	
				}
				pstmt = con.prepareStatement(ORDER_SEQ);
				rs = pstmt.executeQuery();
				rs.next();
				
				buffer.append(rs.getInt(1));
				
			}
		}.execute();
		
		return Integer.parseInt(buffer.toString());
	}
}
