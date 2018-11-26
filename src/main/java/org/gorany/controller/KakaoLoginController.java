package org.gorany.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.gorany.domain.UserVO;
import org.gorany.service.KakaoLogin;
import org.gorany.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.Setter;
import lombok.extern.java.Log;

@RestController
@Log
public class KakaoLoginController {

	@Setter(onMethod_=@Autowired)
	private LoginService service;
	
	@RequestMapping(value = "/kakaologin" , produces = "application/json", method = {RequestMethod.GET, RequestMethod.POST})
	public String kakaoLogin(@RequestParam("code") String code , HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{

	  JsonNode token = KakaoLogin.getAccessToken(code);
	  log.info("=====" + code);
	  log.info("=====" + token);
	  
	  JsonNode profile = KakaoLogin.getKakaoUserInfo(token.path("access_token").toString());
	  System.out.println("profile: " + profile);
	  
	  UserVO vo = KakaoLogin.changeData(profile);
	  service.registerUser(vo);
	  
	  //이건 왜 하는거지?
	  session.setAttribute("login", vo);
	  
	  System.out.println("session: " + session);
	  System.out.println(vo.toString());
		  
	  response.sendRedirect("/home");
	  return "redirect:/home";
	}
}
