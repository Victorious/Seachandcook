CREATE TABLE shoppingListsInfo(
   ID bigint NOT NULL,
   listName CHAR (255),
   creationDate date,
   listComment  CHAR (255),
   listTag CHAR (255),        
   PRIMARY KEY (ID)
   );
   
   CREATE TABLE shoppingItems(
   ID int auto_increment,
   itemName CHAR (255),
   PRIMARY KEY (ID)
  );
  CREATE TABLE ListItems(
  id int NOT NULL auto_increment,
  itemId int,
  listId bigint,
  itemQuantity int,
  PRIMARY KEY (id),
  FOREIGN KEY (itemId) REFERENCES shoppingItems(ID),
  FOREIGN KEY (listId) REFERENCES shoppingListsInfo(ID)
  );
   
 #DEFAULT 'ENGLISH'

 INSERT INTO shoppingListsInfo (listName, creationDate, ID) VALUES ("workingday lunches",  curdate(), 1550610061);
 INSERT INTO shoppingItems(ID, itemName) VALUES(1, "potato");
 INSERT INTO shoppingItems(ID, itemName) VALUES(2, "bread");

 SELECT * from shoppinglistsinfo;
 SELECT * from shoppingItems;
 SELECT * from ListItems;
 