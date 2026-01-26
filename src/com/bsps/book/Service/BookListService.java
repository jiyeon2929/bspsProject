package com.bsps.book.Service;

import java.util.List;

import com.bsps.book.dao.BookDAO;
import com.bsps.book.vo.BookVO;
import com.bsps.main.service.Service;

public class BookListService implements Service{

	@Override
	public List<BookVO> service(Object obj) throws Exception {
		BookDAO dao = new BookDAO();
		return dao.list();
	}

}
