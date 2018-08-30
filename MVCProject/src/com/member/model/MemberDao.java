package com.member.model;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDao implements MemberService{
	private static MemberDao instance;
	//mybatis 설정
	private static SqlSession session;
	static {
		try {
		    Reader reader = Resources.getResourceAsReader("config/configuration.xml");
		    SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
		     session = sf.openSession(true);//openSession(true)이면 autocommit처리
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//싱글톤 처리
	private MemberDao() {}
	public static MemberDao getInstance() {
		if(instance==null) instance=new MemberDao();
		return instance;
	}
	
	@Override
	public int checkMemberId(String id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List searchZipcode(String dong) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public MemberBean findpwd(String pwd_id, String pwd_name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int userCheck(String id, String pass) throws Exception {
		int result=-1;
		MemberBean member = new MemberBean();
		member.setMember_id(id);
		if(((MemberBean)session.selectOne("selectUserInfo",member)).getMember_pass()==null)
			result =-1;
		else {
			result=
			pass.equals(((MemberBean)session.selectOne("selectUserInfo",member)).getMember_pass())?1:0;	
		}
		System.out.println("result="+result);
		return result;
	}
	@Override
	public MemberBean getMember(String id) throws Exception {
		MemberBean member = new MemberBean();
		member.setMember_id(id);
		return session.selectOne("selectUserInfo",member);
	}
	@Override
	public int updateMember(MemberBean bean) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int deleteMember(String id, String pass, String del_cont) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	

}
