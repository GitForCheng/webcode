package com.ebpf.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ebpf.base.model.User;
import com.ebpf.base.model.consite.Community;
import com.ebpf.base.model.consite.Zone;
import com.ebpf.base.model.sys.DAORowMapper;
import com.ebpf.base.model.sys.ResultInfo;
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

	@Override
	public List<User> getAllUsers() {
		String sql = "select u.ID,u.name,u.PSD,u.ROLEID,r.name as roleName from t_Sys_User u ,t_sys_role r where u.ROLEID = r.ID";
	    List<User> user = this.jdbcTemplate.query(sql,new DAORowMapper<User>(User.class));
		if(user.size()>0){
			return user;
		}else{
			return null;
		}
	}

	@Override
	public ResultInfo saveUser(String userName, int roleId) {
		ResultInfo rs = new ResultInfo(false);
		String sql = "insert into t_sys_user(name,psd,roleId)values(?,?,?)";
		if(this.jdbcTemplate.update(sql, new Object[]{userName,123,roleId})>0){
			rs.setResult(true);
			rs.setMsg("保存成功");
		}else{
			rs.setMsg("保存失败");
		}
		return rs;
	}

	@Override
	public List<Community> getAllCommunity() {
		String sql = "select id,name from t_base_community";
	    List<Community> community = this.jdbcTemplate.query(sql,new DAORowMapper<Community>(Community.class));
		if(community.size()>0){
			return community;
		}else{
			return null;
		}
	}

	@Override
	public List<Zone> getAllZone() {
		String sql = "select id,name from t_base_zone";
	    List<Zone> zones = this.jdbcTemplate.query(sql,new DAORowMapper<Zone>(Zone.class));
		if(zones.size()>0){
			return zones;
		}else{
			return null;
		}
	}
}
