package com.bsps.book.Service;

import com.bsps.book.dao.BookDAO;
import com.bsps.main.service.Service;

public class BookDeleteService implements Service{

	@Override
	public Integer service(Object obj) throws Exception {
		BookDAO dao = new BookDAO();
		return dao.delete();
	}

}
