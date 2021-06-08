/*Trigger INSERT para LB.Person*/
DELIMITER $$
CREATE TRIGGER LB.Person_OnInsert
BEFORE INSERT ON LB.Person
FOR EACH ROW
BEGIN
	SET NEW.createdon = NOW();
	SET NEW.CREATEDBY = CURRENT_USER();
    
    INSERT INTO LB.LogBook(ChangeDate, ChangeHour, ChangeType, Object, ChangeDescription, Username)
    VALUES(NOW(), CURRENT_TIME(), 'Insert', 'Person', 'New person inserted on database', CURRENT_USER());
END$$

/*Trigger UPDATE para LB.Person*/

CREATE TRIGGER LB.Person_OnUpdate
BEFORE UPDATE ON LB.Person
FOR EACH ROW

BEGIN
  SET NEW.UPDATEDON = NOW();
  SET NEW.UPDATEDBY = CURRENT_USER();
  
  INSERT INTO LB.LogBook(ChangeDate, ChangeHour, ChangeType, Object, ChangeDescription, Username)
  VALUES(NOW(), CURRENT_TIME(), 'Update', 'Person', 'Person data updated on database', CURRENT_USER());
END$$


/*Trigger INSERT para LB.Email*/
CREATE TRIGGER LB.Email_OnInsert
BEFORE INSERT ON LB.Email
FOR EACH ROW

BEGIN
  SET NEW.createdon = NOW();
  SET NEW.CREATEDBY = CURRENT_USER();
  
  INSERT INTO LB.LogBook(ChangeDate, ChangeHour, ChangeType, Object, ChangeDescription, Username)
    VALUES(NOW(), CURRENT_TIME(), 'Insert', 'Email', 'New email inserted on database', CURRENT_USER());
END$$

/*Trigger UPDATE para LB.Email*/
CREATE TRIGGER LB.Email_OnUpdate
BEFORE UPDATE ON LB.Email
FOR EACH ROW

BEGIN
  SET NEW.UPDATEDON = NOW();
  SET NEW.UPDATEDBY = CURRENT_USER();
  
  INSERT INTO LB.LogBook(ChangeDate, ChangeHour, ChangeType, Object, ChangeDescription, Username)
  VALUES(NOW(), CURRENT_TIME(), 'Update', 'Email', 'Person email updated on database', CURRENT_USER());
END$$

/*Trigger INSERT para LB.Address*/
CREATE TRIGGER LB.Address_OnInsert
BEFORE INSERT ON LB.Address
FOR EACH ROW

BEGIN
  SET NEW.createdon = NOW();
  SET NEW.CREATEDBY = CURRENT_USER();
  
  INSERT INTO LB.LogBook(ChangeDate, ChangeHour, ChangeType, Object, ChangeDescription, Username)
  VALUES(NOW(), CURRENT_TIME(), 'Insert', 'Address', 'New address inserted on database', CURRENT_USER());
END$$

/*Trigger UPDATE para LB.Address*/
CREATE TRIGGER LB.Address_OnUpdate
BEFORE UPDATE ON LB.Address
FOR EACH ROW

BEGIN
  SET NEW.UPDATEDON = NOW();
  SET NEW.UPDATEDBY = CURRENT_USER();
  
  INSERT INTO LB.LogBook(ChangeDate, ChangeHour, ChangeType, Object, ChangeDescription, Username)
  VALUES(NOW(), CURRENT_TIME(), 'Update', 'Address', 'Person address updated on database', CURRENT_USER());
END$$

/*Trigger INSERT para LB.Person_Type*/
CREATE TRIGGER LB.PersonType_OnInsert
BEFORE INSERT ON LB.Person_Type 
FOR EACH ROW

BEGIN
  SET NEW.createdon = NOW();
  SET NEW.CREATEDBY = CURRENT_USER();
  
  INSERT INTO LB.LogBook(ChangeDate, ChangeHour, ChangeType, Object, ChangeDescription, Username)
  VALUES(NOW(), CURRENT_TIME(), 'Insert', 'PersonType', 'New person type inserted on database', CURRENT_USER());
END$$

/*Trigger UPDATE para LB.Person_Type*/
CREATE TRIGGER LB.PersonType_OnUpdate
BEFORE UPDATE ON LB.Person_Type
FOR EACH ROW

BEGIN
  SET NEW.UPDATEDON = NOW();
  SET NEW.UPDATEDBY = CURRENT_USER();
  
  INSERT INTO LB.LogBook(ChangeDate, ChangeHour, ChangeType, Object, ChangeDescription, Username)
  VALUES(NOW(), CURRENT_TIME(), 'Update', 'Person_Type', 'Person type updated on database', CURRENT_USER());
END$$

