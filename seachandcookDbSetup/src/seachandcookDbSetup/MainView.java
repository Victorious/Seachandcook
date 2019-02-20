package seachandcookDbSetup;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;

import com.sun.javafx.stage.WindowEventDispatcher;

import javafx.stage.WindowEvent;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class MainView {
	Connection con;
	Statement statm;
	ResultSet rs;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public MainView() throws SQLException {
		initialize();
		con = DbUtil.getDbConnection();
		statm = con.createStatement();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 420, 280);
		
		JButton btnSetup = new JButton("Setup Database");
		btnSetup.addActionListener(e -> {
		try {
			AddTables();
			InsertIngredientTypeValues();
			InsertDairy();
			InsertFish();
			InsertFruitAndVegetables();
			InsertHousehold();
			InsertMeat();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		});
		btnSetup.setBounds(47, 107, 141, 29);
		frame.getContentPane().add(btnSetup);
		
		JButton btnClose = new JButton("Exit Application");
		btnClose.addActionListener(e ->{
			frame.dispose();
		});
		btnClose.setBounds(224, 107, 143, 29);
		frame.getContentPane().add(btnClose);
		
		JLabel lblThisApplicationIs = new JLabel("This application is to setup a new enviorment\r\n");
		lblThisApplicationIs.setBounds(63, 26, 350, 20);
		frame.getContentPane().add(lblThisApplicationIs);
		
		JLabel lblOfSeachandcookDatabase = new JLabel("of seachandcook Database");
		lblOfSeachandcookDatabase.setBounds(122, 49, 186, 20);
		frame.getContentPane().add(lblOfSeachandcookDatabase);
	}
	
	public void AddTables() throws SQLException {
		String addIngredient_table = "CREATE TABLE ingredients(id INT NOT NULL AUTO_INCREMENT, ingredient_type INT, ingredient VARCHAR(200), PRIMARY KEY (id))";
		String addIngredient_type_table = "CREATE TABLE ingredient_type(id INT NOT NULL AUTO_INCREMENT, ingredient_type_id INT NOT NULL, ingredient_type VARCHAR(200), PRIMARY KEY (id))";
		String addList_ingredient = "CREATE TABLE list_ingredient(id INT NOT NULL AUTO_INCREMENT, ingredient_id INT, list_id INT, quantity INT, PRIMARY KEY(id))";
		String addShopping_list = "CREATE TABLE shopping_list(id INT NOT NULL AUTO_INCREMENT, title VARCHAR(200), PRIMARY KEY (id))";
		statm.executeUpdate(addIngredient_table);
		statm.executeUpdate(addIngredient_type_table);
		statm.executeUpdate(addList_ingredient);
		statm.executeUpdate(addShopping_list);
	}
	
	public void InsertIngredientTypeValues() throws SQLException {
		String addFruitAndVegetables = "INSERT INTO ingredient_type (ingredient_type_id, ingredient_type) VALUES ('1', 'Frukt&Gr�nt')";
		String addDairy = "INSERT INTO ingredient_type (ingredient_type_id, ingredient_type) VALUES ('2', 'Mejeri')";
		String addHouseHold = "INSERT INTO ingredient_type (ingredient_type_id, ingredient_type) VALUES ('3', 'Hush�ll')";
		String addMeat = "INSERT INTO ingredient_type (ingredient_type_id, ingredient_type) VALUES ('4', 'K�tt')";
		String addFish = "INSERT INTO ingredient_type (ingredient_type_id, ingredient_type) VALUES ('5', 'Fisk')";
		
		statm.executeUpdate(addFruitAndVegetables);
		statm.executeUpdate(addDairy);
		statm.executeUpdate(addHouseHold);
		statm.executeUpdate(addMeat);
		statm.executeUpdate(addFish);
	}
	
	public void InsertFruitAndVegetables() throws SQLException {
		String addCucumber = "INSERT INTO ingredients (ingredient_type, ingredient) VALUES ('1','Gurka')";
		String addTomato = "INSERT INTO ingredients (ingredient_type, ingredient) VALUES ('1','Tomat')";
		String addCorn = "INSERT INTO ingredients (ingredient_type, ingredient) VALUES ('1','Majs')";
		String addPaprika = "INSERT INTO ingredients (ingredient_type, ingredient) VALUES ('1','Paprika')";
		String addOrange = "INSERT INTO ingredients (ingredient_type, ingredient) VALUES ('1','Apelsin')";
		String addApple = "INSERT INTO ingredients (ingredient_type, ingredient) VALUES ('1','�ppel')";
		
		statm.executeUpdate(addCucumber);
		statm.executeUpdate(addTomato);
		statm.executeUpdate(addCorn);
		statm.executeUpdate(addPaprika);
		statm.executeUpdate(addOrange);
		statm.executeUpdate(addApple);
	}

	public void InsertHousehold() throws SQLException {
		String addToothbrush = "INSERT INTO ingredients (ingredient_type, ingredient) VALUES ('3','Tandborste')";
		String addThermometer = "INSERT INTO ingredients (ingredient_type, ingredient) VALUES ('3','Termometer')";
		String addDetergent = "INSERT INTO ingredients (ingredient_type, ingredient) VALUES ('3','Tv�ttmedel')";
		String addSoftener = "INSERT INTO ingredients (ingredient_type, ingredient) VALUES ('3','Sk�ljmedel')";
		String addWashingLiquid = "INSERT INTO ingredients (ingredient_type, ingredient) VALUES ('3','Tv�ttmedel')";
		
		statm.executeUpdate(addToothbrush);
		statm.executeUpdate(addThermometer);
		statm.executeUpdate(addDetergent);
		statm.executeUpdate(addSoftener);
		statm.executeUpdate(addWashingLiquid);
		
	}
	
	public void InsertDairy() throws SQLException {
		String addEgg = "INSERT INTO ingredients (ingredient_type, ingredient) VALUES ('2','�gg')";
		String addMilk = "INSERT INTO ingredients (ingredient_type, ingredient) VALUES ('2','Mj�lk')";
		String addYoghurt = "INSERT INTO ingredients (ingredient_type, ingredient) VALUES ('2','Yoghurt')";
		String addButter = "INSERT INTO ingredients (ingredient_type, ingredient) VALUES ('2','Sm�r')";
		String addCheese = "INSERT INTO ingredients (ingredient_type, ingredient) VALUES ('2','Ost')";
		String addIceCreme = "INSERT INTO ingredients (ingredient_type, ingredient) VALUES ('2','Glass')";
		
		statm.executeUpdate(addEgg);
		statm.executeUpdate(addMilk);
		statm.executeUpdate(addYoghurt);
		statm.executeUpdate(addButter);
		statm.executeUpdate(addCheese);
		statm.executeUpdate(addIceCreme);
	}

	public void InsertMeat() throws SQLException {
		String addChicken = "INSERT INTO ingredients (ingredient_type, ingredient) VALUES ('4','Kyckling')";
		String addFilletOfPork = "INSERT INTO ingredients (ingredient_type, ingredient) VALUES ('4','Fl�skfile')";
		String addFilletOfBeef = "INSERT INTO ingredients (ingredient_type, ingredient) VALUES ('4','Oxfile')";
		String addBacon = "INSERT INTO ingredients (ingredient_type, ingredient) VALUES ('4','Bacon')";
		String addMeatBalls = "INSERT INTO ingredients (ingredient_type, ingredient) VALUES ('4','K�ttbullar')";
		String addPorkChop = "INSERT INTO ingredients (ingredient_type, ingredient) VALUES ('4','Fl�skkotlett')";
		
		statm.executeUpdate(addChicken);
		statm.executeUpdate(addFilletOfPork);
		statm.executeUpdate(addFilletOfBeef);
		statm.executeUpdate(addBacon);
		statm.executeUpdate(addMeatBalls);
		statm.executeUpdate(addPorkChop);
	}

	public void InsertFish() throws SQLException {
		String addPlaice = "INSERT INTO ingredients (ingredient_type, ingredient) VALUES ('5','R�dspetta')";
		String addApolloFish = "INSERT INTO ingredients (ingredient_type, ingredient) VALUES ('5','Apollo Fisk')";
		String addPangasius  = "INSERT INTO ingredients (ingredient_type, ingredient) VALUES ('5','pangasius')";
		String addCod = "INSERT INTO ingredients (ingredient_type, ingredient) VALUES ('5','Torsk')";
		String addSalmon = "INSERT INTO ingredients (ingredient_type, ingredient) VALUES ('5','Lax')";
		String addFlounder = "INSERT INTO ingredients (ingredient_type, ingredient) VALUES ('5','Flundra')";
		
		statm.executeUpdate(addPlaice);
		statm.executeUpdate(addApolloFish);
		statm.executeUpdate(addPangasius);
		statm.executeUpdate(addCod);
		statm.executeUpdate(addSalmon);
		statm.executeUpdate(addFlounder);
	}
}
