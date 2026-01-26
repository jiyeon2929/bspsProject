package com.bsps.rent.service;

import java.util.List;

import com.bsps.rent.dao.RentDAO;
import com.bsps.rent.vo.RentVO;

public class RentService {

    private RentDAO dao = new RentDAO();

    // 대출
    public void rent(RentVO vo) throws Exception {
        dao.insert(vo);
    }

    // 반납 (비밀번호 검증 핵심)
    public boolean returnBook(int rentNo, String pw) throws Exception {
        String dbPw = dao.getPassword(rentNo);
        if (dbPw == null) return false;
        if (!dbPw.equals(pw)) return false;

        dao.returnBook(rentNo);
        return true;
    }

    // 리스트
    public List<RentVO> list() throws Exception {
        return dao.list();
    }
}
