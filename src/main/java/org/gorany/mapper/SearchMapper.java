package org.gorany.mapper;

import java.util.List;

import org.gorany.domain.MenuVO;

public interface SearchMapper {
	
	public List<MenuVO> search(String keyword);

	public String[] getMenuName();
}
