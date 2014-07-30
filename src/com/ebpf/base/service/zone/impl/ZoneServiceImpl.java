package com.ebpf.base.service.zone.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ebpf.base.model.consite.Community;
import com.ebpf.base.model.consite.Zone;
import com.ebpf.base.model.sys.DAORowMapper;
import com.ebpf.base.model.sys.ResultInfo;
import com.ebpf.base.service.zone.ZoneService;

@Component
public class ZoneServiceImpl implements ZoneService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Zone> getZone() {
		String sql = "select u.ID,u.name from t_Base_Zone u";
	    List<Zone> zone = this.jdbcTemplate.query(sql,new DAORowMapper<Zone>(Zone.class));
		if(zone.size()>0){
			return zone;
		}else{
			return null;
		}
	}
	
	@Override
	public List<Community> getAllCommunity() {
		String sql = "select c.ID,c.Name,z.Name zoneName,z.ID zone_Id from t_base_community c ,t_base_zone z WHERE c.ZONE_ID=z.ID";
		List<Community> ccs = this.jdbcTemplate.query(sql,new DAORowMapper<Community>(Community.class));
		if(ccs.size()>0){
			return ccs;
		}else{
			return null;
		}
	}
	@Override
	public ResultInfo saveCommunity(String communityName, int zoneId) {
		ResultInfo rs = new ResultInfo(false);
		String sql = "insert into t_base_community(name,zone_id)values(?,?)";
		if(this.jdbcTemplate.update(sql, new Object[]{communityName,zoneId})>0){
			rs.setResult(true);
			rs.setMsg("保存成功");
		}else{
			rs.setMsg("保存失败");
		}
		return rs;
	}

}
