DELIMITER $$

CREATE PROCEDURE lb.getPeople()
MODIFIES SQL DATA
BEGIN
  SELECT * FROM lb.person;
END$$


call lb.getPeople()