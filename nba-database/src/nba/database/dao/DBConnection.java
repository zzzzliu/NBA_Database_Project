package nba.database.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	static final String URL = "jdbc:mysql://localhost:3306/basketball?useSSL=false";
	static final String user = "root";
	static final String pass = "199468mysql";
	static final String driver = "com.mysql.jdbc.Driver";

	static Connection conn;
	
	static {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(URL, user, pass);
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}
}
