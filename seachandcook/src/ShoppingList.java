import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
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
    
    addListToLists(this);  
  }
      
  
  private void setListDate ()
  {
	  Date = (LocalDate.now()).toString();
  }
  
  private void setListId ()
  {
	  Id = String.valueOf(Instant.now().getEpochSecond());
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
