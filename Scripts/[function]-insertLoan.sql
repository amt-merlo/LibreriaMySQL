DELIMITER $$

CREATE FUNCTION LB.insert_loan(inIDBook INT, inIDPerson INT, inLoan_Date VARCHAR(50), inReturn_Date VARCHAR(50)) 
RETURNS INT
BEGIN 
DECLARE ID_Item INT;
  SET @ID_Item =  (SELECT ID_Item FROM LB.Book WHERE ID = inIDBook);
  return  @ID_Item;
  /*create a new loan*/
  INSERT INTO LB.Loan_Control(ID_Person, ID_Item, Loan_Date, Return_Date, Days_Amount)
  VALUES(inIDPerson, @ID_Item, str_to_date(inLoan_Date,'%d,%m,%Y'), str_to_date(inReturn_Date,'%d,%m,%Y'),1);
  RETURN 0;
END$$
select * from lb.loan_control;