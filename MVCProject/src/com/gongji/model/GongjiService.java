package com.gongji.model;

import java.util.List;

public interface GongjiService {
	//전체 공지 건수
	public int getListCount() throws Exception;
	//전체 공지 리스트
	public List<GongjiBean> getGongjiList(int page, int limit) throws Exception;
	//공지 읽은 횟수 증가
	public void updateGongjigHit(int gongji_no) throws Exception;
	//공지 내용보기
	public GongjiBean getGongjiCont(int gongji_no) throws Exception;
	
}
