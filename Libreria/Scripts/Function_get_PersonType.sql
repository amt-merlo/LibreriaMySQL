CREATE OR REPLACE FUNCTION get_PersonType RETURN SYS_REFCURSOR 
AS
  pRecordSet SYS_REFCURSOR;
  
BEGIN 
        OPEN pRecordSet FOR
        select * from LB.person_type;
        RETURN pRecordSet;
        
END get_PersonType;


--Consulta de prueba
select get_PersonType
FROM DUAL;