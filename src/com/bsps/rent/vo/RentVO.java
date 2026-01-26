package com.bsps.rent.vo;

public class RentVO {

    private int rentNo;
    private String memberId;
    private String bookTitle;
    private String rentDate;
    private String status;
    private String password;

    public RentVO(int rentNo, String password, String status) {
        this.rentNo = rentNo;
        this.password = password;
        this.status = status;
    }

    public RentVO(String memberId, String bookTitle, String rentDate, String status) {
        this.memberId = memberId;
        this.bookTitle = bookTitle;
        this.rentDate = rentDate;
        this.status = status;
    }

    public int getRentNo() {
        return rentNo;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return status;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getRentDate() {
        return rentDate;
    }

	@Override
	public String toString() {
		return "RentVO [rentNo=" + rentNo + ", memberId=" + memberId + ", bookTitle=" + bookTitle + ", rentDate="
				+ rentDate + ", status=" + status + ", password=" + password + "]";
	}
}
