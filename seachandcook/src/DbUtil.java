import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {
//	Database connection varaibles
	

	
	private static Statement statm;
	private static ResultSet rs;
	private static volatile Connection con = null;

	
	public static Connection getDbConnection() {
		 try {	 			
				 //con = DriverManager.getConnection(dbPath + dbName, user, pass);
				 statm = con.createStatement();

		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return con;
		
	}
	
	public void getTable() throws SQLException {
		rs = statm.executeQuery("SELECT * FROM ingredients");
		
		while (rs.next()) {
			System.out.println(rs.getString("ingredient"));
		}
	}
}
