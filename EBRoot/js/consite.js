$(function(){
	Consite = {
	
		init:function(){
		  this.initConsite();
		  this.bindUI();
		},
		
		bindUI:function(){
		  $('#dd').dialog({
			    title:'新增工地',
				buttons:[{
					text:'保存',
					iconCls:'icon-save',
					handler:function(){
						Consite.saveNewConsite();
					}
				},{
					text:'取消',
					handler:function(){
						$('#dd').dialog('close');
					}
				}]
			});
          $('#dd').dialog('close');
		  $('#addBtn').bind('click',function(){
			Consite.addTab();  
		  });	
		},
		
		addTab:function(){
		  $('#dd').dialog('open');	
		},
		
		/**
		 * 保存工地
		 */
		saveNewConsite:function(){
			$.ajax({
			   type: "POST",
			   url: "saveconsite/"+$('#consiteName').val()+"/"+$('#community').val()+"/"+$('#state').val()+"/"+$("#owner").val()+"/"+$("#supervision").val()+"/"+$("#decoteam").val(),
			   success: function(result){
			     if(result.result){
			    	$('#dd').dialog('close'); 
			    	Consite.initConsite();
			     }
			   }
			});
		},
		
		/**
		 * 初始化工地列表
		 * @return {TypeName} 
		 */
		initConsite:function(){
			 $('#tt2').datagrid({
				fit:true,
				fitColumns:true,
				nowrap: true,
				autoRowHeight: false,
				striped: true,
				collapsible:true,
				url:'getallconsite.json',
				sortName: 'code',
				sortOrder: 'desc',
				remoteSort: false,
				singleSelect:true,
				idField:'id',
				frozenColumns:[[
	                {field:'id',checkbox:true}
				]],
				columns:[[
					{field:'name',title:'工地名称',width:150},
					{field:'communityName',title:'小区',width:150},
					{field:'ownerName',title:'业主',width:150},
					{field:'superVisionName',title:'监理',width:150},
					{field:'decoteamName',title:'装修队',width:150},
					{field:'statName',title:'状态',width:150},
					{field:'instime',title:'创建时间',width:150}
				]],
				pagination:true,
				rownumbers:true				
			});
		}
	}
	
	Consite.init();
})