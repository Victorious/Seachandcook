import java.sql.*;
public class ShoppingListDB {
static Connection con;
static ResultSet rs, rs_quiz;
private static Statement stmt;      
private static String url_main ="jdbc:mysql://localhost:3306/shoppinglist";
private static String password = "Pass123";
// constructor to establish connection with db  
public static void connectToDB() { 
 try{
      con=DriverManager.getConnection(url_main,"root", password);
	  System.out.println("Connection with database was established");
	  stmt =  con.createStatement();
	  con.createStatement();
	} 
catch (Exception e) 
	{ 
	System.out.println(e.getMessage());
	}
}

//create new shoppingList
public static void addNewShoppingList(ShoppingList list)
{
  String create_new_list = "INSERT INTO shoppinglistsinfo (listName, creationDate, listComment, listTag, ID) VALUES (?, ?, ?, ?, ?);";
  System.out.println(create_new_list);
  try {
	  
	    PreparedStatement insert_command = con.prepareStatement(create_new_list);
		insert_command.setString(1, list.getListName());
		insert_command.setString(2, (list.getListDate()).toString());
		insert_command.setString(3, list.getListComment());
		insert_command.setString(4, list.getListTag());
		insert_command.setString(5, list.getListId());
		insert_command.executeUpdate();
		insert_command.close();
		System.out.println("Comment");
   } catch (SQLException e) {
	e.printStackTrace();
  }
}

//rename list
public static void renameList(ShoppingList list, String newListName)
{
	String rename_list_querry=null;
	System.out.println(list.getListId());
	rename_list_querry = "UPDATE shoppinglistsinfo SET listName = ? WHERE id = ?;";
    try {
			  
			    PreparedStatement insert_command = con.prepareStatement(rename_list_querry);
				insert_command.setString(1, newListName);
				insert_command.setString(2, list.getListId());
				insert_command.executeUpdate();
				//insert_command.close();
				//System.out.println(column_to_change);
		   } catch (SQLException e) {
			e.printStackTrace();
		  }
}
//edit list comment
public static void changeListComment(ShoppingList list, String newComment)
{
	String edit_comment_querry=null;
	System.out.println(list.getListId());
	edit_comment_querry = "UPDATE shoppinglistsinfo SET listComment = ? WHERE id = ?;";
  try {
			  
			    PreparedStatement insert_command = con.prepareStatement(edit_comment_querry);
				insert_command.setString(1, newComment);
				insert_command.setString(2, list.getListId());
				insert_command.executeUpdate();
				//insert_command.close();
				//System.out.println(column_to_change);
		   } catch (SQLException e) {
			e.printStackTrace();
		  }
}

//edit list tag
public static void changeListTag(ShoppingList list, String newTag)
{
	String edit_tag_querry=null;
	System.out.println(list.getListId());
	edit_tag_querry = "UPDATE shoppinglistsinfo SET listTag = ? WHERE id = ?;";
try {
			  
			    PreparedStatement insert_command = con.prepareStatement(edit_tag_querry);
				insert_command.setString(1, newTag);
				insert_command.setString(2, list.getListId());
				insert_command.executeUpdate();
				//insert_command.close();
				//System.out.println(column_to_change);
		   } catch (SQLException e) {
			e.printStackTrace();
		  }
}
}//end
