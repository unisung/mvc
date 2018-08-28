package dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDao_dbcp {
	  private static SqlSession session;
	  
	  static {
		    try {
		    	Reader reader= Resources.getResourceAsReader("config/configuration.xml"); 
		    	SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
		    	session = sf.openSession(true);//자동 커밋 처리
		    	reader.close();
		    }catch(Exception e) {
		    	e.printStackTrace();
		    }
	  }
	
	public int userCheck(String id,String password) throws Exception {
		return password.equals(session.selectOne("selectPassword", id))?1:0;
		
		
	}		

}
