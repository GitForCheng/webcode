package com.ebpf.base.model.renovation;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Apartmentdesigndiscuss {
	private int id;
	private int apartmentdesign_id;
	private String content;
	private int insuser;
	private Date instime;

	public int getId() {
		return id;
	}

	public int getApartmentdesign_id() {
		return apartmentdesign_id;
	}

	public void setApartmentdesign_id(int apartmentdesign_id) {
		this.apartmentdesign_id = apartmentdesign_id;
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
