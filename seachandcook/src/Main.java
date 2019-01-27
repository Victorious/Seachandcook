import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		DbUtil dbutil = new DbUtil();
		dbutil.getDbConnection();
		dbutil.getTable();
	}

}
