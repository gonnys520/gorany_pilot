package org.gorany.service;

import java.util.List;

import org.gorany.domain.MenuVO;
import org.gorany.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.java.Log;

@Service
@Log
public class MenuServiceImpl implements MenuService {

	@Setter(onMethod_=@Autowired)
	private MenuMapper mapper;

	@Override
	public List<MenuVO> getMenu() {
		
		return mapper.getMenu();
	}
	
	
}
