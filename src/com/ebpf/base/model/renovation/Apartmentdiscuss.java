package com.ebpf.base.model.renovation;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Apartmentdiscuss {
	private Integer id;
	private Integer apartment_id;
	private String apartment_Name;
	private String content;
	private Integer insuser;
	private String insuser_Name;
	private Date instime;

	public String getApartment_Name() {
		return apartment_Name;
	}

	public void setApartment_Name(String apartmentName) {
		apartment_Name = apartmentName;
	}

	public String getInsuser_Name() {
		return insuser_Name;
	}

	public void setInsuser_Name(String insuserName) {
		insuser_Name = insuserName;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setInstime(Date instime) {
		this.instime = instime;
	}

	public Integer getId() {
		return id;
	}

	public Integer getApartment_id() {
		return apartment_id;
	}

	public void setApartment_id(Integer apartment_id) {
		this.apartment_id = apartment_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getInsuser() {
		return insuser;
	}

	public void setInsuser(Integer insuser) {
		this.insuser = insuser;
	}

	public String getInstime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(instime);
	}

}
