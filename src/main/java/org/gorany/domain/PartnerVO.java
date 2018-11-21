package org.gorany.domain;

import java.util.Date;

import lombok.Data;

@Data
public class PartnerVO {

	private int pno;
	private String pid, ppw, pmail, owner_name;
	private String owner_num;
	private Date regdate, updatedate;
}
