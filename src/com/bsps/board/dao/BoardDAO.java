package com.bsps.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bsps.board.vo.BoardVO;
import com.bsps.util.db.DB;

public class BoardDAO {

    // 1. 리스트
    public List<BoardVO> list() throws Exception {
        List<BoardVO> list = new ArrayList<>();

        String sql =
            "SELECT no, title, writer, writedate, hit " +
            "FROM board ORDER BY no DESC";

        try (
            Connection con = DB.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
        ) {
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

    // 2. 글 등록
    public int write(BoardVO vo) throws Exception {
        String sql =
            "INSERT INTO board(no, title, content, writer, pw) " +
            "VALUES(board_seq.nextval, ?, ?, ?, ?)";

        try (
            Connection con = DB.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
            pstmt.setString(1, vo.getTitle());
            pstmt.setString(2, vo.getContent());
            pstmt.setString(3, vo.getWriter());
            pstmt.setString(4, vo.getPw());

            return pstmt.executeUpdate();
        }
    }

    // 3. 글 보기
    public BoardVO view(long no) throws Exception {
        BoardVO vo = null;

        String sql =
            "SELECT no, title, content, writer, writedate, hit " +
            "FROM board WHERE no = ?";

        try (
            Connection con = DB.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
            pstmt.setLong(1, no);
            try (ResultSet rs = pstmt.executeQuery()) {
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
        try (
            Connection con = DB.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
            pstmt.setLong(1, no);
            pstmt.executeUpdate();
        }
    }
}
