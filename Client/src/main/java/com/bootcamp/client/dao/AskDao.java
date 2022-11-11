package com.bootcamp.client.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class AskDao {
	
	DataSource dataSource;
	
	public AskDao() {
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}//constructor
	
	

}
