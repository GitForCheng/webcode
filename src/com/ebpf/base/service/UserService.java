package com.ebpf.base.service;

import com.ebpf.base.model.User;


public interface UserService {
	/**
	 * 登录
	 * @param name
	 * @param psd
	 * @return
	 */
    public User login(String name,String psd) throws Exception;    
}
