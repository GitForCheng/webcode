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
import com.ebpf.base.model.renovation.Apartmentdesign;
import com.ebpf.base.model.renovation.Apartmentdesigndiscuss;
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
		ResultInfo result=new ResultInfo(false);
		StringBuffer sql= new StringBuffer();
		sql.append("select m.id,m.title,m.apartment_Id,p.title apartment_Name,m.designer_Id,m.style_Id ,s.Name style_Name,g.name designer_Name");
		sql.append(" from t_renovation_apartmentdesign m,");
		sql.append("      t_base_designer g,");
		sql.append("      t_renovation_apartment p,");
		sql.append("      t_base_style s ");
		sql.append(" where m.designer_Id = g.id and m.apartment_Id = p.id and m.style_Id = s.id and m.apartment_Id= ? ");
		List<Apartmentdesign> list = jdbcTemplate.query(sql.toString(), new Object[]{apartmentid},new DAORowMapper<Apartmentdesign>(Apartmentdesign.class));
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("ad", list);
		result.setData(map);
		result.setMsg("查询户型设计列表成功");
		result.setResult(true);
		return result;
	}


	public ResultInfo getApartmentdesigndiscuss(int apartmentdesignid) throws Exception {
		ResultInfo result=new ResultInfo(false);
		StringBuffer sql= new StringBuffer();
		sql.append("select m.id,m.content,m.apartmentDesign_Id,g.title apartmentdesign_Name,m.insuser,u.name insuser_Name,m.instime");
		sql.append(" from t_renovation_apartmentdesigndiscuss m,");
		sql.append("      t_renovation_apartmentdesign g,");
		sql.append("      t_sys_user u");
		sql.append(" where m.apartmentDesign_Id = g.id and m.insuser = u.id and m.apartmentDesign_Id= ? ");
		List<Apartmentdesigndiscuss> list = jdbcTemplate.query(sql.toString(), new Object[]{apartmentdesignid},new DAORowMapper<Apartmentdesigndiscuss>(Apartmentdesigndiscuss.class));
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("adds", list);
		result.setData(map);
		result.setMsg("查询户型讨论内容成功");
		result.setResult(true);
		return result;
	}

	
	public ResultInfo getApartmentdesignpic(int apartmentdesignid) throws Exception {
		return null;
	}

	
	public ResultInfo getApartmentdiscuss(int apartmentid) throws Exception {
		return null;
	}

}
