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

    public BoardVO view(long no) throws Exception {
        dao.increaseHit(no);
        return dao.view(no);
    }

    // ⭐ 제목만 수정
    public boolean updateTitle(BoardVO vo) throws Exception {
        return dao.updateTitle(vo) == 1;
    }
}
