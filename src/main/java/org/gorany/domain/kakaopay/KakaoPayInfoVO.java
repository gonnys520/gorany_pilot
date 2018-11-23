package org.gorany.domain.kakaopay;

import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

import lombok.Data;

@Data
public class KakaoPayInfoVO {

	private String aid, tid, cid, sid;
	private String partner_order_id, partner_user_id, payment_method_type;
	private JSONObject amount, card_info;
	private String item_name, item_code, payload;
	private Integer quantity;
	private Date created_at, approved_at;
	
}
