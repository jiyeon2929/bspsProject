package com.bsps.member.service;

import com.bsps.main.service.Service;
import com.bsps.member.dao.MemberDAO;

public class MemberChangePwService implements Service {

	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		MemberDAO dao = new MemberDAO();
		return dao;
	}

}
