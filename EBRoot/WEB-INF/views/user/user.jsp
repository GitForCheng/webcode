<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()	+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>My JSP 'user.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css"	href="<%=basePath%>themes/default/easyui.css">
		<link rel="stylesheet" type="text/css"	href="<%=basePath%>themes/icon.css">
		<script type="text/javascript"	src="<%=basePath%>js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript"	src="<%=basePath%>js/jquery.easyui.min.js"></script>
		<script type="text/javascript"	src="<%=basePath%>js/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript"	src="<%=basePath%>js/user.js"></script>
	</head>
	<body>
	    <table id="uGrid"></table>
		<div id="dd"  style="padding:5px;width:400px;height:200px;">
		    <table cellpadding="5">
                <tr>
                    <td>用户名:</td>
                    <td><input class="easyui-validatebox textbox" type="text" id="name" data-options="required:true" style="width:260px;"></input></td>
                </tr>
                <tr>
                    <td>角色:</td>
                    <td>
                        <select class="easyui-combobox" id="roleId" style="width:260px;">
                          <option value="1">业主</option>
                          <option value="2">监理</option>
                          <option value="3">装修队</option>
                        </select>
                    </td>
                </tr>
            </table>
		</div>
	</body>
</html>
