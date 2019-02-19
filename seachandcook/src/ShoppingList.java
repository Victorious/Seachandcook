//ShoppingList class can
//-  create new list with help of constructor
// - set and get list name
// - set and get list date
// - get list id(NB. list id cannot be modified, it is created when list is created and is unix name)
// - set and get list Comment
// - send and get list Tag (tag can be whatever, ex. "birthday", "mammas cakes" etc)
//  addItemToList(String name, double num) - to add new ingredient to list, but may be we do not need it if we connect ingredients db and list db somehow
//  getListItems() - return list's ingredients
//  removeItem(String val) - remove item from list
// addListToLists(ShoppingList list) add list to the list of lists we need this function if we will for ex. find all lists with some tag, ingredient etc.
// removeListFromLists(ShoppingList list) remove list from list of lists
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import java.time.Instant;
public class ShoppingList {
 
  private String Name;
  private String Comment;
  private String Tag;
  private String Date;
  private String Id;
  Map<String, Double> Items= new HashMap<String, Double>();
  private static ArrayList<ShoppingList> ListOfLists = new ArrayList<ShoppingList>();
//create new shopping list
  public ShoppingList(String name, String com, String tags)
  { 
	
    if (name.length() == 0)
    {
    	name = "Untitled list";
    }
    setListName(name);
    setListComment(com);
    setListComment(tags);
    setListDate ();
    setListId ();  
    System.out.println(this);

  }
      
  private void setListDate ()
  {
	  Date = (LocalDate.now()).toString();
  }
  
  private void setListId ()
  {
	  Id = String.valueOf(System.currentTimeMillis());
  }
  
  public String getListDate()
  {
	return Date;  
  }
  
  public String getListId()
  {
	return Id;  
  }
  
  public void setListName( String name)
  {
	  Name = name;
  }
  
  
  public String getListName()
  {
	  return Name;
  }
  
  public void setListComment(String comment)
  {
	  Comment = comment;
  }
  
  public String getListComment()
  {
	  return Comment;
  }
  public void setListTag(String tag)
  {
	  Tag = tag;
  }
  
  public String getListTag()
  {
	  return Tag;
  }
  // add new ingredient and quantity to list 
  public void addItemToList(String name, double num)
  {
	  Items.put(name, num);
  }
  
  //return list's ingredients
  public Map<String, Double> getListItems()
  {
	  for (String e: Items.keySet())
	  {
		  System.out.println(e);
	  }
	  return Items;
  }
  //remove ingredient from list
  public void removeItem(String val)
  {
    Items.remove(val);
  }  
  //add list to the list of lists
  //we need this function if we will for ex. 
  // find all lists with some tag, ingredient etc.
  private static void addListToLists(ShoppingList list)
  {
	  ListOfLists.add(list);
	  System.out.println(ListOfLists.size());
  }
  
  // remove list from list of lists
  public static void removeListFromLists(ShoppingList list)
  {
	  ListOfLists.remove(list);
	  System.out.println(ListOfLists.size());

  }
  
}
