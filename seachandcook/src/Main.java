import java.awt.EventQueue;
import java.sql.SQLException;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					seachandcookGUI frame = new seachandcookGUI();
					frame.setVisible(true);
					DbUtil.getDbConnection();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
