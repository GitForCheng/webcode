package com.ebpf.base.model;

public class User {
	private Integer id;
	private String name;
    private String psd;
    private Integer roleId;
    private String roleName;
    
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

	public String getPsd() {
		return psd;
	}

	public void setPsd(String psd) {
		this.psd = psd;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
