package com.admin.model;

import java.util.List;

import com.gongji.model.GongjiBean;

public interface AdminGongjiService{
	
 int getListCount() throws Exception;
 
 List<GongjiBean> getGongjiList(int page,int limit) throws Exception;
 
 GongjiBean getGongjiCont(int gongji_no) throws Exception;
 
 GongjiBean getCongji(int gongji_no) throws Exception;
 
 int updateMember(GongjiBean bean) throws Exception;
 
 void deleteGongji(int gongji_no) throws Exception;
 
 int insertGongji(GongjiBean g) throws Exception;
 
 int getListCount3(String find_name,String find_field) throws Exception;
 
 List<GongjiBean> getGongjiSearch(int page,int limit, 
		        String find_name, String find_field) throws Exception;
 
 
}
