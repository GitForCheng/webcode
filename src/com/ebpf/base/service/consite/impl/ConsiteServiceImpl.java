package com.ebpf.base.service.consite.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.ebpf.base.model.consite.CommunityInfo;
import com.ebpf.base.model.consite.ConsitePic;
import com.ebpf.base.model.sys.DAORowMapper;
import com.ebpf.base.model.sys.ResultInfo;
import com.ebpf.base.service.consite.ConsiteService;
import com.ebpf.base.utils.ImageUtils;

@Component
public class ConsiteServiceImpl implements ConsiteService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public ResultInfo getCommunitysByUser(int userId) throws Exception {
		ResultInfo result = new ResultInfo(false);
		String sql = "select roleId from t_sys_user where id = ?";
		int roleId = jdbcTemplate.queryForInt(sql, userId);
		StringBuffer _sql = new StringBuffer();
		_sql.append("select m.id,m.name,m.state,case when m.state = 2 then '开工' when m.state = 4 then '墙面' when m.state = 8 then '家具' when m.state = 16 then '完工' end statName,m.community_id communityId,c.Name as CommunityName,m.Owner_Id as ownerId,m.SuperVision_ID as SuperVisionId,m.Decoteam_Id as DecoteamId,u1.Name as OwnerName,u2.Name as SuperVisionName,u3.name as DecoteamName,instime" ); 
		_sql.append(" from " );
	    _sql.append("  t_consite_info m," );
		_sql.append("  t_sys_user u1," );
        _sql.append("  t_sys_user u2," );
        _sql.append("  t_sys_user u3," );
        _sql.append("  t_base_community c" );
        _sql.append(" where m.OWNER_ID=u1.ID AND" );
        _sql.append("  m.SuperVision_ID=u2.ID AND" );
        _sql.append("  m.Decoteam_Id=u3.ID AND" );
        _sql.append("  m.COMMUNITY_ID=c.ID");
		if (roleId == 1)
			_sql.append(" and m.owner_Id = ?");
		if (roleId == 2)
			_sql.append(" and m.SuperVision_ID = ?");
		if (roleId == 3)
			_sql.append(" and m.Decoteam_Id = ?");
		List<CommunityInfo> cis = this.jdbcTemplate.query(_sql.toString(),new Object[] { userId }, new DAORowMapper<CommunityInfo>(CommunityInfo.class));
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("consites", cis);
		result.setResult(true);
		result.setData(map);
		return result;
	}

	public ResultInfo uploadConsitePic(MultipartFile file, int consiteId, int consiteState,String savePath,int uploaduser) throws Exception {
		ResultInfo rs = new ResultInfo(false);
		String tempName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date())+".jpg";
		String path = "error";
		Map<String,Object> map = new HashMap<String, Object>();
		if(ImageUtils.uploadFile(file, savePath+consiteId+"/",tempName)){
			path = consiteId+"/"+tempName;
			String sql = "insert into t_consite_pic(Consite_Id,Consite_State,Picture_Path,UPLOAD_USER) values(?,?,?,?)";
			if(this.jdbcTemplate.update(sql, consiteId,consiteState,path,uploaduser)>0){
				map.put("path", path);
				map.put("consiteId", consiteId);
				rs.setResult(true);
				rs.setData(map);
				rs.setMsg("上传图片成功");
			}
		}else{
			rs.setMsg("上传图片失败");
		}
		return rs;
	}

	@Override
	public ResultInfo getAllConsitePices(int consiteId) throws Exception {
		ResultInfo result = new ResultInfo(false);
		String sql = "select Consite_Id,Consite_State,Picture_Path,Description from t_consite_pic where Consite_Id = ?";
		List<ConsitePic> cps = this.jdbcTemplate.query(sql, new Object[]{consiteId},new DAORowMapper<ConsitePic>(ConsitePic.class));
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("consitePic", cps);
		result.setResult(true);
		result.setData(map);
		result.setMsg("获取工地[工地号:"+consiteId+"]图片列表成功");
		return result;
	}

	@Override
	public ResultInfo deleteConsitePic(int picId) throws Exception {
		ResultInfo rs = new ResultInfo(false);
		String sql = "delete from t_consite_pic where id = ?";
		if(this.jdbcTemplate.update(sql,new Object[]{picId})>0){
			rs.setResult(true);
			rs.setMsg("删除工地图片成功,图片ID["+picId+"]");
		}else{
			rs.setMsg("删除工地图片失败,图片ID["+picId+"]");
		}
		return rs;
	}

	@Override
	public ResultInfo modifyConsiteState(int consiteid, int state) throws Exception {
		ResultInfo rs = new ResultInfo(false);
		String sql = "update t_consite_info m set m.state = ? where m.id = ?";
		if(this.jdbcTemplate.update(sql,new Object[]{state,consiteid})>0){
			rs.setResult(true);
			rs.setMsg("修改工地状态成功,工地ID["+consiteid+"]");
		}else{
			rs.setMsg("修改工地状态失败,工地ID["+consiteid+"]");
		}
		return rs;
	}

	@Override
	public List<CommunityInfo> getallconsiteInfo() {
		StringBuffer _sql = new StringBuffer();
		_sql.append("select m.id,m.name,m.state,case when m.state = 2 then '开工' when m.state = 4 then '墙面' when m.state = 8 then '家具' when m.state = 16 then '完工' end statName,m.community_id communityId,c.Name as CommunityName,m.Owner_Id as ownerId,m.SuperVision_ID as SuperVisionId,m.Decoteam_Id as DecoteamId,u1.Name as OwnerName,u2.Name as SuperVisionName,u3.name as DecoteamName,instime" ); 
		_sql.append(" from " );
	    _sql.append("  t_consite_info m," );
		_sql.append("  t_sys_user u1," );
        _sql.append("  t_sys_user u2," );
        _sql.append("  t_sys_user u3," );
        _sql.append("  t_base_community c" );
        _sql.append(" where m.OWNER_ID=u1.ID AND" );
        _sql.append("  m.SuperVision_ID=u2.ID AND" );
        _sql.append("  m.Decoteam_Id=u3.ID AND" );
        _sql.append("  m.COMMUNITY_ID=c.ID");
		List<CommunityInfo> cis = this.jdbcTemplate.query(_sql.toString(), new DAORowMapper<CommunityInfo>(CommunityInfo.class));
		return cis;
	}

	@Override
	public ResultInfo saveNewConsite(String name, int communityId, int state,
			int yezhu, int jianli, int zhuangxiudui) {
		ResultInfo rs = new ResultInfo(false);
		String sql = "insert into t_consite_info(name,state,owner_Id,SUPERVISION_ID,DECOTEAM_ID,COMMUNITY_ID,INSTIME) values(?,?,?,?,?,?,?)";
		if(this.jdbcTemplate.update(sql, name,state,yezhu,jianli,zhuangxiudui,communityId,new Date())>0){
			rs.setResult(true);
			rs.setMsg("保存成功");
		}
		return rs;
	}

	@Override
	public ResultInfo getAllConsiteStatePices(int consiteId, int state)
			throws Exception {
		ResultInfo result = new ResultInfo(false);
		String sql = "select Consite_Id,Consite_State,Picture_Path,Description from t_consite_pic where Consite_Id = ? and CONSITE_STATE = ?";
		List<ConsitePic> cps = this.jdbcTemplate.query(sql, new Object[]{consiteId,state},new DAORowMapper<ConsitePic>(ConsitePic.class));
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("consitePic", cps);
		result.setResult(true);
		result.setData(map);
		result.setMsg("获取工地[工地号:"+consiteId+",状态:"+state+"]图片列表成功");
		return result;
	}
	
	
}
