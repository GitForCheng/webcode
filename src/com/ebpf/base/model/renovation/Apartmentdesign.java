package com.ebpf.base.model.renovation;

public class Apartmentdesign {
	private Integer id;
	private String title;
	private Integer apartment_id;
	private Integer designer_id;
	private Integer style_id;
    private String style_Name;
    private String apartment_Name;
    private String designer_Name;
    
	
	public String getStyle_Name() {
		return style_Name;
	}

	public void setStyle_Name(String styleName) {
		style_Name = styleName;
	}

	public String getApartment_Name() {
		return apartment_Name;
	}

	public void setApartment_Name(String apartmentName) {
		apartment_Name = apartmentName;
	}

	public String getDesigner_Name() {
		return designer_Name;
	}

	public void setDesigner_Name(String designerName) {
		designer_Name = designerName;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getApartment_id() {
		return apartment_id;
	}

	public void setApartment_id(Integer apartment_id) {
		this.apartment_id = apartment_id;
	}

	public Integer getDesigner_id() {
		return designer_id;
	}

	public void setDesigner_id(Integer designer_id) {
		this.designer_id = designer_id;
	}

	public Integer getStyle_id() {
		return style_id;
	}

	public void setStyle_id(Integer style_id) {
		this.style_id = style_id;
	}
}
