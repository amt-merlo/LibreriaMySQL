DELIMITER $$


CREATE PROCEDURE lb.get_BorrowedBooks()
MODIFIES SQL DATA
BEGIN
    SELECT LB.Book.ID, LB.Book.Title, 
           LB.Book_Clasification.Clasification, 
           LB.Book.Author, LB.Book.Edition, 
           LB.Book.CoverPage, LB.Book.PublishingHouse, 
           LB.Book.Score, LB.Loan_Control.ID_Person, LB.Loan_Control.Days_Amount
           
    FROM LB.Book
    
    
    INNER JOIN LB.Item 
    ON LB.Book.ID_Item = LB.Item.ID AND LB.Item.On_Loan = 1 
    
    INNER JOIN LB.Book_Clasification 
    ON LB.Book.ID_Clasification = LB.Book_Clasification.ID
    
    INNER JOIN LB.Loan_Control
    ON LB.Item.ID = lb.loan_control.id_item;
END$$

CREATE PROCEDURE lb.get_Loans()
MODIFIES SQL DATA
BEGIN
  SELECT * FROM LB.Loan_Control;
END$$


CREATE PROCEDURE lb.get_BorrowedBooksByID(IN inID INT)
MODIFIES SQL DATA
BEGIN
  SELECT LB.Book.ID, LB.Book.Title, 
           LB.Book_Clasification.Clasification, 
           LB.Book.Author, LB.Book.Edition, 
           LB.Book.CoverPage, LB.Book.PublishingHouse, 
           LB.Book.Score, LB.Loan_Control.ID_Person, LB.Loan_Control.Days_Amount
           
    FROM LB.Book 
    
    
    INNER JOIN LB.Item 
    ON LB.Book.ID_Item = LB.Item.ID AND LB.Item.On_Loan = 1 
    
    INNER JOIN LB.Book_Clasification 
    ON LB.Book.ID_Clasification = LB.Book_Clasification.ID
    
    INNER JOIN LB.Loan_Control
    ON LB.Item.ID = lb.loan_control.id_item
    
    INNER JOIN LB.Person
    ON LB.Person.ID_Number = inID
    
    ORDER BY LB.Book.Title;
END$$

CREATE PROCEDURE lb.get_Clasification(IN inID INT)
MODIFIES SQL DATA
BEGIN
  SELECT Clasification
  FROM LB.Book_Clasification
  WHERE ID = pID;
END$$

CREATE PROCEDURE lb.get_notBorrowed()
MODIFIES SQL DATA
BEGIN
  SELECT *     
    FROM LB.Book 
    
    INNER JOIN LB.Item 
    ON LB.Book.ID_Item = LB.Item.ID AND LB.Item.On_Loan = 0
    
    ORDER BY LB.Book.Title;
END$$

CREATE PROCEDURE lb.get_PersonType()
MODIFIES SQL DATA
BEGIN
  select * from LB.person_type;
END$$

CREATE PROCEDURE lb.get_PersonTypeID(IN inType VARCHAR(80))
MODIFIES SQL DATA
BEGIN
  SELECT ID
  FROM LB.Person_Type
  WHERE Type = inType;
END$$

CREATE PROCEDURE lb.get_ClasificationID(IN inClasification VARCHAR(80))
MODIFIES SQL DATA
BEGIN
  SELECT ID
  FROM LB.book_clasification
  WHERE Clasification = inClasification;
END$$

CREATE PROCEDURE lb.get_ItemID(IN inItem VARCHAR(80))
MODIFIES SQL DATA
BEGIN
  SELECT ID
  FROM LB.Item
  WHERE Name = inItem;
END$$