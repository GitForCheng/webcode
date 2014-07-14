package com.ebpf.base.model.renovation;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Apartmentdesigndiscuss {
	private Integer id;
	private Integer apartmentdesign_id;
	private String apartmentdesign_Name;
	private String content;
	private Integer insuser;
	private String insuser_Name;
	private Date instime;

	public void setId(Integer id) {
		this.id = id;
	}

	public void setInstime(Date instime) {
		this.instime = instime;
	}

	public String getInsuser_Name() {
		return insuser_Name;
	}

	public void setInsuser_Name(String insuserName) {
		insuser_Name = insuserName;
	}

	public String getApartmentdesign_Name() {
		return apartmentdesign_Name;
	}

	public void setApartmentdesign_Name(String apartmentdesignName) {
		apartmentdesign_Name = apartmentdesignName;
	}

	public Integer getId() {
		return id;
	}

	public Integer getApartmentdesign_id() {
		return apartmentdesign_id;
	}

	public void setApartmentdesign_id(Integer apartmentdesign_id) {
		this.apartmentdesign_id = apartmentdesign_id;
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
