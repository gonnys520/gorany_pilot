package org.gorany.mapper;

import java.util.List;

import org.gorany.domain.MenuVO;
import org.gorany.domain.StoreVO;

public interface SearchMapper {
	
	public List<MenuVO> searchMenu(String keyword);

	public List<StoreVO> searchStore(String keyword);
	
	public String[] getMenuName();
}
