import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.media.sound.ModelAbstractChannelMixer;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JList;
import javax.swing.JFormattedTextField;
import javax.swing.JToggleButton;
import javax.swing.JPasswordField;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Label;
import java.awt.TextField;
import java.awt.List;
import java.awt.Point;

import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JScrollBar;
import java.awt.Scrollbar;

public class seachandcookGUI extends JFrame {

	private JPanel contentPane;
	
	Connection con = DbUtil.getDbConnection();
	Statement statm;
	ResultSet rs;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public seachandcookGUI() throws SQLException {
		setTitle("Seach and Cook!");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 523);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 353, 484);
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Label seachlabel = new Label("Enter product name :");
		seachlabel.setFont(new Font("Dialog", Font.BOLD, 11));
		seachlabel.setForeground(Color.WHITE);
		seachlabel.setBounds(10, 10, 123, 22);
		panel.add(seachlabel);
		
		TextField searchtextField = new TextField();
		searchtextField.setBounds(139, 10, 113, 22);
		panel.add(searchtextField);
		
		DefaultListModel leftModel = new DefaultListModel();
		
		JList leftList = new JList(leftModel);
		leftList.setBounds(48, 60, 242, 283);
		panel.add(leftList);
		
		// Mysql testing start
		statm = con.createStatement();
		rs = statm.executeQuery("SELECT * FROM ingredients");
		ArrayList<String> ingredientList = new ArrayList<String>();

		while (rs.next()) {
			String ingredient = rs.getString(3);
			ingredientList.add(ingredient);
		}
		for (String string : ingredientList) {
			System.out.println(string);
			leftModel.addElement(string);
		}
		
		// Mysql testing end
		
		Label productsLabel = new Label("Your shoppinglist");
		productsLabel.setBounds(472, 30, 124, 22);
		productsLabel.setForeground(Color.WHITE);
		productsLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(productsLabel);
		
		List rightList = new List();
		rightList.setBounds(412, 58, 219, 283);
		contentPane.add(rightList);
		
		Integer totalProduct = null;
		JLabel lblNewLabel = new JLabel("Total products : " + totalProduct);
		lblNewLabel.setBounds(412, 445, 113, 14);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel);
		
		Button deleteButton = new Button("Delete");
		deleteButton.setForeground(Color.WHITE);
		deleteButton.setBounds(412, 365, 80, 22);
		contentPane.add(deleteButton);
		deleteButton.setBackground(new Color(241, 57, 83));
		deleteButton.addActionListener((e) -> {
			//Testing deleting value from list
			rightList.remove(rightList.getSelectedIndex());
			//Test END
		});
		Button addButton = new Button("Add");
		addButton.setForeground(Color.WHITE);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 // Testing adding values in list START
				String selectedItem = leftList.getSelectedValue().toString();
				rightList.add(selectedItem);
			}
			//  Testing END
		});
		
		addButton.setBackground(new Color(241, 57, 83));
		addButton.setBounds(48, 366, 85, 22);
		panel.add(addButton);
		
		Button saveButton = new Button("Save");
		saveButton.setForeground(Color.WHITE);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		saveButton.setBackground(new Color(241, 57, 83));
		saveButton.setBounds(412, 405, 80, 22);
		contentPane.add(saveButton);
		
		Button searchButton = new Button("Search");
		searchButton.addActionListener((e) -> {
			// Search Testing Start
			String searchText = searchtextField.getText();
			
			for (String string : ingredientList) {
				if (string.equals(searchText)) {
					leftList.setSelectedValue(string, true);
				}
			}
			// Search Testing End
		});
		
		searchButton.setForeground(Color.WHITE);
		searchButton.setBackground(new Color(241, 57, 83));
		searchButton.setBounds(258, 10, 85, 22);
		panel.add(searchButton);
		

	}
}
