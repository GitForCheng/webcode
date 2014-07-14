package com.ebpf.base.model.renovation;

public class Apartment {
	private Integer id;
	private String title;
	private Integer community_id;
	private String roomcount;
	private Integer roomarea;
	private String description;
	private String icon;

	public Integer getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getCommunity_id() {
		return community_id;
	}

	public void setCommunity_id(Integer community_id) {
		this.community_id = community_id;
	}

	public String getRoomcount() {
		return roomcount;
	}

	public void setRoomcount(String roomcount) {
		this.roomcount = roomcount;
	}

	public Integer getRoomarea() {
		return roomarea;
	}

	public void setRoomarea(Integer roomarea) {
		this.roomarea = roomarea;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
}
