package com.ebpf.base.service.renovation;

import com.ebpf.base.model.sys.ResultInfo;

public interface RenovationService {
	
	/**
	 * 获取小区户型
	 * @param communityid 小区ID
	 * @return
	 * @throws Exception
	 */
	public ResultInfo getApartmentbyCommunityId(int communityid) throws Exception;
	
	/**
	 * 获取户型讨论内容
	 * @param apartmentid 户型ID
	 * @return
	 * @throws Exception
	 */
	public ResultInfo getApartmentdiscuss(int apartmentid) throws Exception;
	
	/**
	 * 获取户型设计
	 * @param apartmentid 户型ID
	 * @return
	 * @throws Exception
	 */
	public ResultInfo getApartmentdesign(int apartmentid) throws Exception;
	
	/**
	 * 获取户型设计效果图
	 * @param apartmentdesignid 户型设计表ID
	 * @return
	 * @throws Exception
	 */
	public ResultInfo getApartmentdesignpic(int apartmentdesignid) throws Exception;
	
	/**
	 * 获取户型设计讨论
	 * @param apartmentdesignid 户型设计表ID
	 * @return
	 * @throws Exception
	 */
	public ResultInfo getApartmentdesigndiscuss(int apartmentdesignid) throws Exception;
}
