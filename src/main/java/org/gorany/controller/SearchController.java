package org.gorany.controller;

import java.util.List;

import org.gorany.domain.MenuVO;
import org.gorany.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Setter;
import lombok.extern.java.Log;

@Controller
@Log
public class SearchController {

	@Setter(onMethod_=@Autowired)
	private SearchService service;
	
	@PostMapping("/autocomplete")
	@ResponseBody
	public ResponseEntity<String[]> autoComplete(){
		log.info("autocomplete");
		return new ResponseEntity<>(service.getMenuName(),HttpStatus.OK);
	}
	
	@GetMapping("/search/{keyword}")
	@ResponseBody
	public ResponseEntity<List<MenuVO>> search(@PathVariable("keyword") String keyword){
		log.info("search post.....");
		log.info(""+keyword);
		log.info(""+service.search(keyword));
		return new ResponseEntity<>(service.search(keyword),HttpStatus.OK);
	}
	
}
