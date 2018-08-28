package dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.MemberBean;

public class MemberDao {
	//db연결객체
	private static SqlSession session;
	private static MemberDao instance;
	private MemberDao() {}
	
	public static MemberDao getInstance() {
		if(instance==null) instance=new MemberDao();
		return instance;
	}

	static {
		try {
			  Reader reader = Resources.getResourceAsReader("config/configuration.xml");
			  SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
			  session = sf.openSession();
			  reader.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}//SqlSession  설정 끝.
	
    public int userCheck(String id,String password){
    	MemberBean member = new MemberBean();
    	member.setId(id);
    	member.setPassword(password);
    	
		//1=정상,0=실패
    	return  session.selectOne("selectPassword",member);
		
	}
    
}
