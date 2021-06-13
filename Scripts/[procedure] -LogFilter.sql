
/*
CREATE PROCEDURE LB.LogBookFiltered(IN inType VARCHAR(100), IN inObject VARCHAR(100), IN inUser VARCHAR(100))
MODIFIES SQL DATA
BEGIN
	DECLARE EXIT HANDLER FOR SQLEXCEPTION
	BEGIN
		ROLLBACK;
		SELECT 'An error has occurred, operation rollbacked and the stored procedure was terminated';
	END;

	IF (char_length(inType)>0 AND char_length(inObject)>0 AND char_length(inUser)>0) THEN
		SELECT * FROM LB.LogBook
        WHERE ChangeType = inType AND Object = inObject AND Username = inUser;
	
    
    ELSEIF (char_length(inType)>0 AND char_length(inObject)>0 AND char_length(inUser)<1) THEN
			SELECT * FROM LB.LogBook
            WHERE ChangeType = inType AND Object = inObject;
            
	ELSEIF (char_length(inType)>0 AND char_length(inObject)<1 AND char_length(inUser)>0) THEN
			SELECT * FROM LB.LogBook
            WHERE ChangeType = inType AND Username = inUser;
            
	ELSEIF(char_length(inType)<1 AND char_length(inObject)>0 AND char_length(inUser)>0) THEN
			SELECT * FROM LB.LogBook
            WHERE Object = inObject AND Username = inUser;
	
    ELSEIF(char_length(inType)>0 AND char_length(inObject)<1 AND char_length(inUser)<1) THEN
			SELECT * FROM LB.LogBook
            WHERE ChangeType = inType;
            
	ELSEIF(char_length(inType)<1 AND char_length(inObject)>0 AND char_length(inUser)<1) THEN
			SELECT * FROM LB.LogBook
            WHERE Object = inObject;
	ELSEIF(char_length(inType)<1 AND char_length(inObject)<1 AND char_length(inUser)>0) THEN
			SELECT * FROM LB.LogBook
            WHERE Username = inUser;
	END IF;
END$$
*/

