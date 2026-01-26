package com.bsps.rent.service;

import com.bsps.rent.dao.RentDAO;
import com.bsps.rent.vo.RentVO;

public class RentService {

    private RentDAO dao = new RentDAO();

    // 대출
    public void rentBook(String memberId, String title, String password) throws Exception {
        dao.rent(memberId, title, password);
    }

    // 반납 (검증 포함)
    public boolean returnBook(int rentNo, String inputPw) throws Exception {

        RentVO vo = dao.getByNo(rentNo);

        if (vo == null) {
            return false; // 글 번호 없음
        }

        if (!vo.getPassword().equals(inputPw)) {
            return false; // 비밀번호 불일치
        }

        if (!vo.getStatus().equals("대출중")) {
            return false; // 이미 반납됨
        }

        dao.returnBook(rentNo);
        return true;
    }
}
