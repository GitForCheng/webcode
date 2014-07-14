package com.ebpf.base.model.consite;

/**
 * 社区
 * @author cheng
 * 
 */
public class Community {
	private int id;
	private String name;
	private int zone_Id;

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

	public int getZone_Id() {
		return zone_Id;
	}

	public void setZone_Id(int zoneId) {
		zone_Id = zoneId;
	}

}
