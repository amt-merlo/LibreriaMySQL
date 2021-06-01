CREATE OR REPLACE FUNCTION get_Loans RETURN SYS_REFCURSOR 
AS
  pRecordSet SYS_REFCURSOR;
  
BEGIN 
        OPEN pRecordSet FOR
        select * from LB.Loan_Control;
        RETURN pRecordSet;
        
END get_Loans;
