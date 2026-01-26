package com.bsps.book.Service;

import com.bsps.book.dao.BookDAO;
import com.bsps.book.vo.BookVO;
import com.bsps.main.service.Service;


public class BookUpdateService implements Service {

	@Override
	public Integer service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		BookDAO dao = new BookDAO();
		return dao.update((BookVO) obj);
	}
	

}
