package com.admin.model;

import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.gongji.model.GongjiBean;

public class AdminGongjiDao implements AdminGongjiService {
	private static AdminGongjiDao instance;
	private static SqlSession session;
	private AdminGongjiDao() {}

	// static 초기화
	static {
		try {
			// db연결 설정파일 읽기(dbconnect.properties)
			Reader reader = Resources.getResourceAsReader("config/configuration.xml");
			// SqlSessionFactory만들기
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			// session얻기
			session = sessionFactory.openSession(true);// 자동commit처리 openSession(true)
			// 자원해제
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static AdminGongjiDao getInstance() {
		if (instance == null)
			instance = new AdminGongjiDao();
		return instance;
	}

	PreparedStatement pstmt;
	ResultSet rs;
	Connection conn;
	String sql;
	
	@Override
	public int getListCount() throws Exception {
		return session.selectOne("selectListCount");
	}
	
	@Override
	public List<GongjiBean> getGongjiList(int page, int limit) throws Exception {
		int startrow = (page-1)*limit+1;//해당 페이지의 시작번호
		int endrow = page*limit;//끝번호
		AdminGongjiBean ab = new AdminGongjiBean();
		ab.setStartrow(startrow);
		ab.setEndrow(endrow);
		
		return session.selectList("selectGongjiList",ab);
	}
	@Override
	public GongjiBean getGongjiCont(int gongji_no) throws Exception {
		return session.selectOne("selectGongjiContent", gongji_no);
	}
	@Override
	public GongjiBean getCongji(int gongji_no) throws Exception {
		return session.selectOne("selectGongjiCont", gongji_no);
	}
	@Override
	public int updateMember(GongjiBean bean) throws Exception {
		return session.update("updateGongjiContent", bean);
	}
	@Override
	public void deleteGongji(int gongji_no) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int insertGongji(GongjiBean g) throws Exception {
		return session.insert("insertAdminGongji", g);
	}
	@Override
	public int getListCount3(String find_name, String find_field) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<GongjiBean> getGongjiSearch(int page, int limit, String find_name, String find_field) throws Exception {
		int startrow = (page-1)*limit+1;//해당 페이지의 시작번호
		int endrow = page*limit;//끝번호
		AdminGongjiBean ab = new AdminGongjiBean();
		ab.setStartrow(startrow);
		ab.setEndrow(endrow);
		ab.setFind_name("%"+find_name+"%");
		
		if(find_field.equals("gongji_title")){
			return session.selectList("selectFindListTitle", ab);
		}else if(find_field.equals("gongji_cont")) {
			return session.selectList("selectFindListCont", ab);
		}else {
			return session.selectList("selectFindListAll", ab);
		}
	}

}
