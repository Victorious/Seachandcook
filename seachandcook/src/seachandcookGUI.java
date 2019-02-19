//package seachandcook;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JList;
import javax.swing.JFormattedTextField;
import javax.swing.JToggleButton;
import javax.swing.ListModel;
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
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.Scrollbar;

import java.util.*;

public class seachandcookGUI extends JFrame {

	
	private JPanel contentPane;
	private JTable tableLeft;
	private JTable tableRight;
	private JScrollPane jp;
	private JTable leftTable;
	private JTable rightTable;

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
	 */
	public seachandcookGUI() {
		setTitle("Seach and Cook!");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 571);
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
		
		Button searchButton = new Button("Search");
		searchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		searchButton.setForeground(Color.WHITE);
		searchButton.setBackground(new Color(241, 57, 83));
		searchButton.setBounds(295, 125, 85, 22);
		panel.add(searchButton);
		
		Label seachlabel = new Label("Enter product name :");
		seachlabel.setBackground(new Color(255, 255, 255));
		seachlabel.setFont(new Font("Dialog", Font.BOLD, 12));
		seachlabel.setForeground(new Color(0, 0, 0));
		seachlabel.setBounds(47, 125, 123, 22);
		panel.add(seachlabel);

		TextField searchtextField = new TextField();
		searchtextField.setBounds(176, 125, 113, 22);
		panel.add(searchtextField);
		
		Button addButton = new Button("Add");
		addButton.setForeground(Color.WHITE);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//rightList.add(leftList.getSelectedItem());
				
				//sortList.add(leftList.getSelectedItem());
				
			}
		});
		addButton.setBackground(new Color(241, 57, 83));
		addButton.setBounds(295, 465, 85, 22);
		panel.add(addButton);
		
		JScrollPane scrollPaneLeft = new JScrollPane();
		scrollPaneLeft.setBounds(47, 156, 241, 331);
		panel.add(scrollPaneLeft);
		
		leftTable = new JTable();
		leftTable.setBackground(new Color(255, 255, 255));
		leftTable.setForeground(new Color(0, 0, 0));
		scrollPaneLeft.setViewportView(leftTable);
		
		JLabel lblNewLabel_1 = new JLabel("");
//		lblNewLabel_1.setIcon(new ImageIcon(seachandcookGUI.class.getResource("/seachandcook/Shoop.jpg")));
		lblNewLabel_1.setBounds(176, 14, 149, 105);
		panel.add(lblNewLabel_1);
		
		Label productsLabel = new Label("Your shoppinglist");
		productsLabel.setBounds(577, 87, 138, 45);
		productsLabel.setForeground(Color.WHITE);
		productsLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		contentPane.add(productsLabel);
		
		Button sortButton = new Button("Sort A-Z");
		sortButton.setForeground(Color.WHITE);
		sortButton.setBackground(new Color(241, 57, 83));
		sortButton.setBounds(412, 149, 80, 22);
		contentPane.add(sortButton);
		
		Button unsortButton = new Button("Unsort");
		unsortButton.setForeground(Color.WHITE);
		unsortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//rightList.setVisible(true);                       OBS!!!
				
				
			}
		});
		unsortButton.setBackground(Color.LIGHT_GRAY);
		unsortButton.setBounds(412, 188, 80, 22);
		contentPane.add(unsortButton);
		
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
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//rightList.remove(rightList.getSelectedItem());  OBS!!!
				//sortList.remove(rightList.getSelectedItem());  OBS!!!
				
			}
		});

		Button saveButton = new Button("Save");
		saveButton.setForeground(Color.WHITE);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		saveButton.setBackground(new Color(241, 57, 83));
		saveButton.setBounds(412, 264, 80, 22);
		contentPane.add(saveButton);
		
		JScrollPane scrollPaneRight = new JScrollPane();
		scrollPaneRight.setBounds(514, 149, 258, 332);
		contentPane.add(scrollPaneRight);
		
		//RIGHT TABLE WITH COLUMNS
		rightTable = new JTable();
		rightTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Item", "Amount", "Price"
			}
		));
		scrollPaneRight.setViewportView(rightTable);
		
	}
}