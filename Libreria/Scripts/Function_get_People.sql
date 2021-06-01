CREATE OR REPLACE FUNCTION get_People RETURN SYS_REFCURSOR 
AS
  pRecordSet SYS_REFCURSOR;
  
BEGIN 
        OPEN pRecordSet FOR
        select * from LB.Person;
        RETURN pRecordSet;
        
END get_People;

CREATE OR REPLACE FUNCTION get_PersonTypeByID(pID IN NUMBER) RETURN VARCHAR2 
AS
  typeOut VARCHAR2(30);
  
BEGIN 
        SELECT Type
        INTO typeOut
        FROM LB.Person_Type
        WHERE ID = pID;
        RETURN typeOut;
        
END get_PersonTypeByID;

select get_PersonTypeByID(1) from dual;
