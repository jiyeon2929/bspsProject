package com.bsps.rent.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.bsps.rent.vo.RentVO;
import com.bsps.util.db.DB;

public class RentDAO {

    // 1. 대출 등록
    public void insert(RentVO vo) throws Exception {
        String sql = """
            INSERT INTO rent
            VALUES (rent_seq.NEXTVAL, ?, ?, SYSDATE, ?, '대출중')
        """;

        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, vo.getBookNo());
            ps.setString(2, vo.getMemberNm());
            ps.setString(3, vo.getPassword());
            ps.executeUpdate();
        }
    }

    // 2. 비밀번호 확인
    public String getPassword(int rentNo) throws Exception {
        String sql = "SELECT password FROM rent WHERE rent_no=? AND status='대출중'";

        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, rentNo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) return rs.getString("password");
        }
        return null;
    }

    // 3. 반납 처리
    public void returnBook(int rentNo) throws Exception {
        String sql = "UPDATE rent SET status='반납' WHERE rent_no=?";

        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, rentNo);
            ps.executeUpdate();
        }
    }

    // 4. 리스트 조회
    public List<RentVO> list() throws Exception {
        List<RentVO> list = new ArrayList<>();

        String sql = """
            SELECT rent_no, member_nm, rent_date, status
            FROM rent
            ORDER BY rent_date DESC
        """;

        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                RentVO vo = new RentVO();
                vo.setRentNo(rs.getInt("rent_no"));
                vo.setMemberNm(rs.getString("member_nm"));
                vo.setRentDate(rs.getDate("rent_date"));
                vo.setStatus(rs.getString("status"));
                list.add(vo);
            }
        }
        return list;
    }
}
