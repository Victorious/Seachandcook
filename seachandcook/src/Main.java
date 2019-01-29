import java.awt.EventQueue;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					seachandcookGUI frame = new seachandcookGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
