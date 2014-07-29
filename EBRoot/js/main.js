$(function(){
	Main = {
	
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
						alert('ok');
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
			Main.addTab();  
		  });	
		},
		
		addTab:function(){
		  $('#dd').dialog('open');	
		},
		
		/**
		 * 
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
				url:'',
				sortName: 'code',
				sortOrder: 'desc',
				remoteSort: false,
				idField:'code',
				frozenColumns:[[
	                {field:'ck',checkbox:true},
	                {title:'工地名称',field:'code',width:80,sortable:true}
				]],
				columns:[[
					{field:'地址',title:'Name',width:120},
					{field:'addr',title:'Address',width:220,rowspan:2,sortable:true,
						sorter:function(a,b){
							return (a>b?1:-1);
						}
					},
					{field:'col4',title:'Col41',width:150,rowspan:2}
				]],
				pagination:true,
				rownumbers:true				
			});
		}
	}
	
	Main.init();
})