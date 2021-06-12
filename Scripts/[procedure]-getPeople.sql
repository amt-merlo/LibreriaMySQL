DELIMITER $$

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


call lb.getPeople()