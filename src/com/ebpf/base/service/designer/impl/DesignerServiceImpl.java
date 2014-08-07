package com.ebpf.base.service.designer.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ebpf.base.model.renovation.Designer;
import com.ebpf.base.model.sys.DAORowMapper;
import com.ebpf.base.model.sys.ResultInfo;
import com.ebpf.base.service.designer.DesignerService;

@Component
public class DesignerServiceImpl implements DesignerService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public ResultInfo getAllDesigners() {
		ResultInfo result=new ResultInfo(false);
		try{
			String sql="select id,name,tel,MOBILE,CONTACTS,ADDRESS,COMPROFILE,icon  from t_base_designer ";
			List<Designer> list = jdbcTemplate.query(sql,new DAORowMapper<Designer>(Designer.class));
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("designers", list);
			result.setData(map);
			result.setMsg("查询设计公司列表成功");
			result.setResult(true);
		}catch(Exception e){
			result.setMsg("查询设计公司列表失败，异常信息为:"+e.getMessage());
		}
		
		return result;
	}

	@Override
	public ResultInfo getDesignersByName(String dName) {
		ResultInfo result=new ResultInfo(false);
		try{
			String sql="select id,name,tel,MOBILE,CONTACTS,ADDRESS,COMPROFILE,icon  from t_base_designer where name like '%"+dName+"%'";
			List<Designer> list = jdbcTemplate.query(sql,new DAORowMapper<Designer>(Designer.class));
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("designers", list);
			result.setData(map);
			result.setMsg("查询设计公司列表成功");
			result.setResult(true);
		}catch(Exception e){
			result.setMsg("查询设计公司列表失败，异常信息为:"+e.getMessage());
		}
		
		return result;
	}

}
