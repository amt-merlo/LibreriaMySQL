CREATE OR REPLACE FUNCTION get_Clasification(pID IN NUMBER) RETURN VARCHAR2 
AS
  clasificationOut VARCHAR2(30);
  
BEGIN 
        SELECT Clasification
        INTO clasificationOut
        FROM LB.Book_Clasification
        WHERE ID = pID;
        RETURN clasificationout;
        
END get_Clasification;

select get_Clasification(1) from dual;