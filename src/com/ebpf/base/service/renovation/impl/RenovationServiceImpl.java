/**
 * 
 */
package com.ebpf.base.service.renovation.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ebpf.base.model.renovation.Apartment;
import com.ebpf.base.model.sys.DAORowMapper;
import com.ebpf.base.model.sys.ResultInfo;
import com.ebpf.base.service.renovation.RenovationService;

/**
 * @author 
 *
 */
@Component
public class RenovationServiceImpl implements RenovationService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public ResultInfo getApartmentbyCommunityId(int communityid) throws Exception {
		ResultInfo result=new ResultInfo(false);
		String sql="select id,title,community_id,roomcount,roomarea,description,icon  from t_renovation_apartment where community_id= ? ";
		List<Apartment> list = jdbcTemplate.query(sql, new Object[]{communityid},new DAORowMapper<Apartment>(Apartment.class));
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("apartments", list);
		result.setData(map);
		result.setMsg("查询户型列表成功");
		result.setResult(true);
		return result;
	}


	public ResultInfo getApartmentdesign(int apartmentid) throws Exception {
		return null;
	}


	public ResultInfo getApartmentdesigndiscuss(int apartmentdesignid) throws Exception {
		return null;
	}

	
	public ResultInfo getApartmentdesignpic(int apartmentdesignid) throws Exception {
		return null;
	}

	
	public ResultInfo getApartmentdiscuss(int apartmentid) throws Exception {
		return null;
	}

}
