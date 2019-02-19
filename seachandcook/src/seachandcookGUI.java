import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollBar;
import java.awt.Scrollbar;

import java.util.*;

public class seachandcookGUI extends JFrame {

	private JPanel contentPane;

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

		Button searchButton = new Button("Search");
		searchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		searchButton.setForeground(Color.WHITE);
		searchButton.setBackground(new Color(241, 57, 83));
		searchButton.setBounds(258, 10, 85, 22);
		panel.add(searchButton);

		Label seachlabel = new Label("Enter product name :");
		seachlabel.setFont(new Font("Dialog", Font.BOLD, 11));
		seachlabel.setForeground(Color.WHITE);
		seachlabel.setBounds(10, 10, 123, 22);
		panel.add(seachlabel);

		TextField searchtextField = new TextField();
		searchtextField.setBounds(139, 10, 113, 22);
		panel.add(searchtextField);
		
		List leftList = new List();
		leftList.setBounds(48, 60, 242, 283);
		panel.add(leftList);
		
		ArrayList<String> sortList = new ArrayList<String>();
		
								//Testprodukter
		leftList.add("Gurka");
		leftList.add("Tomat");
		leftList.add("Pasta");
		leftList.add("Köttbullar");
		leftList.add("Grädde");

		DefaultListModel rightModel = new DefaultListModel();
		JList rightList = new JList(rightModel);
		rightList.setBounds(412, 58, 219, 283);
		contentPane.add(rightList);
		

		Button addButton = new Button("Add");
		addButton.setForeground(Color.WHITE);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rightModel.addElement(leftList.getSelectedItem());
				sortList.add(leftList.getSelectedItem());
				
			}
		});
		addButton.setBackground(new Color(241, 57, 83));
		addButton.setBounds(48, 366, 85, 22);
		panel.add(addButton);

		Label productsLabel = new Label("Your shoppinglist");
		productsLabel.setBounds(472, 30, 124, 22);
		productsLabel.setForeground(Color.WHITE);
		productsLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(productsLabel);
		
		
		Button sortButton = new Button("Sort A-Z");
		sortButton.setForeground(Color.WHITE);
		sortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ListModel model = rightList.getModel();
				String[] strings = new String[rightModel.size()];
				for (int i = 0; i < strings.length; i++) {
					strings[i] = model.getElementAt(i).toString();
				}
				Arrays.sort(strings);
				rightList.setListData(strings);
//				rightList.setVisible(false);
				
//				Collections.sort(rightList);
//				JList<String> tempList = new JList<>(sortList.toArray(new String[0]));
//				tempList.setBounds(412, 58, 219, 283);
//				contentPane.add(tempList);
				
			}
		});
		sortButton.setBackground(new Color(241, 57, 83));
		sortButton.setBounds(412, 345, 80, 22);
		contentPane.add(sortButton);
		
		
		Button unsortButton = new Button("Unsort");
		unsortButton.setForeground(Color.WHITE);
		unsortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rightList.setVisible(true);
			
				
			}
		});
		unsortButton.setBackground(Color.GREEN);
		unsortButton.setBounds(412, 370, 80, 22);
		contentPane.add(unsortButton);
		
		JLabel lblNewLabel = new JLabel("Total products: " + sortList.size());
		lblNewLabel.setBounds(412, 445, 113, 14);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel);

		Button deleteButton = new Button("Delete");
		deleteButton.setForeground(Color.WHITE);
		deleteButton.setBounds(412, 395, 80, 22);
		contentPane.add(deleteButton);
		deleteButton.setBackground(new Color(241, 57, 83));
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rightList.remove(rightList.getSelectedItem());
				sortList.remove(rightList.getSelectedItem());
				
			}
		});

		Button saveButton = new Button("Save");
		saveButton.setForeground(Color.WHITE);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		saveButton.setBackground(new Color(241, 57, 83));
		saveButton.setBounds(412, 420, 80, 22);
		contentPane.add(saveButton);
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
	}
}