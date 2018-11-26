package org.gorany.domain.kakaopay;

import java.util.Date;

import org.json.JSONArray;

import lombok.Data;

@Data
public class KakaoPayReadyVO {
	
	//response
	private String tid, next_redirect_pc_url;
	private Date created_at;
	
	//request
	private String cid, partner_order_id, partner_user_id;
	private String item_name, item_code;
	private Integer quantity, total_amount, tax_free_amount, vat_amount;
	private String approval_url, cancel_url, fail_url;
	private JSONArray available_cards;
	private String payment_method_type;
	private Integer install_month;
}
