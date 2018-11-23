package org.gorany.controller;

import org.gorany.service.KakaoPay;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.java.Log;

@Controller
@Log
public class KakaoPayController {
	
	
	
	@PostMapping("/kakaoPay")
	public String kakaoPay() {
		log.info("kakaoPay post............................................");

		KakaoPay kakaopay = new KakaoPay();
		
		return "redirect:" + kakaopay.kakaoPayReady();

	}
	
	@GetMapping("/kakaopay/kakaoPaySuccess")
	public void kakaoPaySuccess(Model model) {
	
	}

}
