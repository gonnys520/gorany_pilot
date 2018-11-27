package org.gorany;

import org.gorany.mapper.MenuMapper;
import org.gorany.mapper.SearchMapper;
import org.gorany.mapper.TimeMapper;
import org.gorany.mapper.UserMapper;
import org.gorany.service.SearchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.Setter;
import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class SampleTests {

	@Setter(onMethod_=@Autowired)
	private UserMapper mapper;
	
	@Setter(onMethod_=@Autowired)
	private TimeMapper timemapper;
	
	@Setter(onMethod_=@Autowired)
	private MenuMapper menumapper;
	
	@Setter(onMethod_=@Autowired)
	private SearchMapper searchmapper;
	
	@Setter(onMethod_=@Autowired)
	private SearchService searchService;

	
	@Test
	public void getTime() {
		log.info(timemapper.getTime());
	}
	
	@Test
	public void testGet() {
		log.info("" + mapper.getUserList());
	}
	
	@Test
	public void testMenuName() {
		log.info("" + searchmapper.getMenuName());
	}
	
	@Test
	public void testSearchMenu() {
		String keyword = "아";
		log.info("" + searchmapper.searchMenu(keyword));
	}
	
	@Test
	public void testSearchStore() {
		String keyword = "고라니";
		log.info("" + searchmapper.searchStore(keyword));
	}
	

	
}
