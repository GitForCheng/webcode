package com.ebpf.base.service.designer;

import com.ebpf.base.model.sys.ResultInfo;

public interface DesignerService {

	/**
	 * 获取所有设计公司
	 * @return
	 */
	public ResultInfo getAllDesigners();
	
	/**
	 * 根据名字查询设计公司
	 * @param dName
	 * @return
	 */
	public ResultInfo getDesignersByName(String dName);
}
