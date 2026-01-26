package com.bsps.book.vo;

public class BookVO {

		// 글번호, 제목, 내용, 작성자, 작성일, 조회수, 비밀번호.
		private long no;
		private String title;
		private String content;
		private String writer;
		private String writeDate; // 날짜 계산을 안한다.
		private String pw; // 본인 확인용 - 수정, 삭제할 때 필요
		private String status;
		public long getNo() {
			return no;
		}
		public void setNo(long no) {
			this.no = no;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getWriter() {
			return writer;
		}
		public void setWriter(String writer) {
			this.writer = writer;
		}
		public String getWriteDate() {
			return writeDate;
		}
		public void setWriteDate(String writeDate) {
			this.writeDate = writeDate;
		}
		public String getPw() {
			return pw;
		}
		public void setPw(String pw) {
			this.pw = pw;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		@Override
		public String toString() {
			return "BookVO [no=" + no + ", title=" + title + ", content=" + content + ", writer=" + writer
					+ ", writeDate=" + writeDate + ", pw=" + pw + ", status=" + status + "]";
		}
	
	}
		

