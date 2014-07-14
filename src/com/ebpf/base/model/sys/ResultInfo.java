package com.ebpf.base.model.sys;

import java.util.HashMap;
import java.util.Map;

public class ResultInfo {
	private boolean result;
	private String msg;
	protected Map<String,Object> data = new HashMap<String,Object>();
	
	public ResultInfo(boolean result){
		this.result = result;
	}
	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
}
