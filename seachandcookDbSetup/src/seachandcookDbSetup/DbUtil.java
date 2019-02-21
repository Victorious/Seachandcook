package seachandcookDbSetup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {

	private static volatile Connection con = null;

	
	public static Connection getDbConnection() {
	
		 try {	 			
				   con = DriverManager.getConnection(DbInfo.dbPath + DbInfo.dbName, DbInfo.user, DbInfo.pass);
			 				 

		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return con;
		
	}
}
