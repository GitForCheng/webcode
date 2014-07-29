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
		<script type="text/javascript"	src="<%=basePath%>js/consite.js"></script>
	</head>
	<body>
		<div style="margin: 12px;">
	         <%--<input class="easyui-searchbox" data-options="prompt:'请输入工地名称';searcher:doSearch" style="width:150px"></input>
	         --%><a class="easyui-linkbutton" data-options="iconCls:'icon-add'" href="javascript:void(0)" id="addBtn">增加工地</a>
		</div>
		<div style="width: 100%;height: 92%">
			  <table id="tt2"></table>
		</div>
		<div id="dd"  style="padding:5px;width:800px;height:200px;">
			<table id="t123" width="100%" height="28">
			<tr>
				<td width="140px">
					工地名称：
				</td>
				<td>
					<input id="consiteName"	class="easyui-validatebox textbox" type="text" data-options="required:true" style="width:200px;"></input>
				</td>
				<td width="140px">
					小区:
				</td>
				<td>
					<select id="community"  style="width:200px;">
					  <c:forEach items="${community}" var="ss">
								<option value="${ss.id}">
									${ss.name }
								</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td width="140px">
					工地状态:
				</td>
				<td>
					<select id="state" style="width:200px;">
					   <option value="2">开工</option>
					   <option value="4">墙面</option>
					   <option value="8">家具</option>
					   <option value="16">完工</option>
					</select>
				</td>
				<td width="140px">
					业主:
				</td>
				<td>
					<select id="owner"  style="width:200px;">
						<c:forEach items="${users}" var="as">
							<c:if test="${as.roleId==1}">
								<option value="${as.id}">
									${as.name }
								</option>
							</c:if>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td width="140px">
					监理:
				</td>
				<td>
					<select id="supervision"  style="width:200px;">
					   <c:forEach items="${users}" var="s">
				         <c:if test="${s.roleId==2}">
				            <option value="${s.id}">${s.name }</option>
				         </c:if>
				       </c:forEach>
					</select>
				</td>
				<td width="140px">
					装修队:
				</td>
				<td>
					<select id="decoteam"  style="width:200px;">
					   <c:forEach items="${users}" var="s">
				         <c:if test="${s.roleId==3}">
				            <option value="${s.id}">${s.name }</option>
				         </c:if>
				       </c:forEach>
					</select>
				</td>
			</tr>
		</table>
	  </div>
	</body>
</html>
