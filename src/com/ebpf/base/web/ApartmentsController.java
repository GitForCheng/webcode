package com.ebpf.base.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ebpf.base.model.sys.ResultInfo;
import com.ebpf.base.service.renovation.RenovationService;

/**
 * 小区户型
 * @author cheng
 *
 */

@Controller
public class ApartmentsController {

	@Autowired
	private RenovationService rvs;
	
	/**
	 * 获取户型列表
	 * @return
	 */
	@RequestMapping("getapmtsbycid/{communityid}")
	@ResponseBody
	public ResultInfo getApartmentsByCommunity(@PathVariable(value="communityid")int cId){
		ResultInfo rs = new ResultInfo(false); 
		try {
			rs = rvs.getApartmentbyCommunityId(cId);
		} catch (Exception e) {
			rs.setMsg("获取户型列表失败:小区ID【"+cId+"】"+e.getMessage());
		}
		return rs;
	}
	
	/**
	 * 获取户型讨论列表
	 * @return
	 */
	@RequestMapping("getapmtsdiscussbycid/{apmtid}")
	@ResponseBody
	public ResultInfo getDiscussByApmtId(@PathVariable(value="apmtid")int apmtId){
		ResultInfo rs = new ResultInfo(false); 
		try {
			rs = rvs.getApartmentdiscuss(apmtId);
		} catch (Exception e) {
			rs.setMsg("获取户型讨论列表失败：户型ID【"+apmtId+"】"+e.getMessage());
		}
		return rs;
	}
	
	/**
	 * 增加户型讨论
	 * @return
	 */
	@RequestMapping("insertapmtdiscuss/{apmtid}/{istUser}/{content}")
	@ResponseBody
	public ResultInfo submit(@PathVariable(value="apmtid")int apmtId,@PathVariable(value="content")String content,@PathVariable(value="istUser")int istUser){
		ResultInfo rs = new ResultInfo(false); 
		try {
			rs = rvs.insertApartmentDiscuss(apmtId, istUser, content);
		} catch (Exception e) {
			rs.setMsg(e.getMessage());
		}
		return rs;
	}
}
