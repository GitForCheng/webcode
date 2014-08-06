package com.ebpf.base.service.zone;

import java.util.List;

import com.ebpf.base.model.consite.Community;
import com.ebpf.base.model.consite.Zone;
import com.ebpf.base.model.sys.ResultInfo;

public interface ZoneService {

	/**
	 * 获取所有区域
	 * @return
	 */
	public List<Zone> getZone();
	
	/**
	 * 获取所有小区
	 * @return
	 */
	public List<Community> getAllCommunity();
	
	/**
	 * 根据名字获取所有小区
	 * @return
	 */
	public List<Community> getAllCommunityByName(String cName);
	
	/**
	 * 新增
	 * @param communityName
	 * @param zoneId
	 * @return
	 */
	public ResultInfo saveCommunity(String communityName,int zoneId);
}
