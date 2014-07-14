package com.ebpf.base.model.consite;

import java.util.Date;

/**
 * 工地
 * @author cheng
 *
 */
public class Consite {

	private int id;
	private String name;
	private int state;
	private int owner_Id;
	private int superVision_Id;
	private int decoTeam_Id;
	private int community_Id;
	private Date insTime;
	private int insUser;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getOwner_Id() {
		return owner_Id;
	}
	public void setOwner_Id(int ownerId) {
		owner_Id = ownerId;
	}
	public int getSuperVision_Id() {
		return superVision_Id;
	}
	public void setSuperVision_Id(int superVisionId) {
		superVision_Id = superVisionId;
	}
	public int getDecoTeam_Id() {
		return decoTeam_Id;
	}
	public void setDecoTeam_Id(int decoTeamId) {
		decoTeam_Id = decoTeamId;
	}
	public int getCommunity_Id() {
		return community_Id;
	}
	public void setCommunity_Id(int communityId) {
		community_Id = communityId;
	}
	public Date getInsTime() {
		return insTime;
	}
	public void setInsTime(Date insTime) {
		this.insTime = insTime;
	}
	public int getInsUser() {
		return insUser;
	}
	public void setInsUser(int insUser) {
		this.insUser = insUser;
	}
}
