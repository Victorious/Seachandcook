import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class SeachandcookAddListGUI extends JFrame{
	private JTextField textFieldListName;
	Statement statm;
	Connection con;
	public SeachandcookAddListGUI() throws SQLException {
		con = DbUtil.getDbConnection();
		statm = con.createStatement();
		
		getContentPane().setLayout(null);
		setTitle("Add new list");
		setBounds(100, 100, 400, 240);
		JPanel panel = new JPanel();
		panel.setBounds(440, 240, 10, 10);
		getContentPane().add(panel);
		panel.setLayout(null);
				

						
		textFieldListName = new JTextField();
		textFieldListName.setBounds(120, 69, 146, 26);
		getContentPane().add(textFieldListName);
		textFieldListName.setColumns(10);
						
		JLabel lblListName = new JLabel("List name:");
		lblListName.setBounds(37, 72, 74, 20);
		getContentPane().add(lblListName);
				
		JLabel lblAddNewShopping = new JLabel("Add new Shoppinglist");
		lblAddNewShopping.setBounds(120, 16, 155, 20);
		getContentPane().add(lblAddNewShopping);
					
		JButton btnAddList = new JButton("Add list");
		btnAddList.setBounds(120, 122, 87, 29);
		getContentPane().add(btnAddList);
		btnAddList.addActionListener(e -> {
			try {
				InsertList();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			setVisible(false);
		});
	}
	
	public void InsertList() throws SQLException {
		String insertList = "INSERT INTO shopping_list (title) VALUES ('" + textFieldListName.getText() + "')";
		statm.executeUpdate(insertList);
	}

}
