package org.gorany.service;

import java.util.List;

import org.gorany.domain.MenuVO;
import org.gorany.domain.StoreVO;

public interface SearchService {

	public List<MenuVO> searchMenu(String keyword);
	
	public List<StoreVO> searchStore(String keyword);
	
	public List<String> getMenuName();
	
	public List<String> getStoreName();
}
