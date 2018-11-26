package org.gorany.service;

import java.util.List;

import org.gorany.domain.UserVO;
import org.gorany.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.java.Log;

@Log
@Service
public class LoginServiceImpl implements LoginService {

	@Setter(onMethod_=@Autowired)
	private UserMapper mapper;
	
	public List<UserVO> getUserList(){
		log.info("user 리스트를 가져옵니다.");
		return mapper.getUserList();
	}
	
	public int registerUser(UserVO vo) {
		log.info("user를 새로 추가합니다.");
		
		return mapper.registerUser(vo);
	}
}
