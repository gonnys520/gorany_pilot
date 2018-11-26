package org.gorany.controller;

import org.gorany.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Setter;
import lombok.extern.java.Log;

@Controller
@Log
public class SearchController {

	@Setter(onMethod_=@Autowired)
	private MenuService service;
	
	@PostMapping("/autocomplete")
	@ResponseBody
	public ResponseEntity<String[]> deleteFile(String fileName, String type){
		
		return new ResponseEntity<>(service.getMenuName(),HttpStatus.OK);
	}
	
}
