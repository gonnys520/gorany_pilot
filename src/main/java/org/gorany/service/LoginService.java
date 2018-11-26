package org.gorany.service;

import java.util.List;

import org.gorany.domain.UserVO;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

	public List<UserVO> getUserList();
	
	public int registerUser(UserVO vo);
}
