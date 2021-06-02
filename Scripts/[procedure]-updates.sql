DELIMITER $$

CREATE PROCEDURE lb.update_Person(IN inID_Number INT, IN inID_PersonType INT, IN inFirstname VARCHAR(50), IN inLastname VARCHAR(50), IN inBirthdate VARCHAR(30)) 
MODIFIES SQL DATA
BEGIN
	UPDATE
            LB.Person
        SET
            ID_PersonType = inID_PersonType,
            Firstname = inFirstname,
            Lastname = inLastname,
            Birthdate = STR_TO_DATE(inBirthdate, "%Y,%m,%d")
        WHERE 
            ID_Number = inID_Number;
END$$

CREATE PROCEDURE lb.update_Book (IN inID INT, IN inID_Clasification INT, IN inTitle VARCHAR(100), IN inAuthor VARCHAR(100), IN inEDITION INT, IN inPublishingHouse VARCHAR(100), IN inScore INT)
MODIFIES SQL DATA
BEGIN
	UPDATE
            LB.Book
        SET
            ID_Clasification = inID_Clasification,
            Title = inTitle,
            Author = inAuthor,
            EDITION = inEDITION,
            PublishingHouse = inPublishingHouse,
            Score = inScore
        WHERE 
            ID = inID;
END$$

