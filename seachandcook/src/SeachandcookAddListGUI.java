import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class SeachandcookAddListGUI extends JFrame{
	private JTextField textFieldListName;
	
	public SeachandcookAddListGUI() {
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
			System.out.println("list added");
			setVisible(false);
		});
	}
}
