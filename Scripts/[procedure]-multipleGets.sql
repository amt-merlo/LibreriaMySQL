DELIMITER $$

/*
Description: Procedure that get data of the books that are borrowed to show on the app.
Author: Allison M. Merlo
Creation Date: 2/06/2021
*/
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

/*
Description: Procedure that get data of the loans registered to show on the app.
Author: Allison M. Merlo
Creation Date: 2/06/2021
*/
CREATE PROCEDURE lb.get_Loans()
MODIFIES SQL DATA
BEGIN
  SELECT * FROM LB.Loan_Control;
END$$

/*
Description: Procedure that get data of the books that are borrowed by someone in particular identified by the id to show on the app.
Author: Allison M. Merlo
Creation Date: 2/06/2021
*/
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

/*
Description: Procedure that get the clasification of a book by the id.
Author: Allison M. Merlo
Creation Date: 2/06/2021
*/
CREATE PROCEDURE lb.get_Clasification(IN inID INT)
MODIFIES SQL DATA
BEGIN
  SELECT Clasification
  FROM LB.Book_Clasification
  WHERE ID = inID;
END$$

/*
Description: Procedure that get data of the non borrowed books to show on the app
Author: Allison M. Merlo
Creation Date: 2/06/2021
*/
CREATE PROCEDURE lb.get_notBorrowed()
MODIFIES SQL DATA
BEGIN
  SELECT *     
    FROM LB.Book 
    
    INNER JOIN LB.Item 
    ON LB.Book.ID_Item = LB.Item.ID AND LB.Item.On_Loan = 0
    
    ORDER BY LB.Book.Title;
END$$

/*
Description: Procedure that get the person types to show on the app
Author: Allison M. Merlo
Creation Date: 2/06/2021
*/
CREATE PROCEDURE lb.get_PersonType()
MODIFIES SQL DATA
BEGIN
  select * from LB.person_type;
END$$

/*
Description: Procedure that get the person type identified by the id to show on the app
Author: Allison M. Merlo
Creation Date: 2/06/2021
*/
CREATE PROCEDURE lb.get_PersonTypeID(IN inType VARCHAR(80))
MODIFIES SQL DATA
BEGIN
  SELECT ID
  FROM LB.Person_Type
  WHERE Type = inType;
END$$

/*
Description: Procedure that get the clasification id of a book identified by the clasification, to show on the app
Author: Allison M. Merlo
Creation Date: 2/06/2021
*/
CREATE PROCEDURE lb.get_ClasificationID(IN inClasification VARCHAR(80))
MODIFIES SQL DATA
BEGIN
  SELECT ID
  FROM LB.book_clasification
  WHERE Clasification = inClasification;
END$$

/*
Description: Procedure that get the Item ID identified by the name of the item, to show on the app
Author: Gabriela Gutiérrez
Creation Date: 2/06/2021
*/
CREATE PROCEDURE lb.get_ItemID(IN inItem VARCHAR(80))
MODIFIES SQL DATA
BEGIN
  SELECT ID
  FROM LB.Item
  WHERE Name = inItem;
END$$

/*
Description: Procedure that get all the clasifications to show on the app
Author: Allison M. Merlo
Creation Date: 2/06/2021
*/
CREATE PROCEDURE lb.get_BookClasifications()
MODIFIES SQL DATA
BEGIN
  select Clasification from LB.book_clasification;
END$$

DELIMITER $$

/*
Description: Procedure that get the person type identified by the id, to show on the app
Author: Allison M. Merlo
Creation Date: 2/06/2021
*/
CREATE PROCEDURE lb.get_PersonTypeByID(IN inID INT)
MODIFIES SQL DATA
BEGIN
  SELECT Type 
  FROM LB.person_type 
  WHERE ID = inID;
END$$

/*
Description: Procedure that get coverpage of a book identified by id, to show on the app
Author: Allison M. Merlo
Creation Date: 2/06/2021
*/

CREATE PROCEDURE lb.get_BookCoverPage(IN inID INT)
MODIFIES SQL DATA
BEGIN
  SELECT CoverPage 
  FROM LB.Book
  WHERE ID = inID;
END$$

