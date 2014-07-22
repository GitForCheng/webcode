package com.ebpf.base.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ebpf.base.model.sys.ResultInfo;
import com.ebpf.base.service.consite.ConsiteService;

@Controller
public class ConsitController {

	@Autowired
	private ConsiteService css;

	/**
	 * 获取工地信息
	 * @param userId
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,value="/getusersconsite/{userid}")
	@ResponseBody
	public ResultInfo getUserCommunities(@PathVariable("userid")int userId){
		ResultInfo rs = new ResultInfo(false);
		try {
			 rs = css.getCommunitysByUser(userId);
		} catch (Exception e) {
			 rs.setMsg(e.getMessage());
		}
		
		return rs;
	}
	
	/**
	 * 上传工地图片
	 * @param request
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST,value="/uploadconsitepic")
	@ResponseBody
	public ResultInfo uploadPic(HttpServletRequest request,@Value("#{config['consitePicSavePath']}")String savePath){
		ResultInfo rs = new ResultInfo(false);
		MultipartHttpServletRequest multipartRequest  =  (MultipartHttpServletRequest) request;  
		int consiteId = Integer.parseInt(multipartRequest.getParameter("consiteId"));
		int consiteState = Integer.parseInt(multipartRequest.getParameter("consiteState"));
		MultipartFile imgFile  =  multipartRequest.getFile("imgFile");
		try {
			rs = css.uploadConsitePic(imgFile, consiteId, consiteState,savePath);
		} catch (Exception e) {
			rs.setMsg(e.getMessage());
		}
		return rs;
	}
	
	/**
	 * 获取所有图片
	 * @param consiteId
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,value="/getallconsitepices/{consiteid}")
	@ResponseBody
	public ResultInfo getConsitePices(@PathVariable("consiteid")int consiteId,@Value("#{config['imgServerUrl']}")String imgServerPath){
		ResultInfo rs = new ResultInfo(false);
		try {
			rs = css.getAllConsitePices(consiteId);
		} catch (Exception e) {
			rs.setMsg(e.getMessage());
		}
		return rs;
	}
	
	/**
	 * 删除 
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,value="/deleteconsitepicbyid/{picid}")
	@ResponseBody
	public ResultInfo deleteConsitePic(@PathVariable("picid")int picId){
		ResultInfo rs = new ResultInfo(false);
		try {
			rs = css.deleteConsitePic(picId);
		} catch (Exception e) {
			rs.setMsg(e.getMessage());
		}
        return rs;		
	}
	
	/**
	 * 修改工地状态
	 * @param consiteid
	 * @param state
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,value="/modifyconsitestate/{consiteid}/{state}")
	@ResponseBody
	public ResultInfo modifyConsiteState(@PathVariable("consiteid")int consiteid,@PathVariable("state")int state){
		ResultInfo rs = new ResultInfo(false);
		try {
			rs = css.modifyConsiteState(consiteid,state);
		} catch (Exception e) {
			rs.setMsg(e.getMessage());
		}
        return rs;
	}
}
