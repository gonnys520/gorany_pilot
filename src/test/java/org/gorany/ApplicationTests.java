package org.gorany;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.Cleanup;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class ApplicationTests {
	
	@Setter(onMethod_=@Autowired)
	private DataSource ds;

	@Test
	public void contextLoads() {
	}

	@Test
	@SneakyThrows(Exception.class)
	public void testConnection(){
		
		@Cleanup Connection con = ds.getConnection();
		log.info(""+con);
		
	}
	
	@Test
	public void testAscii(){
		System.out.println((int) 'ㄱ');
		System.out.println((int) 'ㄴ');
		System.out.println((int) 'ㄷ');
		
		System.out.println((char) 12595);
		System.out.println((char) 45208);
		System.out.println((char) 45796);
	}
}
