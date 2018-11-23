package org.gorany.domain.kakaopay;

import java.util.Date;

import lombok.Data;

@Data
public class KakaoPayReadyVO {
	
	private String tid, tms_result, next_redirect_pc_url;
	private Date created_at;
}
