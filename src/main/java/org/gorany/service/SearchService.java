package org.gorany.service;

import java.util.List;

import org.gorany.domain.MenuVO;

public interface SearchService {

	public List<MenuVO> search(String keyword);
	
	public String[] getMenuName();
}
