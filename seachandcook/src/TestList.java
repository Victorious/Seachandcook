import java.util.HashMap;
import java.util.Map;

public class TestList {
	ShoppingListDB s = new ShoppingListDB();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	ShoppingList list1 = new ShoppingList("LIST 1", "weekend", "t1");

	ShoppingList  list2 = new ShoppingList("LIST 2", "weekend", "t2");
	System.out.println(list1.getListName());

	System.out.println(list2.getListName());
    list1.addItemToList("tomato", 1); 
    list1.getListItems();
    System.out.println("\n");
    list1.addItemToList("peas", 3); 
    list1.getListItems();
    System.out.println("\n");
    list1.addItemToList("pares", 2); 
    list1.getListItems();
    System.out.println("\n");
    list1.addItemToList("potatos", 1.5);
    list1.getListItems();
    System.out.println(list1.getListDate());
    System.out.println(list2.getListDate());
    list1.getListItems();
    System.out.println("\n");
    list1.removeItem("potatos");
    list1.getListItems();
    System.out.println(list2.getListId());
    ShoppingListDB.connectToDB();
    ShoppingListDB.addNewShoppingList(list1);
    Map<String, Double> Items= new HashMap<String, Double>();
    Items.put("potato", 2.0);
    Items.put("apple", 1.5);
    Items.put("tomato", 3.5);
    Items.put("potato", 5.0);
    Items.put("cucumber", 4.0);
    ShoppingListDB.addItem(list1, Items);
    ShoppingListDB.addItem(list1, Items);
    ShoppingListDB.addItem(list2, Items);
    ShoppingListDB.getListOfAllItems();
    ShoppingListDB.getListItems(list1);
    ShoppingListDB.deleteListItem(list1, "potato");
    //ShoppingListDB.renameList(list2,"this is new name", "1549479695");
	}

}
