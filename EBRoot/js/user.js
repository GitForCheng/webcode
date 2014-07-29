$(function(){
	User = {
		init:function(){
		  User.initGrid();
		  User.bindUI();
		},
		
		bindUI:function(){
		  $('#dd').dialog({
			    title:'新增用户',
				buttons:[{
					text:'保存',
					iconCls:'icon-save',
					handler:function(){
						User.saveNewUser();
					}
				},{
					text:'取消',
					handler:function(){
						$('#dd').dialog('close');
					}
				}]
		   });
         
		   $('#dd').dialog('close');
		 },
		
		 saveNewUser:function(){
			$.ajax({
			   type: "POST",
			   url: "saveuser/"+$('#name').val()+"/"+$('#roleId').combobox('getValue'),
			   success: function(result){
			     if(result.result){
			    	$('#dd').dialog('close'); 
			    	User.initGrid();
			     }
			   }
			});
		 },
		
		 initGrid:function(){
			 $('#uGrid').datagrid({
				fit:true,
				fitColumns:true,
				nowrap: true,
				autoRowHeight: false,
				striped: true,
				collapsible:true,
				url:'getalluser.json',
				sortName: 'code',
				sortOrder: 'desc',
				remoteSort: false,
				idField:'id',
				singleSelect:true,
				toolbar:[{
					text:'增加用户',
					iconCls:'icon-add',
					handler:function(){
					   $('#dd').dialog('open');
					}}
				],
				frozenColumns:[[
	                {field:'ck',title:'选择',checkbox:true}
				]],
				columns:[[
					{field:'name',title:'用户名',width:120},
					{field:'roleName',title:'角色',width:100}
				]],
				pagination:true,
				rownumbers:true				
			});
		  }
	}
	
	User.init();
})