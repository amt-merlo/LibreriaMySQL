CREATE OR REPLACE FUNCTION get_Books RETURN SYS_REFCURSOR 
AS
  pRecordSet SYS_REFCURSOR;
  
BEGIN 
        OPEN pRecordSet FOR
        select * from LB.Book;
        RETURN pRecordSet;
        
END get_Books;

