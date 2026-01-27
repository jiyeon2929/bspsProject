package com.bsps.board.dao;

import java.sql.*;
import java.util.*;

import com.bsps.board.vo.BoardVO;
import com.bsps.util.db.DB;

public class BoardDAO {

    // 1. 리스트
    public List<BoardVO> list() throws Exception {
        List<BoardVO> list = new ArrayList<>();

        String sql =
            "SELECT no, title, writer, writedate, hit " +
            "FROM board ORDER BY no DESC";

        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                BoardVO vo = new BoardVO();
                vo.setNo(rs.getLong("no"));
                vo.setTitle(rs.getString("title"));
                vo.setWriter(rs.getString("writer"));
                vo.setWriteDate(rs.getDate("writedate"));
                vo.setHit(rs.getLong("hit"));
                list.add(vo);
            }
        }
        return list;
    }

    // 2. 글등록
    public void write(BoardVO vo) throws Exception {
        String sql =
            "INSERT INTO board(no, title, content, writer, pw) " +
            "VALUES(board_seq.nextval, ?, ?, ?, ?)";

        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, vo.getTitle());
            ps.setString(2, vo.getContent());
            ps.setString(3, vo.getWriter());
            ps.setString(4, vo.getPw());
            ps.executeUpdate();
        }
    }

    // 3. 글보기
    public BoardVO view(long no) throws Exception {
        BoardVO vo = null;

        String sql =
            "SELECT no, title, content, writer, writedate, hit " +
            "FROM board WHERE no = ?";

        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, no);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    vo = new BoardVO();
                    vo.setNo(rs.getLong("no"));
                    vo.setTitle(rs.getString("title"));
                    vo.setContent(rs.getString("content"));
                    vo.setWriter(rs.getString("writer"));
                    vo.setWriteDate(rs.getDate("writedate"));
                    vo.setHit(rs.getLong("hit"));
                }
            }
        }
        return vo;
    }

    // 4. 조회수 증가
    public void increaseHit(long no) throws Exception {
        String sql = "UPDATE board SET hit = hit + 1 WHERE no = ?";

        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, no);
            ps.executeUpdate();
        }
    }

    // 5. 제목만 수정
    public int updateTitle(BoardVO vo) throws Exception {
        String sql =
            "UPDATE board SET title = ? WHERE no = ? AND pw = ?";

        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, vo.getTitle());
            ps.setLong(2, vo.getNo());
            ps.setString(3, vo.getPw());
            return ps.executeUpdate();
        }
    }

    // ⭐ 6. 글삭제
    public int delete(long no, String pw) throws Exception {
        String sql = "DELETE FROM board WHERE no = ? AND pw = ?";

        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, no);
            ps.setString(2, pw);
            return ps.executeUpdate();
        }
    }
}
