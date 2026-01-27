package com.bsps.board.service;

import java.util.List;

import com.bsps.board.dao.BoardDAO;
import com.bsps.board.vo.BoardVO;

public class BoardService {

    private BoardDAO dao = new BoardDAO();

    public List<BoardVO> list() throws Exception {
        return dao.list();
    }

    public void write(BoardVO vo) throws Exception {
        dao.write(vo);
    }

    // 🔥 수정 핵심
    public BoardVO view(long no) throws Exception {
        BoardVO vo = dao.view(no);   // 1️⃣ 먼저 조회

        if (vo == null) {
            return null;             // 글 없음
        }

        dao.increaseHit(no);         // 2️⃣ 조회수 증가
        vo.setHit(vo.getHit() + 1);  // 화면용 hit 보정

        return vo;
    }
}
