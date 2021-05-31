DELIMITER $$

CREATE PROCEDURE lb.createItem(IN inName varchar(100)) 
MODIFIES SQL DATA
BEGIN
  INSERT INTO LB.Item(name, description, on_loan)
  VALUES(inName, 'Item del libro', 0);
END$$
