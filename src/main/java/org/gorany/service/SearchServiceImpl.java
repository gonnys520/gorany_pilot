package org.gorany.service;

import java.util.List;

import org.gorany.domain.MenuVO;
import org.gorany.mapper.SearchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.java.Log;

@Service
@Log
public class SearchServiceImpl implements SearchService{

	@Setter(onMethod_=@Autowired)
	private SearchMapper mapper;
	
	@Override
	public List<MenuVO> search(String keyword) {
		
		return mapper.search(keyword);
	}
	
	@Override
	public String[] getMenuName() {
		
		return mapper.getMenuName();
	}

}
