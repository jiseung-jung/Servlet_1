package com.jiseung.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
	
	public Connection getConnect() throws Exception {
		
		// 1. DB 연결 정보
		String user = "hr";
		String password = "tiger";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		//2. driver를 메모리에 로딩
		Class.forName(driver);
		System.out.println("=====Driver Loading Complete=====");
		
		//3. DB 로그인 Connection 객체 반환
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		return con;
	}

}
