package com.ebpf.base.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ebpf.base.model.User;
import com.ebpf.base.model.sys.ResultInfo;
import com.ebpf.base.service.user.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService us;
	
	@RequestMapping("user")
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("user/user");
		return mv;
	}
	
	@RequestMapping("getalluser")
	@ResponseBody
	public List<User> getAllUsers(){
		List<User> users = us.getAllUsers();
		return users;
	}
	
	@RequestMapping("saveuser/{userName}/{roleId}")
	@ResponseBody
	public ResultInfo saveUser(@PathVariable(value="userName")String userName,@PathVariable(value="roleId")int roleId){
		ResultInfo rs = new ResultInfo(false);
		rs = us.saveUser(userName, roleId);
		return rs;
	}
}
