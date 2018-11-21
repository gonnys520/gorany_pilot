package org.gorany.controller;

import org.gorany.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.Setter;
import lombok.extern.java.Log;

@Controller
@Log
public class SampleController {
	
	@Setter(onMethod_=@Autowired)
	private MenuService service;

	@GetMapping("/sample1")
	public void sample1(Model model) {
		
		model.addAttribute("greeting", "HelloWorld");
		
	}
	
	@GetMapping("/index")
	public void sample2(Model model) {
		log.info("sample2.....");
		
		model.addAttribute("menu", service.getMenu());
	}
	
	@GetMapping("/home")
	public void sample3(Model model) {
	
	}
	
}
