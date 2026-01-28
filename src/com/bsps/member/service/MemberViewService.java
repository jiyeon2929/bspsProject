package com.bsps.member.service;

import com.bsps.main.service.Service;
import com.bsps.member.dao.MemberDAO;
import com.bsps.member.vo.MemberVO;

public class MemberViewService implements Service {

	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		MemberVO param = (MemberVO) obj;
		MemberDAO dao = new MemberDAO();
		
		return dao.view(param);
	}

}
