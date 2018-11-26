package org.gorany.mapper;

import java.util.List;

import org.gorany.domain.UserVO;

public interface UserMapper {

	
	public List<UserVO> getUserList();
	
	public int registerUser(UserVO vo);
	
}
