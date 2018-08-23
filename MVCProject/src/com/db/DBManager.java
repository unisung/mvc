package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager{
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	protected Connection conn;
	protected String sql;
    
    protected Connection getConnection() {
    	try {
    	 Context init = new InitialContext();
    	 DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/xe");
    	 conn=ds.getConnection();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return conn;
    }
    //Statement(부모) <- PrepareStament(자식)
	public void close(Connection conn, Statement stmt, ResultSet rs) 
			                                throws Exception {
		try {
			  rs.close();
			  stmt.close();
			  conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close(Connection conn, Statement stmt) throws Exception {
		try {
			stmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
