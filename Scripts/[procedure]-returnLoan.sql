DELIMITER $$
CREATE PROCEDURE LB.ReturnBook(IN inLoanID INT, IN inItemID INT)
MODIFIES SQL DATA
proc_label: BEGIN	
	DECLARE EXIT HANDLER FOR SQLEXCEPTION
	BEGIN
        rollback;
		SELECT 1 as resultado;
	END;
    
	IF((SELECT ID FROM LB.Loan_Control WHERE ID = inLoanID) = NULL) THEN
		SELECT 2 as resultado;
        LEAVE proc_label;
	END IF;
    
		UPDATE LB.ITEM
        SET on_loan = 0
        WHERE ID = inItemID;
        SELECT 0 as resultado;
        
        UPDATE LB.Loan_Control
        SET currentlyActive = 0
        WHERE ID = inLoanID;
END$$