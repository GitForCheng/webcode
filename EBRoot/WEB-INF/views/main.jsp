<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>绿+后台管理系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>themes/icon.css">
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/main.js"></script>
  </head>
  
  <body class="easyui-layout"><%--
    <div data-options="region:'north',border:false" style="height:60px;padding:10px"></div>
	--%><div data-options="region:'west',split:true,title:'菜单',resizable:false" style="width:150px;padding:10px;">
	  <ul id="tt1" class="easyui-tree" data-options="animate:true,dnd:true">
		<li>
			<span>功能菜单</span>
			<ul>
				<li>
					<span><a onclick="addPanel('用户管理','user.htm')">用户管理</a></span>
				</li>
				<li>
					<span><a onclick="addPanel('工地管理','consite.htm')">工地管理</a></span>
				</li>
			</ul>
		</li>
	</ul>
	</div>
	<div data-options="region:'center'">
	  <div id="tt" class="easyui-tabs" data-options="fit:true,border:false,tools:'#tab-tools'" >
	  </div>
	</div>
	<div id="dd"  style="padding:5px;width:800px;height:400px;">
	   <table id="t123"  width="700px" >
	        <tr>
	          <td width="100px">地区:</td>
	          <td><select id="zone" style="width:230px"><option value="2">青岛</option></select></td>
	          <td width="100px">小区:</td>
	          <td><select id="consite" style="width:230px"></select></td>
	        </tr>
	        <tr>
	         <td width="100px">工地名称：</td>
	         <td> <input  style="width:230px"></input></td>
	         <td width="100px">工地状态:</td>
	         <td><select id="state" style="width:230px"><option value="0">请选择</option><option value="2">开工</option><option value="4">墙面</option><option value="8">家具</option><option value="16">完工</option></select></td>
	        </tr>
	        <tr><td width="100px">业主:</td>
	        <td><select id="owner" style="width:230px"><option value="0">请选择</option><option value="1">Test1</option></select></td>
	        <td width="100px">监理:</td>
	        <td><select id="supervision" style="width:230px"><option value="0">请选择</option><option value="2">Test2</option></select></select></td>
	        </tr>
	        <tr><td width="100px">装修队:</td><td><select id="decoteam" style="width:230px"><option value="0">请选择</option><option value="3">Test3</option></select></select></td></tr>
</table>	
	</div>
	
	<script type="text/javascript">
		function addPanel(name,url){
			if($('#tt').tabs('exists',name)){
				$('#tt').tabs('select', name);
			}else{
				$('#tt').tabs('add',{
					title: name,
					content: '<div style="padding:10px"><iframe src="'+url+'" scrolling="no" id="main" frameborder="0" width="100%" height="99%"></iframe></div>',
					closable: true
				})
			}
		}
		</script>
  </body>
</html>
