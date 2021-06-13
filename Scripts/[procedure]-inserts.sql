/*
Description: Procedure that insert data in the table person
Author: Allison M. Merlo
Creation Date: 2/06/2021
*/
DELIMITER $$
CREATE PROCEDURE lb.insertPerson(IN inID_Number INT, IN inPersonType INT, IN inFirstname VARCHAR(40), IN inLastname VARCHAR(40), IN inBirthdate VARCHAR(40)) 
MODIFIES SQL DATA
BEGIN
  DECLARE CONTINUE HANDLER FOR 1062
  SELECT 'Error, duplicate key occurred';
    
  INSERT INTO LB.Person(ID_Number,ID_PersonType, Firstname, Lastname, Birthdate)
  VALUES(inID_Number, inPersonType, inFirstname, inLastname, STR_TO_DATE(inBirthdate,'%d,%m,%Y'));
END$$

/*
Description: Procedure that insert data in the table address
Author: Allison M. Merlo
Creation Date: 2/06/2021
*/
CREATE PROCEDURE lb.insertAddress(IN inID INT, IN inAddress VARCHAR(50)) 
MODIFIES SQL DATA
BEGIN
  DECLARE CONTINUE HANDLER FOR 1062
  SELECT 'Error, duplicate key occurred';
    
  INSERT INTO LB.Address(ID_Person, Address)
  VALUES(inID, inAddress);
END$$

/*
Description: Procedure that insert data in the table email
Author: Allison M. Merlo
Creation Date: 2/06/2021
*/
CREATE PROCEDURE lb.insertEmail(IN inPersonID INT, IN inEmail VARCHAR(50)) 
MODIFIES SQL DATA
BEGIN
  DECLARE CONTINUE HANDLER FOR 1062
  SELECT 'Error, duplicate key occurred';
    
  INSERT INTO LB.Email(ID_Person, Email)
  VALUES(inPersonID, inEmail);
END$$

/*
Description: Procedure that insert data in the table book
Author: Allison M. Merlo
Creation Date: 2/06/2021
*/
CREATE PROCEDURE lb.insertBook(IN inTitle VARCHAR(100), IN inClasification INT, IN inItem INT, IN inAuthor VARCHAR(100), IN inPublishingHouse VARCHAR(100), IN inScore INT, IN inEdition INT, IN inCoverPage VARCHAR(100)) 
MODIFIES SQL DATA
BEGIN

   DECLARE CONTINUE HANDLER FOR 1062
   SELECT 'Error, duplicate key occurred';
    
  INSERT INTO LB.BOOK(Title, ID_Clasification, ID_Item, Author, EDITION, CoverPage, PublishingHouse, Score)
  VALUES(inTitle, inClasification, inItem, inAuthor, inEdition, inCoverPage, inPublishingHouse, inScore);
END$$

/*
Description: Procedure that insert data in the table item
Author: Gabriela Gutiérrez
Creation Date: 2/06/2021
*/
CREATE PROCEDURE lb.createItem(IN inName varchar(100)) 
MODIFIES SQL DATA
BEGIN
	DECLARE EXIT HANDLER FOR SQLEXCEPTION
	BEGIN
		ROLLBACK;
		SELECT 'An error has occurred, operation rollbacked and the stored procedure was terminated';
	END;

  INSERT INTO LB.Item(name, description, on_loan)
  VALUES(inName, 'Item del libro', 0);
END$$

