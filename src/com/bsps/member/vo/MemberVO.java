package com.bsps.member.vo;

import java.sql.Timestamp;

public class MemberVO {
	
	private String id;
	private String pw;
	private String name;
	private String tel;
	private String email;
 	private Timestamp joinDate; //회원이 가입한 날짜, 시간
	private String role; // 일반회원인지  일반 관리자인지 판단.
	private String status;
	
	
	
	// 회원가입용 생성자
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Timestamp getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Timestamp joinDate) {
		this.joinDate = joinDate;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", name=" + name + ", tel=" + tel + ", email=" + email
				+ ", joinDate=" + joinDate + ", role=" + role + ", status=" + status + "]";
	}


}
