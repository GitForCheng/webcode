package com.ebpf.base.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ebpf.base.model.User;
import com.ebpf.base.model.sys.ResultInfo;
import com.ebpf.base.service.UserService;

@Controller
public class SysController {
	@Autowired
	private UserService userService;

	/**
	 * 登录
	 * @param userName
	 * @param psd
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,value="login/{username}/{psd}")
	@ResponseBody
	public ResultInfo login(@PathVariable("username") String userName,@PathVariable("psd") String psd) {
		ResultInfo resultInfo = new ResultInfo(false);
		try {
			resultInfo.setResult(true);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("roleId", ((User)userService.login(userName, psd)).getRoleId());
			map.put("userId", ((User)userService.login(userName, psd)).getId());
			map.put("userName", ((User)userService.login(userName, psd)).getName());
			map.put("roleName", ((User)userService.login(userName, psd)).getRoleName());
			resultInfo.setData(map);
			resultInfo.setMsg("login success");
		} catch (Exception e) {
			resultInfo.setMsg(e.getMessage());
		}
		return resultInfo;
	}
	
	
}
