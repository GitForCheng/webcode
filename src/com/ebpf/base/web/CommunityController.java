package com.ebpf.base.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ebpf.base.model.consite.Community;
import com.ebpf.base.model.sys.ResultInfo;
import com.ebpf.base.service.zone.ZoneService;

@Controller
public class CommunityController {

	@Autowired
	private ZoneService zs;
	
	@RequestMapping("community.htm")
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("community/community");
		mv.addObject("zones", zs.getZone());
		return mv;
	}
	
	/**
	 * 初始化小区列表
	 * @return
	 */
	@RequestMapping("getallcommunity")
	@ResponseBody
	public List<Community> getAllCommunity(){
		List<Community> cis = zs.getAllCommunity();
		return cis;
	}
	
	/**
	 * 新增
	 * @param communityName
	 * @param zoneId
	 * @return
	 */
	@RequestMapping("savecommunity/{communityName}/{zoneId}")
	@ResponseBody
	public ResultInfo saveUser(@PathVariable(value="communityName")String communityName,@PathVariable(value="zoneId")int zoneId){
		ResultInfo rs = new ResultInfo(false);
		rs = zs.saveCommunity(communityName, zoneId);
		return rs;
	}
	
}
