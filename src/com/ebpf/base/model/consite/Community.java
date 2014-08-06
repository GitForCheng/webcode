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
    private String zoneName;
    private String icon;
    //户型数
    private Long aCounts;
    //户型装修方案
    private Long designCounts;
    
	public Long getaCounts() {
		return aCounts;
	}

	public void setaCounts(Long aCounts) {
		this.aCounts = aCounts;
	}

	public Long getDesignCounts() {
		return designCounts;
	}

	public void setDesignCounts(Long designCounts) {
		this.designCounts = designCounts;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
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

	public Integer getZone_Id() {
		return zone_Id;
	}

	public void setZone_Id(Integer zoneId) {
		zone_Id = zoneId;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

}
