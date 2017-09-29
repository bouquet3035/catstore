package org.cat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.cat.domain.ItemDTO;


public class ItemDAO {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	final String list_sql = "select * from tbl_item order by ino desc";

	public List<ItemDTO> getList() throws Exception {

		List<ItemDTO> list = new ArrayList<>();

		new AbstractExecutor() {

			@Override
			protected void doJob(Connection con, PreparedStatement pstmt, ResultSet rs) throws Exception {
				pstmt = con.prepareStatement(list_sql);
				
				rs = pstmt.executeQuery();

				while (rs.next()) {

					ItemDTO dto = new ItemDTO();
					dto.setIno(rs.getInt("ino"));
					dto.setIname(rs.getString("iname"));
					dto.setIimg(rs.getString("iimg"));
					dto.setPrice(rs.getInt("price"));
					dto.setMregDate(rs.getDate("mreg_date"));
					list.add(dto);
				}
			}
		}.execute();

		return list;
	}
}
