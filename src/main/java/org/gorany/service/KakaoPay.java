package org.gorany.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.gorany.domain.kakaopay.KakaoPayInfoVO;
import org.gorany.domain.kakaopay.KakaoPayReadyVO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import lombok.extern.java.Log;

@Service
@Log
public class KakaoPay {

	private static final String HOST = "https://kapi.kakao.com";
	
	private KakaoPayReadyVO kakaoPayReadyVO;
	private KakaoPayInfoVO kakaoPayInfoVO;
	
	public String kakaoPayReady() {

		RestTemplate restTemplate = new RestTemplate();

		// 서버로 요청할 Header
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + "21e1a296e2c3aabd8c183e424ead22b5");
		headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");

		// 서버로 요청할 Body
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("cid", "TC0ONETIME");
		params.add("partner_order_id", "1001");
		params.add("partner_user_id", "gorany");
		params.add("item_name", "갤럭시S9");
		params.add("quantity", "1");
		params.add("total_amount", "1000");
		params.add("tax_free_amount", "0");
		params.add("approval_url", "http://localhost:8080/kakaopay/kakaoPaySuccess");
		params.add("cancel_url", "http://localhost:8080/kakaoPayCancel");
		params.add("fail_url", "http://localhost:8080/kakaoPaySuccessFail");

		HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);

		try {
			kakaoPayReadyVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/ready"), body, KakaoPayReadyVO.class);
			
			log.info("" + kakaoPayReadyVO);
			
			return kakaoPayReadyVO.getNext_redirect_pc_url();

		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "/pay";
		
	}
	
	public KakaoPayInfoVO kakaoPayInfo(String pg_token) {

		log.info("KakaoPayInfoVO............................................");
		log.info("-----------------------------");
		
		RestTemplate restTemplate = new RestTemplate();

		// 서버로 요청할 Header
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + "21e1a296e2c3aabd8c183e424ead22b5");
		headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");

		// 서버로 요청할 Body
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("cid", "TC0ONETIME");
		params.add("tid", kakaoPayReadyVO.getTid());
		params.add("partner_order_id", "1001");
		params.add("partner_user_id", "gorany");
		params.add("pg_token", pg_token);
		params.add("total_amount", "1000");
		
		HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
		
		try {
			kakaoPayInfoVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/approve"), body, KakaoPayInfoVO.class);
			
			log.info("" + kakaoPayInfoVO);
			
			return kakaoPayInfoVO;
		
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