/*Trigger INSERT para LB.Loan_Control*/
CREATE TRIGGER LB.LoanControl_OnInsert
BEFORE INSERT ON LB.Loan_Control
FOR EACH ROW

BEGIN
  SET NEW.createdon = NOW();
  SET NEW.CREATEDBY = CURRENT_USER();
  
  INSERT INTO LB.LogBook(ChangeDate, ChangeHour, ChangeType, Object, ChangeDescription, Username)
  VALUES(NOW(), CURRENT_TIME(), 'Insert', 'LoanControl', 'New loan inserted on database', CURRENT_USER());
END$$

/*Trigger UPDATE para LB.Loan_Control*/
CREATE TRIGGER LB.LoanControl_OnUpdate
BEFORE UPDATE ON LB.Loan_Control
FOR EACH ROW

BEGIN
  SET NEW.UPDATEDON = NOW();
  SET NEW.UPDATEDBY = CURRENT_USER(); 
  
  INSERT INTO LB.LogBook(ChangeDate, ChangeHour, ChangeType, Object, ChangeDescription, Username)
  VALUES(NOW(), CURRENT_TIME(), 'Update', 'Loan_Control', 'Loan updated on database', CURRENT_USER());
END$$

/*Trigger INSERT para LB.Item*/
CREATE TRIGGER LB.Item_OnInsert
BEFORE INSERT ON LB.Item
FOR EACH ROW

BEGIN
  SET NEW.createdon = NOW();
  SET NEW.CREATEDBY = CURRENT_USER(); 
  
  INSERT INTO LB.LogBook(ChangeDate, ChangeHour, ChangeType, Object, ChangeDescription, Username)
  VALUES(NOW(), CURRENT_TIME(), 'Insert', 'Item', 'New item inserted on database', CURRENT_USER());
END$$

/*Trigger UPDATE paraLB.Item*/
CREATE TRIGGER LB.Item_OnUpdate
BEFORE UPDATE ON LB.Item
FOR EACH ROW

BEGIN
  SET NEW.UPDATEDON = NOW();
  SET NEW.UPDATEDBY = CURRENT_USER(); 
  
  INSERT INTO LB.LogBook(ChangeDate, ChangeHour, ChangeType, Object, ChangeDescription, Username)
  VALUES(NOW(), CURRENT_TIME(), 'Update', 'Item', 'Item updated on database', CURRENT_USER());
END$$

/*Trigger INSERT para LB.Book*/
CREATE TRIGGER LB.Book_OnInsert
BEFORE INSERT ON LB.Book
FOR EACH ROW

BEGIN
  SET NEW.createdon = NOW();
  SET NEW.CREATEDBY = CURRENT_USER(); 
  
  INSERT INTO LB.LogBook(ChangeDate, ChangeHour, ChangeType, Object, ChangeDescription, Username)
  VALUES(NOW(), CURRENT_TIME(), 'Insert', 'Book', 'New book inserted on database', CURRENT_USER());
END$$

/*Trigger UPDATE para LB.Book*/
CREATE TRIGGER LB.Book_OnUpdate
BEFORE UPDATE ON LB.Book
FOR EACH ROW

BEGIN
  SET NEW.UPDATEDON = NOW();
  SET NEW.UPDATEDBY = CURRENT_USER(); 
  
  INSERT INTO LB.LogBook(ChangeDate, ChangeHour, ChangeType, Object, ChangeDescription, Username)
  VALUES(NOW(), CURRENT_TIME(), 'Update', 'Book', 'Book data updated on database', CURRENT_USER());
END$$

/*Trigger INSERT para LB.Book_Clasification*/
CREATE TRIGGER LB.BookClasification_OnInsert
BEFORE INSERT ON LB.Book_Clasification
FOR EACH ROW

BEGIN
  SET NEW.createdon = NOW();
  SET NEW.CREATEDBY = CURRENT_USER(); 
  
  INSERT INTO LB.LogBook(ChangeDate, ChangeHour, ChangeType, Object, ChangeDescription, Username)
  VALUES(NOW(), CURRENT_TIME(), 'Insert', 'Book_Clasification', 'New book clasification inserted on database', CURRENT_USER());
END$$

/*Trigger UPDATE para LB.Book_Clasification*/
CREATE TRIGGER LB.BookClasification_OnUpdate
BEFORE UPDATE ON LB.Book_Clasification
FOR EACH ROW

BEGIN
  SET NEW.UPDATEDON = NOW();
  SET NEW.UPDATEDBY = CURRENT_USER(); 
  
  INSERT INTO LB.LogBook(ChangeDate, ChangeHour, ChangeType, Object, ChangeDescription, Username)
  VALUES(NOW(), CURRENT_TIME(), 'Update', 'Book_Clasification', 'Book clasification updated on database', CURRENT_USER());
END$$

