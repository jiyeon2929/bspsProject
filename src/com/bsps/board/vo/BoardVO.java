package com.bsps.board.vo;

import java.sql.Date;

public class BoardVO {

    private long no;          // 글번호
    private String title;     // 제목
    private String content;   // 내용
    private String writer;    // 작성자
    private Date writeDate;   // 작성일
    private long hit;         // 조회수
    private String pw;        // 비밀번호

    // getter / setter
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
    public Date getWriteDate() {
        return writeDate;
    }
    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }
    public long getHit() {
        return hit;
    }
    public void setHit(long hit) {
        this.hit = hit;
    }
    public String getPw() {
        return pw;
    }
    public void setPw(String pw) {
        this.pw = pw;
    }

    @Override
    public String toString() {
        return no + " / " + title + " / " + writer + " / " + writeDate + " / " + hit;
    }
}
