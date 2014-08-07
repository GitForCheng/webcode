package com.ebpf.base.service.user;

import java.util.List;

import com.ebpf.base.model.User;
import com.ebpf.base.model.consite.Community;
import com.ebpf.base.model.consite.Zone;
import com.ebpf.base.model.sys.ResultInfo;


public interface UserService {
	/**
	 * 登录
	 * @param name
	 * @param psd
	 * @return
	 */
    public User login(String name,String psd) throws Exception;   
    
    /**
     * 获取所有用户
     * @return
     */
    public List<User> getAllUsers();
    
    /**
     * 保存用户
     * @param userName
     * @param roleId
     * @return
     */
    public ResultInfo saveUser(String userName,int roleId);
    
    /**
     * 获取所有社区
     * @return
     */
    public List<Community> getAllCommunity();
    
    /**
     * 
     * @return
     */
    public List<Zone> getAllZone();
}
