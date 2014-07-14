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
	 * get consite msges
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
	 * upload consite pic
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
	 * get All pices
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
	 * delete 
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
}
