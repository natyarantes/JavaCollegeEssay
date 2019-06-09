package bd;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnect {
	
	Connection dbConn;
	
	public boolean openConn() {
		String url = "jdbc:mysql//localhost/sisdiario?user=root&password=root1234";
		
		try {
			Class.forName("com.mysql.jdcb.Driver");
			dbConn = DriverManager.getConnection(url);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean closeConn() {
		
		try {
			dbConn.close();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Connection getConn() {
		return dbConn;
	}

}
