package com.ebpf.base.model.renovation;

public class Apartmentdesignpic {
	private int id;
	private int apartmentdesign_id;
	private String picture_path;
	private String description;

	public int getId() {
		return id;
	}

	public int getApartmentdesign_id() {
		return apartmentdesign_id;
	}

	public void setApartmentdesign_id(int apartmentdesign_id) {
		this.apartmentdesign_id = apartmentdesign_id;
	}

	public String getPicture_path() {
		return picture_path;
	}

	public void setPicture_path(String picture_path) {
		this.picture_path = picture_path;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
