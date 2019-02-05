import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class ShoppingList {
 
  private String Name;
  private String Comment;
  private String Tag;
  private LocalDate Date;
  Map<String, Double> Items= new HashMap<String, Double>();
  private static ArrayList<ShoppingList> ListOfLists = new ArrayList<ShoppingList>();
//create new shopping list
  public ShoppingList(String name, String com, String tags)
  { 
    if (name.length() == 0)
    {
    	name = "Untitled"+getUntitledNumber();
    }
    setListName(name);
    setListComment(com);
    setListComment(tags);
    setListDate ();
    addListToLists(this);  
  }
      
  //if list is untitled, verify how many untitled list already exist
  private String getUntitledNumber()
  {
	  return "1";
  }
  
  private void setListDate ()
  {
	  Date = LocalDate.now();
  }
  
  
  public LocalDate getListDate()
  {
	return Date;  
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
  
  public void addItemToList(String name, double num)
  {
	  Items.put(name, num);
  }
  
  public Map<String, Double> getListItems()
  {
	  for (String e: Items.keySet())
	  {
		  System.out.println(e);
	  }
	  return Items;
  }
  
  public void removeItemFromListByValue(String val)
  {
    Items.remove(val);
  }  
  
  private static void addListToLists(ShoppingList list)
  {
	  ListOfLists.add(list);
	  System.out.println(ListOfLists.size());
  }
  
  public static void removeListFromLists(ShoppingList list)
  {
	  ListOfLists.remove(list);
	  System.out.println(ListOfLists.size());

  }
  
}
