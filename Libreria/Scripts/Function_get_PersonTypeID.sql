CREATE OR REPLACE FUNCTION get_PersonTypeID(inType IN NCHAR) RETURN NUMBER 
AS
  idOut NUMBER;
  
BEGIN 
        SELECT ID
        INTO idOut
        FROM LB.Person_Type
        WHERE Type = inType;
        RETURN idOut;
        
END get_PersonTypeID;

select get_PersonTypeID('Student') from dual;