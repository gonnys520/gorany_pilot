package org.gorany;

import org.gorany.mapper.TimeMapper;
import org.gorany.mapper.UserMapper;
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
	

	
	@Test
	public void getTime() {
		log.info(timemapper.getTime());
	}
	
	@Test
	public void testGet() {
		log.info("" + mapper.getUserList());
	}
	
}