/*
Description: Procedure that get data from the logbook 
Author: Allison M. Merlo
Creation Date: 2/06/2021
*/
DELIMITER $$
CREATE PROCEDURE LB.LogBookFiltered(IN inType VARCHAR(100), IN inObject VARCHAR(100), IN inUser VARCHAR(100), IN inHour1 VARCHAR(40), inHour2 VARCHAR(40), IN inDate1 VARCHAR(40), IN inDate2 VARCHAR(40))
MODIFIES SQL DATA
BEGIN

	DECLARE EXIT HANDLER FOR SQLEXCEPTION
	BEGIN
		ROLLBACK;
		SELECT 'An error has occurred, operation rollbacked and the stored procedure was terminated';
	END;
    
	IF (char_length(inDate1)>0 AND char_length(inDate2)>0 AND char_length(inHour1)>0 AND char_length(inHour2)>0) THEN
    
		/*Comparamos el resto de campos*/
		IF (char_length(inType)>0 AND char_length(inObject)>0 AND char_length(inUser)>0) THEN
				SELECT * FROM LB.LogBook
				WHERE ChangeType = inType AND Object = inObject AND Username = inUser
				AND ChangeDate BETWEEN CAST(inDate1 AS DATE) AND CAST(inDate2 AS DATE)
				AND ChangeHour BETWEEN inHour1 AND inHour2;
	
    
		ELSEIF (char_length(inType)>0 AND char_length(inObject)>0 AND char_length(inUser)<1) THEN
				SELECT * FROM LB.LogBook
				WHERE ChangeType = inType AND Object = inObject
                AND ChangeDate BETWEEN CAST(inDate1 AS DATE) AND CAST(inDate2 AS DATE)
				AND ChangeHour BETWEEN inHour1 AND inHour2;
            
		ELSEIF (char_length(inType)>0 AND char_length(inObject)<1 AND char_length(inUser)>0) THEN
				SELECT * FROM LB.LogBook
				WHERE ChangeType = inType AND Username = inUser
                AND ChangeDate BETWEEN CAST(inDate1 AS DATE) AND CAST(inDate2 AS DATE)
				AND ChangeHour BETWEEN inHour1 AND inHour2;
				
		ELSEIF(char_length(inType)<1 AND char_length(inObject)>0 AND char_length(inUser)>0) THEN
				SELECT * FROM LB.LogBook
				WHERE Object = inObject AND Username = inUser
                AND ChangeDate BETWEEN CAST(inDate1 AS DATE) AND CAST(inDate2 AS DATE)
				AND ChangeHour BETWEEN inHour1 AND inHour2;
		
		ELSEIF(char_length(inType)>0 AND char_length(inObject)<1 AND char_length(inUser)<1) THEN
				SELECT * FROM LB.LogBook
				WHERE ChangeType = inType
                AND ChangeDate BETWEEN CAST(inDate1 AS DATE) AND CAST(inDate2 AS DATE)
				AND ChangeHour BETWEEN inHour1 AND inHour2;
				
		ELSEIF(char_length(inType)<1 AND char_length(inObject)>0 AND char_length(inUser)<1) THEN
				SELECT * FROM LB.LogBook
				WHERE Object = inObject
                AND ChangeDate BETWEEN CAST(inDate1 AS DATE) AND CAST(inDate2 AS DATE)
				AND ChangeHour BETWEEN inHour1 AND inHour2;
                
		ELSEIF(char_length(inType)<1 AND char_length(inObject)<1 AND char_length(inUser)>0) THEN
				SELECT * FROM LB.LogBook
				WHERE Username = inUser
                AND ChangeDate BETWEEN CAST(inDate1 AS DATE) AND CAST(inDate2 AS DATE)
				AND ChangeHour BETWEEN inHour1 AND inHour2;
		END IF;
        
	/*Cuando solo tenemos fecha*/
    ELSEIF (char_length(inDate1)>0 AND char_length(inDate2)>0 AND char_length(inHour1)<1 AND char_length(inHour2)<1) THEN
			IF (char_length(inType)>0 AND char_length(inObject)>0 AND char_length(inUser)>0) THEN
				SELECT * FROM LB.LogBook
				WHERE ChangeType = inType AND Object = inObject AND Username = inUser
                AND ChangeDate BETWEEN CAST(inDate1 AS DATE) AND CAST(inDate2 AS DATE);
	
    
		ELSEIF (char_length(inType)>0 AND char_length(inObject)>0 AND char_length(inUser)<1) THEN
				SELECT * FROM LB.LogBook
				WHERE ChangeType = inType AND Object = inObject
                AND ChangeDate BETWEEN CAST(inDate1 AS DATE) AND CAST(inDate2 AS DATE);
            
		ELSEIF (char_length(inType)>0 AND char_length(inObject)<1 AND char_length(inUser)>0) THEN
				SELECT * FROM LB.LogBook
				WHERE ChangeType = inType AND Username = inUser
                AND ChangeDate BETWEEN CAST(inDate1 AS DATE) AND CAST(inDate2 AS DATE);
				
		ELSEIF(char_length(inType)<1 AND char_length(inObject)>0 AND char_length(inUser)>0) THEN
				SELECT * FROM LB.LogBook
				WHERE Object = inObject AND Username = inUser
                AND ChangeDate BETWEEN CAST(inDate1 AS DATE) AND CAST(inDate2 AS DATE);
		
		ELSEIF(char_length(inType)>0 AND char_length(inObject)<1 AND char_length(inUser)<1) THEN
				SELECT * FROM LB.LogBook
				WHERE ChangeType = inType
                AND ChangeDate BETWEEN CAST(inDate1 AS DATE) AND CAST(inDate2 AS DATE);
				
		ELSEIF(char_length(inType)<1 AND char_length(inObject)>0 AND char_length(inUser)<1) THEN
				SELECT * FROM LB.LogBook
				WHERE Object = inObject
                AND ChangeDate BETWEEN CAST(inDate1 AS DATE) AND CAST(inDate2 AS DATE);
                
		ELSEIF(char_length(inType)<1 AND char_length(inObject)<1 AND char_length(inUser)>0) THEN
				SELECT * FROM LB.LogBook
				WHERE Username = inUser
                AND ChangeDate BETWEEN CAST(inDate1 AS DATE) AND CAST(inDate2 AS DATE);
		END IF;
        
	/*Cuando solo tenemos hora*/
    ELSEIF (char_length(inDate1)<1 AND char_length(inDate2)<1 AND char_length(inHour1)>0 AND char_length(inHour2)>0) THEN
			IF (char_length(inType)>0 AND char_length(inObject)>0 AND char_length(inUser)>0) THEN
				SELECT * FROM LB.LogBook
				WHERE ChangeType = inType AND Object = inObject AND Username = inUser
                AND ChangeHour BETWEEN inHour1 AND inHour2;
	
    
		ELSEIF (char_length(inType)>0 AND char_length(inObject)>0 AND char_length(inUser)<1) THEN
				SELECT * FROM LB.LogBook
				WHERE ChangeType = inType AND Object = inObject
                AND ChangeHour BETWEEN inHour1 AND inHour2;
            
		ELSEIF (char_length(inType)>0 AND char_length(inObject)<1 AND char_length(inUser)>0) THEN
				SELECT * FROM LB.LogBook
				WHERE ChangeType = inType AND Username = inUser
                AND ChangeHour BETWEEN inHour1 AND inHour2;
				
		ELSEIF(char_length(inType)<1 AND char_length(inObject)>0 AND char_length(inUser)>0) THEN
				SELECT * FROM LB.LogBook
				WHERE Object = inObject AND Username = inUser
                AND ChangeHour BETWEEN inHour1 AND inHour2;
		
		ELSEIF(char_length(inType)>0 AND char_length(inObject)<1 AND char_length(inUser)<1) THEN
				SELECT * FROM LB.LogBook
				WHERE ChangeType = inType
                AND ChangeHour BETWEEN inHour1 AND inHour2;
				
		ELSEIF(char_length(inType)<1 AND char_length(inObject)>0 AND char_length(inUser)<1) THEN
				SELECT * FROM LB.LogBook
				WHERE Object = inObject
                AND ChangeHour BETWEEN inHour1 AND inHour2;
                
		ELSEIF(char_length(inType)<1 AND char_length(inObject)<1 AND char_length(inUser)>0) THEN
				SELECT * FROM LB.LogBook
				WHERE Username = inUser
                AND ChangeHour BETWEEN inHour1 AND inHour2;
		END IF;
        
	ELSEIF(char_length(inDate1)<1 AND char_length(inDate2)<1 AND char_length(inHour1)<1 AND char_length(inHour2)<1) THEN
			IF (char_length(inType)>0 AND char_length(inObject)>0 AND char_length(inUser)>0) THEN
				SELECT * FROM LB.LogBook
				WHERE ChangeType = inType AND Object = inObject AND Username = inUser;
	
    
			ELSEIF (char_length(inType)>0 AND char_length(inObject)>0 AND char_length(inUser)<1) THEN
					SELECT * FROM LB.LogBook
					WHERE ChangeType = inType AND Object = inObject;
					
			ELSEIF (char_length(inType)>0 AND char_length(inObject)<1 AND char_length(inUser)>0) THEN
					SELECT * FROM LB.LogBook
					WHERE ChangeType = inType AND Username = inUser;
					
			ELSEIF(char_length(inType)<1 AND char_length(inObject)>0 AND char_length(inUser)>0) THEN
					SELECT * FROM LB.LogBook
					WHERE Object = inObject AND Username = inUser;
			
			ELSEIF(char_length(inType)>0 AND char_length(inObject)<1 AND char_length(inUser)<1) THEN
					SELECT * FROM LB.LogBook
					WHERE ChangeType = inType;
					
			ELSEIF(char_length(inType)<1 AND char_length(inObject)>0 AND char_length(inUser)<1) THEN
					SELECT * FROM LB.LogBook
					WHERE Object = inObject;
			ELSEIF(char_length(inType)<1 AND char_length(inObject)<1 AND char_length(inUser)>0) THEN
					SELECT * FROM LB.LogBook
					WHERE Username = inUser;
			END IF;
    END IF;
END$$
    