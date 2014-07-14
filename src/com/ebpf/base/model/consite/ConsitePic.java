package com.ebpf.base.model.consite;

public class ConsitePic {
     private Integer id;
     private Integer consite_id;
     private Integer consite_state;
     private String picture_path;
     private String description;
     private Integer upload_user;    
     
     public Integer getId(){
    	 return id;
     }
     
     public void setId(Integer id){
    	 this.id=id;
     }
     
     public Integer getConsite_Id(){
    	 return consite_id;
     }
     
     public void setConsite_Id(Integer consite_id){
    	 this.consite_id=consite_id;
     }
     
     public Integer getConsite_State(){
    	 return consite_state;
     }
     
     public void setConsite_State(Integer consite_state){
    	 this.consite_state=consite_state;
     } 
     
     public String getPicture_path(){
    	 return picture_path;
     }
     
     public void setPicture_path(String picture_path){
    	 this.picture_path=picture_path;
     }
     
     public String getDescription(){
    	 return description;
     }
     
     public void setDescription(String description){
    	 this.description=description;
     }
     
     public Integer getUpload_user(){
    	 return upload_user;
     }
     
     public void setUpload_user(Integer upload_user){
    	 this.upload_user=upload_user;
     }
}
