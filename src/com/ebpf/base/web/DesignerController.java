package com.ebpf.base.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ebpf.base.model.sys.ResultInfo;
import com.ebpf.base.service.designer.DesignerService;

/**
 * 设计公司Controller
 * @author cheng
 *
 */
@Controller
public class DesignerController {

	 @Autowired
	 private DesignerService ds;
	 
	 /**
	  * 查询所有设计公司
	  * @return
	  */
	 @RequestMapping("getdesingers")
	 @ResponseBody
	 public ResultInfo getAllDesigners(){
		 ResultInfo rs = new ResultInfo(false);
		 rs = ds.getAllDesigners();
		 return rs;
	 }
	 
	 /**
	  * 根据名字查询设计公司
	  * @return
	  */
	 @RequestMapping("getdesingerbyname/{dName}")
	 @ResponseBody
	 public ResultInfo getAllDesignerByName(@PathVariable(value="dName")String dName){
		 ResultInfo rs = new ResultInfo(false);
		 rs = ds.getDesignersByName(dName);
		 return rs;
	 }
}
