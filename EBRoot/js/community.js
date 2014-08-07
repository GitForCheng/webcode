$(function(){
	Com = {
	    init:function(){
		    Com.initGrid();
	       	Com.bindUI();
	    },
	    
	    bindUI:function(){
	    	 $('#dd').dialog({
			    title:'新增小区',
				buttons:[{
					text:'保存',
					iconCls:'icon-save',
					handler:function(){
						Com.saveCommunity();
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
	    
	    /**
	     * 保存小区
	     */
	    saveCommunity:function(){
	    	$.ajax({
			   type: "POST",
			   url: "savecommunity/"+$('#communityName').val()+"/"+$('#zoneId').val(),
			   success: function(result){
			     if(result.result){
			    	$('#dd').dialog('close'); 
			    	Com.initGrid();
			     }
			   }
			});
	    },
	    
	    /**
	     * 初始化表格
	     */
	    initGrid:function(){
	    	$('#uGrid').datagrid({
				fit:true,
				fitColumns:true,
				nowrap: true,
				autoRowHeight: true,
				striped: true,
				collapsible:true,
				url:'getallcommunity.json',
				sortName: 'code',
				sortOrder: 'desc',
				remoteSort: false,
				idField:'id',
				singleSelect:true,
				toolbar:[{
					text:'增加小区',
					iconCls:'icon-add',
					handler:function(){
					   $('#dd').dialog('open');
					}}
				],
				columns:[[
					{field:'icon',title:'图标',width:120,align:'center',formatter:function(val,row){
						return '<img src="http://pic11.nipic.com/20101212/5334112_093611036774_2.jpg" style="height:50px;width:50px"/>';
					}},
					{field:'name',title:'小区名称',width:120,align:'center'},
					{field:'zoneName',title:'区域名称',width:100,align:'center'},
					{field:'aCounts',title:'户型数',width:100,align:'center'},
					{field:'designCounts',title:'可搭配空间',width:100,align:'center'},
				]],
				pagination:true,
				rownumbers:true				
			});
	    }
	}
	
	Com.init();
})