
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

    System.out.println("\n");
    list1.removeItem("potatos");
    list1.getListItems();
    System.out.println(list2.getListId());
    ShoppingListDB.connectToDB();
    ShoppingListDB.addNewShoppingList(list1);
    ShoppingListDB.renameList(list2,"this is new name", "1549479695");
	}

}
