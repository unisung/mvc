package com.bbs.model;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BbsDao implements BbsService{
	private static SqlSession session;
	private static BbsDao instance;
	//mybatis 설정
	static {
		try {
			 Reader reader 
			       = Resources.getResourceAsReader("config/configuration.xml");
			 SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
			 session = sf.openSession(true);//autocommit - opensession(true)
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//singleton설정
	private BbsDao() {}
	public static BbsDao getInstance() {
		if(instance==null) instance=new BbsDao();
		return instance;
	}
	@Override
	public int insertBbs(BbsBean bbs) throws Exception {
		//기존에 글번호가 존재하는 확인 - 있으면 글번호 +1
		int num = getBbsNo();
		bbs.setBbs_num(num);
		
		//정상 입력 1, 실패면 0
		return session.insert("insertBbs", bbs);
	}
	
	
	@Override
	public int getListCount() throws Exception {
		return session.selectOne("selectlistCount");
	}
	@Override
	public List<BbsBean> getBbsList(int page, int limit) throws Exception {
		int startrow = (page-1)*limit+1;//해당 페이지의 시작번호
		int endrow = page*limit;//끝번호
		BbsBean bbs = new BbsBean();
		bbs.setPage(page);
		bbs.setLimit(limit);
		bbs.setStartrow(startrow);
		bbs.setEndrow(endrow);
		
		return session.selectList("selectList", bbs);
	}
	
	@Override
	public void bbsHit(int num) throws Exception {
		session.update("updateBbs", num);
	}
	@Override
	public BbsBean getCont(int num) throws Exception {
		return session.selectOne("selectBbsCont", num);
	}
	@Override
	public int bbsEdit(BbsBean bbs) throws Exception {
		return session.update("updateBbsCont", bbs);
	}
	@Override
	public int bbsDelete(int num) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void bbsReply(BbsBean bbs) throws Exception {
	 int num=0;
	 int re_ref=bbs.getBbs_re_ref();
	 int re_lev=bbs.getBbs_re_lev();
	 int re_seq=bbs.getBbs_re_seq();
	 
	num = getBbsNo();
	bbs.setBbs_num(num);
	
	 bbsRefUpdate(re_ref,re_seq);
	 
	 re_lev=re_lev+1;//답변글의 깊이
	 re_seq=re_seq+1;//답변글의 순서
	 
	 bbs.setBbs_re_lev(re_lev);
	 bbs.setBbs_re_seq(re_seq);
	 
	 session.insert("insertReply", bbs);
	 
	}
	
	@Override
	public int getBbsNo() throws Exception {
		return session.selectOne("selectMaxNo");
	}
	@Override
	public int bbsRefUpdate(int re_ref, int re_seq) throws Exception {
		BbsBean bbsBean = new BbsBean();
		bbsBean.setBbs_re_ref(re_ref);
		bbsBean.setBbs_re_seq(re_seq);
		
		return session.update("updateRef", bbsBean);
	}
	

}
