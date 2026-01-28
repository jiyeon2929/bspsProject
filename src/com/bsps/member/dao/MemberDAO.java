package com.bsps.member.dao;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bsps.member.vo.LoginVO;
import com.bsps.member.vo.MemberVO;
import com.bsps.util.db.DB;


public class MemberDAO {
	
	Connection con = null; //DB 연결
	
	PreparedStatement pstmt = null; //SQL 실행 객체
	
	ResultSet rs = null; // SELECT 결과 저장 객체 : 결과를 담는 그릇, 조회할 떄만 필요.
	
	// DB 연결 정보
		final String DRIVER = "oracle.jdbc.OracleDriver";
		final String URL = "jdbc:oracle:thin:@10.15.21.219:1521:xe";
		final String UID = "bsps";
		final String UPW = "bsps";
	
	//1. 로그인 처리
	// throws Exception: DAO 안에서 발생한 예외를 직접 처리하지 않고, 호출한 쪽에게 넘기기 위해서
	public LoginVO login(LoginVO userVO) throws Exception{
		
		LoginVO vo = null;
		
		//DB 연결
		con = DB.getConnection();
		
		//SQL 작성
		String sql = "select m.id, m.name, m.gradeno  gradeNo "
					 + "from member m"
					+ " where m.id = ? and m.pw = ? ";

				
				
		
		
		
		System.out.println("실행 SQL >>>> "+sql);
		pstmt = con.prepareStatement(sql);
		
		//실행 객체 생성
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, userVO.getId());
		pstmt.setString(2, userVO.getPw());
		
		//SQL 실행
		rs = pstmt.executeQuery();
		
		// 결과 처리
		if (rs != null && rs.next()) {
			vo = new LoginVO();
			vo.setId(rs.getString("id"));
			vo.setName(rs.getString("name"));
			vo.setGradeNo(rs.getInt("gradeNo"));
			
			
			
		}
		
		//DB 닫기
		DB.close(con,pstmt,rs);
		
		
		return vo;
		
	}
	
	// 1-1. 접속일 변경
	public Integer changeConDate(String id)throws Exception{
		
		Integer result = 0;
		
		con = DB.getConnection();
		
		String sql = "update member set conDate = sysdate where id = ?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,id);
		
		result = pstmt.executeUpdate();
		
		
		DB.close(con, pstmt);
		
		return result;
		
	}
	
	//2. 회원가입
	public Integer write(MemberVO vo)throws Exception{
		
		Integer result = 0;
		
		con = DB.getConnection();
		
		String sql = "insert into member(id, pw, name, gender, birth, tel, email)"
				+ " values(?,?,?,?,?,?,?)";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,vo.getId());
		pstmt.setString(2,vo.getPw());
		pstmt.setString(3,vo.getName());
		pstmt.setString(4,vo.getGender());
		pstmt.setString(5,vo.getBirth());
		pstmt.setString(6,vo.getTel());
		pstmt.setString(7,vo.getEmail());
		
		result = pstmt.executeUpdate();
		
		DB.close(con, pstmt);
		
		return result;
		

		
		
	}
	
	//2-1.회원 정보 확인
	public MemberVO view(MemberVO vo) throws Exception{
		
		MemberVO result = null;
		
		con = DB.getConnection();
		
		String sql = 
			"select id, name, tel, email, gender " +
			"from member "+
			"where id = ?";
		
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		
		rs = pstmt.executeQuery();
		
		if(rs.next()){
			result=new MemberVO();
			result.setId(rs.getString("id"));
			result.setName(rs.getString("name"));
			result.setGender(rs.getString("gender"));
			result.setTel(rs.getString("tel"));
			result.setEmail(rs.getString("email"));
			
		}
		
		DB.close(con, pstmt,rs);
		
		return result;
	}
	
	//3-1. 아이디 찾기
	public String searchId(MemberVO vo)throws Exception{
		String id = null;
		
		Class.forName(DRIVER);
		
		con = DriverManager.getConnection(URL,UID,UPW);
		
		String sql = "select id from member where name = ? and email =?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, vo.getName());
		pstmt.setString(2, vo.getEmail());
		
		
		
		rs = pstmt.executeQuery();
		
		if(rs!= null && rs.next()) {
			id = rs.getString("id");
			
		}
		
		DB.close(con, pstmt, rs);
		
		return id;
	}
	
	//4. 회원 상태 변경
	
public Integer changeStatus(String id, String status)throws Exception{
		
		Integer result = 0;
		
		con = DB.getConnection();
		
		String sql = "update member set status = ? where id = ?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,status);
		pstmt.setString(2,id);
		
		DB.close(con, pstmt);
		
		return result;
		

		
		
	}
}
