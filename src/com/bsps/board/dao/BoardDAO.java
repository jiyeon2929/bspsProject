package com.bsps.board.dao;

import java.sql.*;
import java.util.*;

import com.bsps.board.vo.BoardVO;
import com.bsps.util.db.DB;

public class BoardDAO {

    // 1. 리스트
    public List<BoardVO> list() throws Exception {
        List<BoardVO> list = new ArrayList<>();
        String sql = "SELECT no, title, writer, writedate, hit FROM board ORDER BY no DESC";

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
        String sql = """
            INSERT INTO board(no, title, content, writer, pw)
            VALUES(board_seq.nextval, ?, ?, ?, ?)
        """;

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

    // 3. 조회수 증가
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

    // 4. 글 보기
    public BoardVO view(long no) throws Exception {
        String sql = "SELECT * FROM board WHERE no = ?";
        BoardVO vo = null;

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

    // 5. 수정용 조회 (비밀번호 확인)
    public BoardVO viewWithPw(long no, String pw) throws Exception {
        String sql = "SELECT * FROM board WHERE no = ? AND pw = ?";
        try (
            Connection con = DB.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
            pstmt.setLong(1, no);
            pstmt.setString(2, pw);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    BoardVO vo = new BoardVO();
                    vo.setNo(no);
                    vo.setTitle(rs.getString("title"));
                    vo.setContent(rs.getString("content"));
                    return vo;
                }
            }
        }
        return null;
    }

    // 6. 글 수정
    public int update(BoardVO vo) throws Exception {
        String sql = "UPDATE board SET title = ?, content = ? WHERE no = ?";
        try (
            Connection con = DB.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
            pstmt.setString(1, vo.getTitle());
            pstmt.setString(2, vo.getContent());
            pstmt.setLong(3, vo.getNo());
            return pstmt.executeUpdate();
        }
    }

    // 7. 글 삭제
    public int delete(long no, String pw) throws Exception {
        String sql = "DELETE FROM board WHERE no = ? AND pw = ?";
        try (
            Connection con = DB.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
            pstmt.setLong(1, no);
            pstmt.setString(2, pw);
            return pstmt.executeUpdate();
        }
    }
}
