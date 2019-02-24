import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class seachandcookGUI extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTable leftTable;
	private JTable rightTable;
	Label productsLabel;
	JMenuItem menuItemNew = null;
	JMenu menuSelectList = null;
	Integer currentListId = null;
	ResultSet rs;
	Connection con;
	Statement statm;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
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
	

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public seachandcookGUI() throws SQLException {
		 
		
		setTitle("Seach and Cook!");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 600);
		setLocationRelativeTo(null);
		
		// Getting database connection
		con = DbUtil.getDbConnection();
		statm = con.createStatement();
		

		// Adding top menubar
		JMenuBar topMenuBar = new JMenuBar();
		setJMenuBar(topMenuBar);
		
		// Creating menubar items and adding actionlistners
		JMenu menuHelp = new JMenu("Help");
		topMenuBar.add(menuHelp);
		
		JMenuItem menuItemHelpSorting = new JMenuItem("Sorting list");
		menuHelp.add(menuItemHelpSorting);
		menuItemHelpSorting.addActionListener(e -> {
			JOptionPane.showMessageDialog(this, "Double click the title of the column you want to sort", "Sort the shoppinglist", JOptionPane.CLOSED_OPTION);
		});
		JMenuItem menuItemHelpAddList = new JMenuItem("Adding new list");
		menuHelp.add(menuItemHelpAddList);
		menuItemHelpAddList.addActionListener(e -> {
			JOptionPane.showMessageDialog(this, "Press Shoppinglist menu and then 'Add Shoppinlist'. Type now your new list name and press add", "Add list", JOptionPane.CLOSED_OPTION);
		});
		JMenuItem MenuItemHelpSelectList = new JMenuItem("Selecting existing list");
		menuHelp.add(MenuItemHelpSelectList);
		MenuItemHelpSelectList.addActionListener(e -> {
			JOptionPane.showMessageDialog(this, "Press Shoppinglist menu and then 'Select Shoppinglist'. Select your Shoppinglist", "Select list", JOptionPane.CLOSED_OPTION);
		});
		
		JMenu menuShoppinglist = new JMenu("Shoppinglist");
		topMenuBar.add(menuShoppinglist);
		menuSelectList = new JMenu("Select Shoppinglist");
		menuShoppinglist.add(menuSelectList);

		String selectLists = "SELECT * FROM shopping_list";
		rs = statm.executeQuery(selectLists);
		while (rs.next()) {
			
			menuItemNew = new JMenuItem(rs.getString("title"));
			menuSelectList.add(menuItemNew);
			menuItemNew.addActionListener(this);
		}
		
		JMenuItem menuItemAddList = new JMenuItem("Add Shoppinglist");
		menuShoppinglist.add(menuItemAddList);
		menuItemAddList.addActionListener(e -> {
			try {
				SeachandcookAddListGUI addListGui = new SeachandcookAddListGUI();
				addListGui.setVisible(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 390, 532);
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		TextField searchtextField = new TextField();
		searchtextField.setBounds(176, 125, 113, 22);
		panel.add(searchtextField);

		Button searchButton = new Button("Search");
		searchButton.addActionListener(e -> {

			
				String getSql = "select * from ingredients where ingredient='"+searchtextField.getText()+"'"; 
				try {
					rs = statm.executeQuery(getSql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				((DefaultTableModel)leftTable.getModel()).setNumRows(0);
				try {
					while (rs.next()) {			
						int numcols = leftTable.getModel().getColumnCount();
						Object [] fill = new Object[numcols];
						String product_item = rs.getString(3);
						fill[0] = product_item;
						((DefaultTableModel)leftTable.getModel()).addRow(fill);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
		});
		searchButton.setForeground(Color.WHITE);
		searchButton.setBackground(new Color(241, 57, 83));
		searchButton.setBounds(295, 125, 85, 22);
		panel.add(searchButton);
		
		Button searchButton2 = new Button("See all products");
		searchButton2.addActionListener(e -> {

			searchtextField.setText("");
			
				String getSql = "select * from ingredients"; 
				try {
					rs = statm.executeQuery(getSql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				((DefaultTableModel)leftTable.getModel()).setNumRows(0);
				try {
					while (rs.next()) {			
						int numcols = leftTable.getModel().getColumnCount();
						Object [] fill = new Object[numcols];
						String product_item = rs.getString(3);
						fill[0] = product_item;
						((DefaultTableModel)leftTable.getModel()).addRow(fill);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
		});
		searchButton2.setForeground(Color.WHITE);
		searchButton2.setBackground(new Color(241, 57, 83));
		searchButton2.setBounds(290, 150, 95, 22);
		panel.add(searchButton2);

		Label seachlabel = new Label("Enter product name :");
		seachlabel.setBackground(new Color(255, 255, 255));
		seachlabel.setFont(new Font("Dialog", Font.BOLD, 12));
		seachlabel.setForeground(new Color(0, 0, 0));
		seachlabel.setBounds(47, 125, 123, 22);
		panel.add(seachlabel);

		Button addButton = new Button("Add");
		addButton.setForeground(Color.WHITE);
		addButton.addActionListener(e -> {
			try {
				addProductToShoppingList();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		addButton.setBackground(new Color(241, 57, 83));
		addButton.setBounds(295, 465, 85, 22);
		panel.add(addButton);
		
		JScrollPane scrollPaneLeft = new JScrollPane();
		scrollPaneLeft.setToolTipText("");
		scrollPaneLeft.setBounds(47, 156, 241, 331);
		panel.add(scrollPaneLeft);
		

		leftTable = new JTable();
		leftTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Items"
			}
		));
		leftTable.setBackground(new Color(255, 255, 255));
		leftTable.setForeground(new Color(0, 0, 0));
		scrollPaneLeft.setViewportView(leftTable);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(seachandcookGUI.class.getResource("/Shoop.jpg")));
		lblNewLabel_1.setBounds(176, 14, 149, 105);
		panel.add(lblNewLabel_1);
		


		productsLabel = new Label("Your shoppinglist: ");
		productsLabel.setBounds(514, 87, 284, 45);
		productsLabel.setForeground(Color.WHITE);
		productsLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		contentPane.add(productsLabel);

		JLabel lblNewLabel = new JLabel("Total products: ");
		lblNewLabel.setBounds(659, 494, 113, 14);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel);

		Button deleteButton = new Button("Delete");
		deleteButton.setForeground(Color.WHITE);
		deleteButton.setBounds(412, 226, 80, 22);
		contentPane.add(deleteButton);
		deleteButton.setBackground(new Color(241, 57, 83));
		deleteButton.addActionListener(e -> {
			try {
				removeProduct();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		Button saveButton = new Button("Save");
		saveButton.setForeground(Color.WHITE);
		saveButton.addActionListener(e -> {
			
		});
		saveButton.setBackground(new Color(241, 57, 83));
		saveButton.setBounds(412, 264, 80, 22);
		contentPane.add(saveButton);
		
		JScrollPane scrollPaneRight = new JScrollPane();
		scrollPaneRight.setBounds(514, 149, 258, 332);
		contentPane.add(scrollPaneRight);
		
		//RIGHT TABLE WITH COLUMNS
		rightTable = new JTable();
		rightTable.setAutoCreateRowSorter(true);
		rightTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Item", "Amount", "Price"
			}
		));
		scrollPaneRight.setViewportView(rightTable);
		
		getProducts();
	}
	
	@SuppressWarnings("unchecked")
	public void removeProduct() throws SQLException {
		if (rightTable.getSelectedRow() < 0) {
			JOptionPane.showMessageDialog(this, "No item has been selected.", "Shoppinglist Error", JOptionPane.CLOSED_OPTION);
			
		} else {
			int selectedIndex = rightTable.getSelectedRow();
			String selectedItem = (String) ((DefaultTableModel)rightTable.getModel()).getValueAt(selectedIndex, 0);
			System.out.println(selectedItem);
			Integer productId = null;
			rs = statm.executeQuery("SELECT id, ingredient FROM ingredients WHERE ingredient = '"+selectedItem+"'");
			while (rs.next()) {
				productId = rs.getInt("id");
			}
			System.out.println(productId);
			System.out.println(currentListId);
			statm.executeUpdate("DELETE FROM list_ingredient WHERE ingredient_id='"+productId+"' AND list_id='"+currentListId+"'");
			((DefaultTableModel)rightTable.getModel()).removeRow(selectedIndex);
		}
	}
	
	//Selecting item from left table and adding it into right table
	public void addProductToShoppingList() throws SQLException {
		// If no list is selected print error message, else add to database and right Table
		if (currentListId == null) {
			JOptionPane.showMessageDialog(this, "No list is selected.", "Shoppinglist Error", JOptionPane.CLOSED_OPTION);
		}
		else {
			int selectedIndex = leftTable.getSelectedRow();
			String selectedItem = (String) ((DefaultTableModel)leftTable.getModel()).getValueAt(selectedIndex, 0);
			String[] ItemToArray = {selectedItem};
			Integer productId = null;
			((DefaultTableModel)rightTable.getModel()).addRow(ItemToArray);	
			rs = statm.executeQuery("SELECT id, ingredient FROM ingredients WHERE ingredient = '"+selectedItem+"'");
			while (rs.next()) {
				productId = rs.getInt("id");
			}
			
			statm.executeUpdate("INSERT INTO list_ingredient (ingredient_id, list_id) VALUES('"+productId+"','"+currentListId+"')");
			
		}

	}
	
	//Adding products into left Table
	public void getProducts() throws SQLException {
		String getSql = "select * from ingredients"; 
		rs = statm.executeQuery(getSql);
		((DefaultTableModel)leftTable.getModel()).setNumRows(0);
		while (rs.next()) {			
			int numcols = leftTable.getModel().getColumnCount();
			Object [] fill = new Object[numcols];
			String product_item = rs.getString(3);
			fill[0] = product_item;
			((DefaultTableModel)leftTable.getModel()).addRow(fill);
		}
	}

	// Targeting the selected Shoppinglist and adding it into Right Table
	@Override
	public void actionPerformed(ActionEvent e) {
		String listString = e.getActionCommand();
		// Getting Shopping list from database and all items in that list
		productsLabel.setText("Your shoppinglist: " + listString);
		String sqlString = "SELECT shopping_list.id, title, ingredients.id, ingredients.ingredient, list_ingredient.quantity "
				+ "FROM shopping_list, list_ingredient, ingredients "
				+ "WHERE title = '"+listString+"' "
				+ "AND shopping_list.id = list_ingredient.list_id "
				+ "AND list_ingredient.ingredient_id = ingredients.id ";
		try {
			rs = statm.executeQuery(sqlString);
			((DefaultTableModel)rightTable.getModel()).setNumRows(0);
			while (rs.next()) {
//				Adding Shoppinglist into right table
				int numcols = rightTable.getModel().getColumnCount();
				Object [] fill = new Object[numcols];
				int product_quantity = rs.getInt("list_ingredient.quantity");
				String product_item = rs.getString("ingredients.ingredient");
				fill[0] = product_item;
				fill[1] = product_quantity;
				((DefaultTableModel)rightTable.getModel()).addRow(fill);		
			}
			
			String sqlListId = "SELECT id FROM shopping_list WHERE title = '"+listString+"'";
			rs = statm.executeQuery(sqlListId);
			while (rs.next()) {
				currentListId = rs.getInt("id");
			}
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}