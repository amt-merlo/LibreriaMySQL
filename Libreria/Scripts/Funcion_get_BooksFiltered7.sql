/*DOCUMENTACI�N INTERNA
Descripci�n: Funci�n que utiliza un cursor para almacenar la consulta de libros con el filtro de autor  editorial recibido por par�metro
Autor principal: Allison Montero
Fecha de creaci�n: 9/05/2021
*/
CREATE OR REPLACE FUNCTION get_BooksFiltered7(inPHouse IN LB.Book.PublishingHouse%TYPE) RETURN SYS_REFCURSOR 
AS
  pRecordSet SYS_REFCURSOR;
  
BEGIN 
        OPEN pRecordSet FOR
        select * from LB.Book
        WHERE PublishingHouse = inPHouse;
        RETURN pRecordSet;
        
END get_BooksFiltered7;

--Consulta de prueba
select get_BooksFiltered7('Suma Editorial')
FROM DUAL;