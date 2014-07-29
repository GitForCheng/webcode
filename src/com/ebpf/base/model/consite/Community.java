package com.ebpf.base.model.consite;

/**
 * 社区
 * @author cheng
 * 
 */
public class Community {
	private Integer id;
	private String name;
	private Integer zone_Id;

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

	public Integer getZone_Id() {
		return zone_Id;
	}

	public void setZone_Id(Integer zoneId) {
		zone_Id = zoneId;
	}

}
