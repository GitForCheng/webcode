package com.ebpf.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ebpf.base.model.User;
import com.ebpf.base.model.sys.DAORowMapper;
import com.ebpf.base.service.UserService;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public User login(String name, String psd) throws Exception{
		String sql = "select * from t_Sys_User where name = ? and psd = ?";
	    List<User> user = this.jdbcTemplate.query(sql,new String[]{name,psd},new DAORowMapper<User>(User.class));
		if(user.size()==1){
			return user.get(0);
		}else{
			return null;
		}
	}
}