/*Trigger INSERT para LB.Videogame*/
CREATE TRIGGER LB.Videogame_OnInsert
BEFORE INSERT ON LB.Videogame
FOR EACH ROW

BEGIN
  SET NEW.createdon = NOW();
  SET NEW.CREATEDBY = CURRENT_USER(); 
  
  INSERT INTO LB.LogBook(ChangeDate, ChangeHour, ChangeType, Object, ChangeDescription, Username)
  VALUES(NOW(), CURRENT_TIME(), 'Insert', 'VideoGame', 'New videogame inserted on database', CURRENT_USER());
END$$

/*Trigger UPDATE para LB.Videogame*/
CREATE TRIGGER LB.Videogame_OnUpdate
BEFORE UPDATE ON LB.Videogame
FOR EACH ROW

BEGIN
  SET NEW.UPDATEDON = NOW();
  SET NEW.UPDATEDBY = CURRENT_USER();  
  
  INSERT INTO LB.LogBook(ChangeDate, ChangeHour, ChangeType, Object, ChangeDescription, Username)
  VALUES(NOW(), CURRENT_TIME(), 'Update', 'VideoGame', 'Videogame data updated on database', CURRENT_USER());
END$$

/*Trigger INSERT para LB.Movie*/
CREATE TRIGGER LB.Movie_OnInsert
BEFORE INSERT ON LB.Movie
FOR EACH ROW

BEGIN
  SET NEW.createdon = NOW();
  SET NEW.CREATEDBY = CURRENT_USER(); 
  
  INSERT INTO LB.LogBook(ChangeDate, ChangeHour, ChangeType, Object, ChangeDescription, Username)
  VALUES(NOW(), CURRENT_TIME(), 'Insert', 'Movie', 'New movie inserted on database', CURRENT_USER());
END$$

/*Trigger UPDATE para LB.Movie*/
CREATE TRIGGER LB.Movie_OnUpdate
BEFORE UPDATE ON LB.Movie
FOR EACH ROW

BEGIN
  SET NEW.UPDATEDON = NOW();
  SET NEW.UPDATEDBY = CURRENT_USER();  
  
  INSERT INTO LB.LogBook(ChangeDate, ChangeHour, ChangeType, Object, ChangeDescription, Username)
  VALUES(NOW(), CURRENT_TIME(), 'Update', 'Movie', 'Movie data updated on database', CURRENT_USER());
END$$

/*Trigger INSERT para LB.Genre*/
CREATE TRIGGER LB.Genre_OnInsert
BEFORE INSERT ON LB.Genre
FOR EACH ROW

BEGIN
  SET NEW.createdon = NOW();
  SET NEW.CREATEDBY = CURRENT_USER(); 
  
  INSERT INTO LB.LogBook(ChangeDate, ChangeHour, ChangeType, Object, ChangeDescription, Username)
  VALUES(NOW(), CURRENT_TIME(), 'Insert', 'Genre', 'New genre inserted on database', CURRENT_USER());
END$$

/*Trigger UPDATE para LB.Genre*/
CREATE TRIGGER LB.Genre_OnUpdate
BEFORE UPDATE ON LB.Genre
FOR EACH ROW

BEGIN
  SET NEW.UPDATEDON = NOW();
  SET NEW.UPDATEDBY = CURRENT_USER();  
  
  INSERT INTO LB.LogBook(ChangeDate, ChangeHour, ChangeType, Object, ChangeDescription, Username)
  VALUES(NOW(), CURRENT_TIME(), 'Update', 'Genre', 'Genre updated on database', CURRENT_USER());
END$$

/*Trigger INSERT para LB.Magazine*/
CREATE TRIGGER LB.Magazine_OnInsert
BEFORE INSERT ON LB.Magazine
FOR EACH ROW

BEGIN
  SET NEW.createdon = NOW();
  SET NEW.CREATEDBY = CURRENT_USER();  
  
  INSERT INTO LB.LogBook(ChangeDate, ChangeHour, ChangeType, Object, ChangeDescription, Username)
  VALUES(NOW(), CURRENT_TIME(), 'Insert', 'Magazine', 'New magazine inserted on database', CURRENT_USER());
END$$

/*Trigger UPDATE para LB.Magazine*/
CREATE TRIGGER LB.Magazine_OnUpdate
BEFORE UPDATE ON LB.Magazine
FOR EACH ROW

BEGIN
  SET NEW.UPDATEDON = NOW();
  SET NEW.UPDATEDBY = CURRENT_USER();  
  
  INSERT INTO LB.LogBook(ChangeDate, ChangeHour, ChangeType, Object, ChangeDescription, Username)
  VALUES(NOW(), CURRENT_TIME(), 'Update', 'Magazine', 'Magazine data updated on database', CURRENT_USER());
END$$
DELIMITER ;