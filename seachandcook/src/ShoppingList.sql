CREATE TABLE shoppingListsInfo(
   ID int NOT NULL AUTO_INCREMENT,
   listName CHAR (255),
   creationDate date,
   listComment  CHAR (255),
   listTag CHAR (255),        
   
   PRIMARY KEY (ID)
   );
 #DEFAULT 'ENGLISH'

 INSERT INTO shoppingListsInfo (listName, creationDate) VALUES ("workingday lunches",  curdate());
 SELECT * from shoppinglistsinfo;