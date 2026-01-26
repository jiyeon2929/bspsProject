package com.bsps.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bsps.book.vo.BookVO;
import com.bsps.util.db.DB;


public class BookDAO {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// DB 연결 정보

	// 1. 일반 게시판 리스트
	public List<BookVO> list() throws Exception{
			List<BookVO> list = new ArrayList<>();
		
		con = DB.getConnection();		

		String sql = "select no, title,content, writer, to_char(writeDate, 'yyyy-mm-dd') writeDate, "
				+ " status from book order by no desc";
		
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		// 6. DB에서 가져온 데이터 채우기
		if(rs != null) {
			while(rs.next()) { 
				BookVO vo = new BookVO();
				vo.setNo(rs.getLong("no"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setWriteDate(rs.getString("writeDate"));
				vo.setStatus(rs.getString("status"));
				list.add(vo);
			} // while() 끝
		} // if의 끝
		
		DB.close(con, pstmt,rs);
		return list;
	} // list()의 끝
	


	
	// 2. 일반 게시판 글등록
	public Integer write(BookVO vo) throws Exception {
		Integer result = 0;
		
		con = DB.getConnection();
		String sql = "insert into book(no,title, content, writer, pw) values(book_seq.nextval,?,?,?,?)";
		// 4. 실행객체 & 데이터 세팅
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		pstmt.setString(3, vo.getWriter());
		pstmt.setString(4, vo.getPw());
	
		result = pstmt.executeUpdate();
		DB.close(con, pstmt);

		
		return result;
	}
	// 3.  도서 반납 글수정
	public Integer update(BookVO vo) throws Exception {
		Integer result = 0;
		
		con = DB.getConnection();
		String sql = "update book set status = '반납' where writer = ? and  title = ?  and pw = ?";
	
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, vo.getWriter());
		pstmt.setString(2, vo.getTitle());
		pstmt.setString(3, vo.getPw());
		result = pstmt.executeUpdate();
		
		DB.close(con, pstmt);
		return result;
	}
	
	

} // 클래스의 끝
