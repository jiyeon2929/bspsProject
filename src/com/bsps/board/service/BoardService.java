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

    public BoardVO viewForUpdate(long no, String pw) throws Exception {
        return dao.viewWithPw(no, pw);
    }

    public void update(BoardVO vo) throws Exception {
        dao.update(vo);
    }

    public boolean delete(long no, String pw) throws Exception {
        return dao.delete(no, pw) == 1;
    }
}
