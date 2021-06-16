DELIMITER $$
CREATE PROCEDURE LB.insertLoan(IN inID_Person INT, IN inID_Book INT, IN inLoanDate VARCHAR(40), IN inReturnDate VARCHAR(40))
MODIFIES SQL DATA
proc_label: BEGIN	
	/*Try in case of sql error*/
	DECLARE EXIT HANDLER FOR SQLEXCEPTION
	BEGIN
        rollback;
		SELECT 1 as resultado;
	END;
    /*get the item id*/
    SET @ID_Item1 = NULL;
	SET @ID_Item1 = (SELECT ID_Item FROM LB.BOOK WHERE ID = inID_Book);
    
    /*Check if the book is already on loan*/
    IF ((SELECT on_Loan FROM LB.Item WHERE ID = @ID_Item1) = 1) THEN
     SELECT 2 as resultado;
     LEAVE proc_label;
	END IF;
    
    /*Insert in the table*/
    INSERT INTO LB.Loan_Control(ID_Person, ID_Item, Loan_Date, Return_Date, Days_Amount, currentlyActive)
    VALUES(inID_Person, @ID_Item1, STR_TO_DATE(inLoanDate, '%d,%m,%Y'), STR_TO_DATE(inReturnDate, '%d,%m,%Y'), 1, 1);
    
    /*updates the item to be on loan*/
    UPDATE LB.Item
    SET on_Loan = 1
    WHERE ID = @ID_Item1;
    SELECT 0 as resultado;
END$$

DELIMITER $$
CREATE PROCEDURE LB.insertLoanFinal(IN inID_Person INT, IN inID_Book INT, IN inLoanDate VARCHAR(40), IN inReturnDate VARCHAR(40))
MODIFIES SQL DATA
BEGIN
  CALL LB.insertLoan(inID_Person, inID_Book, inLoanDate, inReturnDate);
END $$
	