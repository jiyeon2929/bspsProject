package com.bsps.board.controller;

import java.util.List;

import com.bsps.board.service.BoardService;
import com.bsps.board.vo.BoardVO;
import com.bsps.util.io.In;

public class BoardController {

    private BoardService service = new BoardService();

    public void execute() throws Exception {
        while (true) {
            System.out.println("\n<<< 일반 게시판 >>>");
            System.out.println("1. 리스트  2. 글보기  3. 글등록  4. 글수정  5. 글삭제  0. 이전");

            String menu = In.getStr("메뉴");

            switch (menu) {
            case "1": list(); break;
            case "2": view(); break;
            case "3": write(); break;
            case "4": update(); break;
            case "5": delete(); break;
            case "0": return;
            default:
                System.out.println("잘못된 메뉴입니다.");
            }
        }
    }

    private void list() throws Exception {
        List<BoardVO> list = service.list();
        System.out.println("----------------------------------");
        System.out.println("번호 / 제목 / 작성자 / 작성일 / 조회수");
        for (BoardVO vo : list) {
            System.out.println(vo);
        }
    }

    private void view() throws Exception {
        long no = In.getLong("글 번호");
        BoardVO vo = service.view(no);

        if (vo == null) {
            System.out.println("해당 글이 존재하지 않습니다.");
            return;
        }

        System.out.println("제목 : " + vo.getTitle());
        System.out.println("작성자 : " + vo.getWriter());
        System.out.println("내용 : " + vo.getContent());
        System.out.println("조회수 : " + vo.getHit());
    }

    private void write() throws Exception {
        BoardVO vo = new BoardVO();
        vo.setTitle(In.getStr("제목"));
        vo.setContent(In.getStr("내용"));
        vo.setWriter(In.getStr("작성자"));
        vo.setPw(In.getStr("비밀번호"));

        service.write(vo);
        System.out.println("글 등록 완료!");
    }

    // 제목만 수정
    private void update() throws Exception {
        long no = In.getLong("수정할 글 번호");
        String pw = In.getStr("비밀번호");
        String title = In.getStr("새 제목");

        BoardVO vo = new BoardVO();
        vo.setNo(no);
        vo.setPw(pw);
        vo.setTitle(title);

        if (service.updateTitle(vo)) {
            System.out.println("글 수정 완료!");
        } else {
            System.out.println("글 번호 또는 비밀번호가 틀렸습니다.");
        }
    }

    // ⭐ 글삭제
    private void delete() throws Exception {
        long no = In.getLong("삭제할 글 번호");
        String pw = In.getStr("비밀번호");

        if (service.delete(no, pw)) {
            System.out.println("글 삭제 완료!");
        } else {
            System.out.println("글 번호 또는 비밀번호가 틀렸습니다.");
        }
    }
}
