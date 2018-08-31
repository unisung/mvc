package com.bbs.model;

import java.util.List;

public interface BbsService {
	//글 추가
	public int insertBbs(BbsBean bbs)throws Exception;
	//건수
	int getListCount()throws Exception;
	//리스트
	List<BbsBean> getBbsList(int page,int limit)throws Exception;
	//조회수 증가
	void bbsHit(int num) throws Exception;
	//글정보
	BbsBean getCont(int num) throws Exception;
	//수정
	int bbsEdit(BbsBean bbs) throws Exception;
	//삭제
	int bbsDelete(int num) throws Exception;
	//답글
	void bbsReply(BbsBean bbs) throws Exception;
	
	//새글 번호 생성
	int getBbsNo() throws Exception;

}
