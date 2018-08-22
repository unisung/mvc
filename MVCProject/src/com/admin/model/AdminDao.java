package com.admin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class AdminDao implements AdminService {
    private static AdminDao instance;
    private AdminDao() {}

	public static AdminDao getInstance() {
		if(instance==null) instance=new AdminDao();
		return instance;
	}
	PreparedStatement pstmt;
	ResultSet rs;
	Connection conn;
    String sql;
    
    private Connection getConnection() {
    	try {
    	 Context init = new InitialContext();
    	 DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/xe");
    	 conn=ds.getConnection();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return conn;
    }

	@Override
	public int adminCheck(String admin_id, String admin_pwd) throws Exception {
		int result=-1;
		try {
			sql = "select admin_pwd from admin where admin_id=?";
			pstmt = getConnection().prepareStatement(sql);
			pstmt.setString(1, admin_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(admin_pwd.equals(rs.getString(1))) {//id,비번 둘다 맞으면 1
					result=1;
				}else//비번이 틀리면 0
					result=0;
			}else
				result=-1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
