package com.ebpf.base.model.consite;

import java.text.SimpleDateFormat;
import java.util.Date;


public class CommunityInfo {
	private Integer id;
	private Integer ownerId;
	private Integer superVisionId;
	private Integer decoteamId;
	private String name;
	private Integer state;
	private String statName;
	private Integer communityId;
	private String communityName;
	private String OwnerName;
	private String superVisionName;
	private String decoteamName;
    private Date instime;
    
	public String getInstime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(instime);
	}

	public String getStatName() {
		return statName;
	}


	public void setStatName(String statName) {
		this.statName = statName;
	}


	public Integer getOwnerId() {
		return ownerId;
	}


	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}


	public Integer getSuperVisionId() {
		return superVisionId;
	}


	public void setSuperVisionId(Integer superVisionId) {
		this.superVisionId = superVisionId;
	}


	public Integer getDecoteamId() {
		return decoteamId;
	}


	public void setDecoteamId(Integer decoteamId) {
		this.decoteamId = decoteamId;
	}


	public String getCommunityName() {
		return communityName;
	}


	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}


	public String getOwnerName() {
		return OwnerName;
	}


	public void setOwnerName(String ownerName) {
		OwnerName = ownerName;
	}


	public String getSuperVisionName() {
		return superVisionName;
	}


	public void setSuperVisionName(String superVisionName) {
		this.superVisionName = superVisionName;
	}


	public String getDecoteamName() {
		return decoteamName;
	}


	public void setDecoteamName(String decoteamName) {
		this.decoteamName = decoteamName;
	}


	public void setInstime(Date instime) {
		this.instime = instime;
	}

	public void setCommunityId(Integer communityId) {
		this.communityId = communityId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getCommunityId() {
		return communityId;
	}
}
