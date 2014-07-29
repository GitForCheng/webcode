package com.ebpf.base.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.ebpf.base.model.consite.CommunityInfo;
import com.ebpf.base.model.sys.ResultInfo;
import com.ebpf.base.service.UserService;
import com.ebpf.base.service.consite.ConsiteService;

@Controller
public class ConsitController {

	@Autowired
	private ConsiteService css;
	@Autowired
	private UserService us;
    
	/**
	 * 索引页
	 * @return
	 */
    @RequestMapping("consite.htm")
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("consite/consite");
		mv.addObject("users", us.getAllUsers());
		mv.addObject("community", us.getAllCommunity());
		return mv;
	}
    
    /**
     * 获取所有工地
     * @return
     */
    @RequestMapping(value="/getallconsite")
	@ResponseBody
    public List<CommunityInfo> getAllconsite(){
    	List<CommunityInfo> ci = css.getallconsiteInfo();
    	return ci;
    }
    
    /**
     * 保存新工地
     * @return
     */
    @RequestMapping(value="/saveconsite/{consiteName}/{communityId}/{state}/{yezhu}/{jianli}/{zhuangxiudui}")
	@ResponseBody
    public ResultInfo saveNewConsite(@PathVariable("consiteName")String consiteName,
    		@PathVariable("communityId")int communityId,
    		@PathVariable("state")int state,
    		@PathVariable("yezhu")int yezhu,
    		@PathVariable("jianli")int jianli,
    		@PathVariable("zhuangxiudui")int zhuangxiudui){
    	ResultInfo rs = new ResultInfo(false);
    	rs = css.saveNewConsite(consiteName, communityId, state, yezhu, jianli, zhuangxiudui);
    	return rs;
    }
    
	/**
	 * 获取工地信息
	 * @param userId
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,value="/getusersconsite/{userid}")
	@ResponseBody
	public ResultInfo getUserCommunities(@PathVariable("userid")int userId){
		ResultInfo rs = new ResultInfo(false);
		try {
			 rs = css.getCommunitysByUser(userId);
		} catch (Exception e) {
			 rs.setMsg(e.getMessage());
		}
		
		return rs;
	}
	
	
	/**
	 * 上传工地图片最新
	 * @param request
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST,value="/uploadconsitepic1")
	@ResponseBody
	public ResultInfo uploadPicnew(HttpServletRequest request,@Value("#{config['consitePicSavePath']}")String savePath){
		ResultInfo rs = new ResultInfo(false);
		/*int consiteId = Integer.parseInt(request.getParameter("consiteId"));
		int consiteState = Integer.parseInt(request.getParameter("consiteState"));
		 try {
			 request.setCharacterEncoding("UTF-8");
			 DiskFileItemFactory factory = new DiskFileItemFactory();
			 ServletFileUpload upload = new ServletFileUpload(factory);
			 List items = upload.parseRequest(request);
			 Iterator itr = items.iterator();
			 while (itr.hasNext()) {
			  FileItem item = (FileItem) itr.next();
			  if (item.isFormField()) {
				     System.out.println("表单参数名:" + item.getFieldName() + "，表单参数值:" + item.getString("UTF-8"));
			  }else {
				  if (item.getName() != null && !item.getName().equals("")) {
				      System.out.println("上传文件的大小:" + item.getSize());
				      System.out.println("上传文件的类型:" + item.getContentType());
				      // item.getName()返回上传文件在客户端的完整路径名称
				      System.out.println("上传文件的名称:" + item.getName());
				      File tempFile = new File(item.getName());
				      File file = new File(savePath, tempFile.getName());
				      item.write(file);
				     }
			  }
			 }
			 rs.setResult(true);
		} catch (Exception e) {
			e.printStackTrace();
			rs.setMsg(e.getMessage());
		}
		*/
		/*try {
			rs = css.uploadConsitePic(imgFile, consiteId, consiteState,savePath);
		} catch (Exception e) {
			rs.setMsg(e.getMessage());
		}*/
		return rs;
	}
	/**
	 * 上传工地图片
	 * @param request
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST,value="/uploadconsitepic")
	@ResponseBody
	public ResultInfo uploadPic(HttpServletRequest request,@Value("#{config['consitePicSavePath']}")String savePath){
		ResultInfo rs = new ResultInfo(false);
		MultipartHttpServletRequest multipartRequest  =  (MultipartHttpServletRequest) request;  
		int consiteId = Integer.parseInt(multipartRequest.getParameter("consiteId"));
		int consiteState = Integer.parseInt(multipartRequest.getParameter("consiteState"));
		MultipartFile imgFile  =  multipartRequest.getFile("imgFile");
		try {
			rs = css.uploadConsitePic(imgFile, consiteId, consiteState,savePath);
		} catch (Exception e) {
			rs.setMsg("上传图片异常，异常信息为："+e.getMessage());
		}
		return rs;
	}
	
	/**
	 * 获取所有图片
	 * @param consiteId
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,value="/getallconsitepices/{consiteid}")
	@ResponseBody
	public ResultInfo getConsitePices(@PathVariable("consiteid")int consiteId,@Value("#{config['imgServerUrl']}")String imgServerPath){
		ResultInfo rs = new ResultInfo(false);
		try {
			rs = css.getAllConsitePices(consiteId);
		} catch (Exception e) {
			rs.setMsg(e.getMessage());
		}
		return rs;
	}
	
	/**
	 * 删除 
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,value="/deleteconsitepicbyid/{picid}")
	@ResponseBody
	public ResultInfo deleteConsitePic(@PathVariable("picid")int picId){
		ResultInfo rs = new ResultInfo(false);
		try {
			rs = css.deleteConsitePic(picId);
		} catch (Exception e) {
			rs.setMsg(e.getMessage());
		}
        return rs;		
	}
	
	/**
	 * 修改工地状态
	 * @param consiteid
	 * @param state
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,value="/modifyconsitestate/{consiteid}/{state}")
	@ResponseBody
	public ResultInfo modifyConsiteState(@PathVariable("consiteid")int consiteid,@PathVariable("state")int state){
		ResultInfo rs = new ResultInfo(false);
		try {
			rs = css.modifyConsiteState(consiteid,state);
		} catch (Exception e) {
			rs.setMsg(e.getMessage());
		}
        return rs;
	}
}
