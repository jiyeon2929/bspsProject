package com.bsps.rent.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bsps.rent.vo.RentVO;
import com.bsps.util.db.DB;

public class RentDAO {

	// 1. 대출 등록
	public void rent(String memberId, String title, String password) throws Exception {

		String sql = "SELECT rent_no, password, status " + "FROM rent " + "WHERE rent_no = ?";

		try (Connection con = DB.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, memberId);
			ps.setString(2, title);
			ps.setString(3, password);
			ps.executeUpdate();
		}
	}

	// 2. 글 번호로 대출 정보 조회 (반납 전 검증용)
	public RentVO getByNo(int rentNo) throws Exception {

		String sql = """
				    SELECT rent_no, password, status
				    FROM rent
				    WHERE rent_no = ?
				""";

		try (Connection con = DB.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, rentNo);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return new RentVO(rs.getInt("rent_no"), rs.getString("password"), rs.getString("status"));
			}
		}
		return null;
	}

	// 3. 반납 처리
	public void returnBook(int rentNo) throws Exception {

		String sql = "UPDATE rent SET status='반납' WHERE rent_no=?";

		try (Connection con = DB.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, rentNo);
			ps.executeUpdate();
		}
	}
}
