/*DOCUMENTACIÓN INTERNA
Descripción: Procedimiento que recibe por parámetro los datos e inserta en las tablas person, email y book
Autor principal: Allison Montero
Fecha de creación: 1/05/2021
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

CREATE PROCEDURE lb.insertAddress(IN inID INT, IN inAddress VARCHAR(50)) 
MODIFIES SQL DATA
BEGIN
  DECLARE CONTINUE HANDLER FOR 1062
  SELECT 'Error, duplicate key occurred';
    
  INSERT INTO LB.Address(ID_Person, Address)
  VALUES(inID, inAddress);
END$$

CREATE PROCEDURE lb.insertEmail(IN inPersonID INT, IN inEmail VARCHAR(50)) 
MODIFIES SQL DATA
BEGIN
  DECLARE CONTINUE HANDLER FOR 1062
  SELECT 'Error, duplicate key occurred';
    
  INSERT INTO LB.Email(ID_Person, Email)
  VALUES(inPersonID, inEmail);
END$$

CREATE PROCEDURE lb.insertBook(IN inTitle VARCHAR(100), IN inClasification INT, IN inItem INT, IN inAuthor VARCHAR(100), IN inPublishingHouse VARCHAR(100), IN inScore INT, IN inEdition INT, IN inCoverPage VARCHAR(100)) 
MODIFIES SQL DATA
BEGIN

   DECLARE CONTINUE HANDLER FOR 1062
   SELECT 'Error, duplicate key occurred';
    
  INSERT INTO LB.BOOK(Title, ID_Clasification, ID_Item, Author, EDITION, CoverPage, PublishingHouse, Score)
  VALUES(inTitle, inClasification, inItem, inAuthor, inEdition, inCoverPage, inPublishingHouse, inScore);
END$$

