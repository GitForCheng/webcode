package com.ebpf.base.service.consite;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ebpf.base.model.consite.CommunityInfo;
import com.ebpf.base.model.sys.ResultInfo;

public interface ConsiteService{

	/**
	 * 获取所有工地信息
	 * @return
	 */
	public List<CommunityInfo> getallconsiteInfo();
	
	/**
	 * 保存工地
	 * @param name
	 * @param communityId
	 * @param state
	 * @param yezhu
	 * @param jianli
	 * @param zhuangxiudui
	 * @return
	 */
	public ResultInfo saveNewConsite(String name,int communityId,int state,int yezhu,int jianli,int zhuangxiudui);
	
	/**
	 * 获取工地信息
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public ResultInfo getCommunitysByUser(int userId) throws Exception;
	
	/**
	 * 上传工地图片
	 * @param file 图片
	 * @param consiteId 工地ID
	 * @param consiteState 工地状态
	 * @return
	 * @throws Exception
	 */
	public ResultInfo uploadConsitePic(MultipartFile file,int consiteId,int consiteState,String path) throws Exception;
	
	/**
	 * 获取工地图片列表信息
	 * @param consiteId
	 * @return
	 * @throws Exception
	 */
	public ResultInfo getAllConsitePices(int consiteId) throws Exception;
	
	/**
	 * 获取工地相应状态图片列表信息
	 * @param consiteId
	 * @return
	 * @throws Exception
	 */
	public ResultInfo getAllConsiteStatePices(int consiteId,int state) throws Exception;
	
	/**
	 * 删除工地图片
	 * @param picId
	 * @return
	 * @throws Exception
	 */
	public ResultInfo deleteConsitePic(int picId) throws Exception;
	
	/**
	 * 修改工地状态
	 * @param picId
	 * @return
	 * @throws Exception
	 */
	public ResultInfo modifyConsiteState(int consiteid,int state) throws Exception;
}
