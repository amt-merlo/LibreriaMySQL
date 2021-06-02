DELIMITER $$

CREATE FUNCTION LB.userValidation(inUsername VARCHAR(100), inPassword VARCHAR(100))
  RETURNS INT
  BEGIN

    IF EXISTS(select * from lb.users where username = inUsername and pass = inPassword) 
		THEN RETURN 1;
    ELSE 
		RETURN 0;
    END IF;
  END $$
  
  /*Correr esto solo si da error codigo 1418*/
SET GLOBAL log_bin_trust_function_creators = 1;