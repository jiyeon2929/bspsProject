package com.bsps.member.service;

import com.bsps.main.service.Service;
import com.bsps.member.dao.MemberDAO;
import com.bsps.member.vo.Login;
import com.bsps.member.vo.LoginVO;


public class LoginService implements Service {

	@Override
	public LoginVO service(Object obj) throws Exception {
		
		// TODO Auto-generated method stub
		MemberDAO dao = new MemberDAO();
		return dao.login((LoginVO) obj);
	}
	
	

}
