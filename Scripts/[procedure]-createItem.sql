DELIMITER $$

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
