//************************************************************
//This class establish connection with db with 3 tables:
//shoppinglistinfo - tables with shopping lists 
//shoppingitems -    all items(ingredients) that could be added to list
//listitems -        connects shopping list and items that could be added
//This class is used to:
//     create shopping list
//     remove shopping list
//     update shopping list
//     add/update item/ingredient to shopping list
//     get items/ingredients of shopping list
//     get all items/ingredients that could be added
//     
//***********************************************************
import java.sql.*;
import java.util.Map;
import java.util.Map.Entry;
public class ShoppingListDB {
static Connection con;
static ResultSet rs, rs_1;
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

//create new shoppingList (it is created without ingredients, 
//ingredients could be added via separate function addListItems())
public static void addNewShoppingList(ShoppingList list)
{
	//sql command
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

// get all available ingredients
public static void getListOfAllItems()
{
	String read_items = "SELECT itemName FROM shoppingitems;"; 
	try {
		rs=stmt.executeQuery(read_items);
		while(rs.next())
		{
			System.out.println(rs.getString(1));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

//get ingredients of the list sent as argument
public static void getListItems(ShoppingList list)
{
	String get_list_items = "SELECT shoppingitems.itemName FROM shoppingitems INNER JOIN listitems ON shoppingitems.ID=listitems.itemId WHERE listitems.listid=?;";
	try {
	    PreparedStatement show_command = con.prepareStatement(get_list_items);
	    show_command.setString(1, list.getListId());
	    rs=show_command.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getString(1));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

//get ingredients of the list sent as argument
public static void deleteListItem(ShoppingList list, String item)
{
	String get_list_items = "DELETE listitems FROM listitems JOIN shoppingitems  ON shoppingitems.ID=listitems.itemId AND shoppingitems.itemName=? AND listitems.ID=?;";
	try {
	    PreparedStatement delete_command = con.prepareStatement(get_list_items);
	    delete_command.setString(1, list.getListId());
	    delete_command.setString(2, item);
	    int res = delete_command.executeUpdate();
		while(rs.next())
		{
			System.out.println(rs.getString(1));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}


// add ingredient(s) to the shopping list
// if this ingredient is not already in list it will be added 
// otherwise update existing item with new quantity
//this function should be divided in several functions, it is too long
public static void addItem (ShoppingList list, Map<String, Double> items)
{
	  String add_item_to_list = "INSERT INTO listitems (itemid, listId, itemQuantity) VALUES (?, ?, ?);";
	  String find_item_in_db = "SELECT ID FROM shoppingitems WHERE (itemName=?);"; 
	  String find_item_already_in_list = "SELECT ID FROM listitems WHERE (itemId=? AND listId=?);"; 
	  String update_item_in_list = "UPDATE listitems SET itemQuantity = ? WHERE id = ?;";
	  //get shopping list id
	  String listId = list.getListId();
	  String foundId=null;
	  //find if item to add is in db shopping items
	  if (items.size()>0)
	  {
		  for (String i: items.keySet())
		  {
				try {
				    PreparedStatement add_item = con.prepareStatement(find_item_in_db);
				    add_item.setString(1, i);
				    rs=add_item.executeQuery();
				    // if there is such item in items in db add item for this list in ListItems table
				    if (rs.next()) { 
				    	foundId = rs.getString("ID");
					    PreparedStatement show_command = con.prepareStatement(find_item_already_in_list);
					    show_command.setString(1, foundId);
					    show_command.setString(2, listId);
					    rs_1=show_command.executeQuery();
					    
					    //read quantity of item
					    String num =  items.get(i).toString();
				    	//if there is no such connection add new item
					    if (!rs_1.next())
					    {				    
					    	//AddNewItem(foundId, listId, num);
							PreparedStatement insert_command = con.prepareStatement(add_item_to_list);
							insert_command.setString(1, foundId);
							insert_command.setString(2, listId);
							insert_command.setString(3, num);
							insert_command.executeUpdate();
							insert_command.close();
					    	System.out.println("This item is not in list, adding it");
					    }	
				    	//otherwise update existing entry
					    else
					    {
							PreparedStatement insert_command = con.prepareStatement(update_item_in_list);
							insert_command.setString(1, rs.getString("ID"));
							insert_command.setString(2, num);
							insert_command.executeUpdate();
							insert_command.close();
					    	System.out.println("This item is already in list, updating it");
					    }

				    }
				    else {
				    	System.out.println("There is no such ingredient in db");
				    }
					System.out.println(foundId);
				} catch (SQLException e) {
					e.printStackTrace();
				}
		  }
	  }
      
}

//rename shopping list
public static void renameList(ShoppingList list, String newListName, String id)
{
	String rename_list_querry=null;
	System.out.println(list.getListId());
	rename_list_querry = "UPDATE shoppinglistsinfo SET listName = ? WHERE id = ?;";
    try {
			  
			    PreparedStatement insert_command = con.prepareStatement(rename_list_querry);
				insert_command.setString(1, newListName);
				insert_command.setString(2, id);
				insert_command.executeUpdate();
				//insert_command.close();
				//System.out.println(column_to_change);
		   } catch (SQLException e) {
			e.printStackTrace();
		  }
}
//edit shopping list comment
public static void changeListComment(ShoppingList list, String newComment, String id)
{
	String edit_comment_querry=null;
	System.out.println(list.getListId());
	edit_comment_querry = "UPDATE shoppinglistsinfo SET listComment = ? WHERE id = ?;";
  try {
			  
			    PreparedStatement insert_command = con.prepareStatement(edit_comment_querry);
				insert_command.setString(1, newComment);
				insert_command.setString(2, id);
				insert_command.executeUpdate();
				//insert_command.close();
				//System.out.println(column_to_change);
		   } catch (SQLException e) {
			e.printStackTrace();
		  }
}

//edit list tag
public static void changeListTag(ShoppingList list, String newTag, String id)
{
	String edit_tag_querry=null;
	System.out.println(list.getListId());
	edit_tag_querry = "UPDATE shoppinglistsinfo SET listTag = ? WHERE id = ?;";
try {
			  
			    PreparedStatement insert_command = con.prepareStatement(edit_tag_querry);
				insert_command.setString(1, newTag);
				insert_command.setString(2, id);
				insert_command.executeUpdate();
				//insert_command.close();
				//System.out.println(column_to_change);
		   } catch (SQLException e) {
			e.printStackTrace();
		  }
}

}//end
