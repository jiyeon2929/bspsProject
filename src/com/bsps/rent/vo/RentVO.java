package com.bsps.rent.vo;

import java.util.Date;

public class RentVO {

    private int rentNo;
    private int bookNo;
    private String memberNm;
    private Date rentDate;
    private String password;
    private String status;

    // 기본 생성자
    public RentVO() {}

    // 대출용 생성자
    public RentVO(int bookNo, String memberNm, String password) {
        this.bookNo = bookNo;
        this.memberNm = memberNm;
        this.password = password;
    }

    // getter / setter
    public int getRentNo() { return rentNo; }
    public void setRentNo(int rentNo) { this.rentNo = rentNo; }

    public int getBookNo() { return bookNo; }
    public void setBookNo(int bookNo) { this.bookNo = bookNo; }

    public String getMemberNm() { return memberNm; }
    public void setMemberNm(String memberNm) { this.memberNm = memberNm; }

    public Date getRentDate() { return rentDate; }
    public void setRentDate(Date rentDate) { this.rentDate = rentDate; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
