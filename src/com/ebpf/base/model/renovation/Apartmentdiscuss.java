package com.ebpf.base.model.renovation;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Apartmentdiscuss {
	private int id;
	private int apartment_id;
	private String content;
	private int insuser;
	private Date instime;

	public int getId() {
		return id;
	}

	public int getApartment_id() {
		return apartment_id;
	}

	public void setApartment_id(int apartment_id) {
		this.apartment_id = apartment_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getInsuser() {
		return insuser;
	}

	public void setInsuser(int insuser) {
		this.insuser = insuser;
	}

	public String getInstime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(instime);
	}

}