/*
Description: Procedure that get the logbook data, to show on the app
Author: Allison M. Merlo
Creation Date: 2/06/2021
*/
CREATE PROCEDURE lb.get_logbook()
MODIFIES SQL DATA
BEGIN
	SELECT * FROM LB.LogBook;
END$$

/*
Description: Procedure that get amount of books per clasification
Author: Allison M. Merlo
Creation Date: 2/06/2021
*/
CREATE PROCEDURE lb.get_ClasificationCantidades()
MODIFIES SQL DATA
BEGIN
  /*Definimos las variables del while*/ 
	SET @cantCategorias = NULL;
    SET @contador = NULL;
	SELECT @cantCategorias; SET @cantCategorias = (SELECT COUNT(*) FROM LB.Book_Clasification);
	SELECT @contador; SET @contador = 1;
    
  /*Definimos la tabla temporal*/
  DROP TABLE IF EXISTS LB.cantxClasificacion;
  CREATE TABLE LB.cantxClasificacion(ID INT PRIMARY KEY, CANT INT);
  
    WHILE @contador <= @cantCategorias DO
        SELECT @cant; SET @cant = (SELECT COUNT(*) FROM LB.Book WHERE ID_Clasification = @contador );
        
        INSERT INTO LB.cantxClasificacion(ID, CANT)
        VALUES(@contador, @cant);
        SET @contador = @contador + 1;
    END WHILE;
    SELECT * FROM LB.cantxClasificacion;
END$$

/*
Description: Procedure that calls the LB.cantxclasificacion; procedure 
Author: Allison M. Merlo
Creation Date: 2/06/2021
*/
CREATE PROCEDURE LB.get_CCFinal()
MODIFIES SQL DATA
BEGIN
	SELECT * FROM LB.cantxclasificacion;
END$$

/*
Description: Procedure that get amount of borrowed books per clasification
Author: Allison M. Merlo
Creation Date: 2/06/2021
*/
CREATE PROCEDURE lb.get_ClasificationCantidadesPrestados()
MODIFIES SQL DATA
BEGIN
  /*Definimos las variables del while*/ 
	SET @cantCategorias = NULL;
    SET @contador = NULL;
	SELECT @cantCategorias; SET @cantCategorias = (SELECT COUNT(*) FROM LB.Book_Clasification);
	SELECT @contador; SET @contador = 1;
    
  /*Definimos la tabla temporal*/
  DROP TABLE IF EXISTS LB.cantxClasificacionPrestados;
  CREATE TABLE LB.cantxClasificacionPrestados(ID INT PRIMARY KEY, CANT INT);
  
    WHILE @contador <= @cantCategorias DO
        SELECT @cant; SET @cant = (SELECT COUNT(*) FROM LB.Book INNER JOIN LB.Item 
    ON LB.Book.ID_Item = LB.Item.ID AND LB.Item.On_Loan = 1  WHERE ID_Clasification = @contador);
        
        INSERT INTO LB.cantxClasificacionPrestados(ID, CANT)
        VALUES(@contador, @cant);
        SET @contador = @contador + 1;
    END WHILE;
    SELECT * FROM LB.cantxClasificacionPrestados;
END$$

CREATE PROCEDURE LB.get_CCFinalPrestados()
MODIFIES SQL DATA
BEGIN
	SELECT * FROM LB.cantxClasificacionPrestados;
END$$

/*
Description: Procedure that get the top 10 of the most borrowed books
Author: Allison M. Merlo
Creation Date: 2/06/2021
*/
CREATE PROCEDURE LB.get_Top10()
MODIFIES SQL DATA 
BEGIN 
	select LB.Book.id, count(LB.Loan_Control.id_item) as cant, LB.Book.Title
	from lb.loan_control

	INNER JOIN LB.BOOK ON LB.Loan_control.ID_Item = LB.Book.ID_Item
	group by ID_Person
	order by 2 desc;
END$$

/*
Description: Procedure that get data from the table person
Author: Allison M. Merlo
Creation Date: 2/06/2021
*/
CREATE PROCEDURE lb.getPeople()
MODIFIES SQL DATA
BEGIN
  DECLARE EXIT HANDLER FOR SQLEXCEPTION
	BEGIN
		ROLLBACK;
		SELECT 'An error has occurred, operation rollbacked and the stored procedure was terminated';
	END;
    
  SELECT * FROM lb.person;
END$$
