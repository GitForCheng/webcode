package com.ebpf.base.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ebpf.base.model.sys.ResultInfo;
import com.ebpf.base.service.renovation.RenovationService;

@Controller
public class RenovationController {

	@Autowired
	private RenovationService rvs;
	
	/**
	 * 小区户型列表
	 * @param communityid
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,value="/getapartments/{communityid}")
	@ResponseBody
	public ResultInfo getapartments(@PathVariable(value="communityid")int communityid){
		ResultInfo rs = new ResultInfo(false);
		try {
		    rs = rvs.getApartmentbyCommunityId(communityid);
		} catch (Exception e) {
			rs.setMsg("异常信息为:"+e.getMessage());
		}
		return rs;
	}
	
	/**
	 * 小区户型设计列表
	 * @param communityid
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,value="/getapartmentsdesignlist/{apartmentid}")
	@ResponseBody
	public ResultInfo getapartmentsdesign(@PathVariable(value="apartmentid")int apartmentid){
		ResultInfo rs = new ResultInfo(false);
		try {
		    rs = rvs.getApartmentdesign(apartmentid);
		} catch (Exception e) {
			rs.setMsg("异常信息为:"+e.getMessage());
		}
		return rs;
	}
}
