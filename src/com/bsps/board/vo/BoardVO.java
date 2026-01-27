package com.bsps.board.vo;

import java.sql.Date;

public class BoardVO {

    private long no;
    private String title;
    private String content;
    private String writer;
    private Date writeDate;
    private long hit;
    private String pw;

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
