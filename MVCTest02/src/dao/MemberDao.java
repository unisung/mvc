package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDao {
	public int userCheck(String id,String password) throws Exception {
		int result =-1;
	//DB 조회
		 Context init = new InitialContext();
		 DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		 Connection conn = ds.getConnection();
		 String sql = "select password from member where id=?";
		 PreparedStatement pstmt = conn.prepareStatement(sql);
		 pstmt.setString(1, id);
		 ResultSet rs = pstmt.executeQuery();

		 if(rs.next()) {
			 if(password.equals(rs.getString(1))) {
				 result=1;
			 }else {
				 result=0;
			 }
		 }else {
			 result =-1;
		 }
			return result;
		}

}
