package com.bsps.member.service;

import com.bsps.main.service.Service;
import com.bsps.member.dao.MemberDAO;
import com.bsps.member.vo.Login;

public class LoginService implements Service {
	
	public Login servic(Object obj) throws Exception{
		
		MemberDAO dao = new MemberDAO();
		
		return dao.login((LoginVO), obj);
	}

}
