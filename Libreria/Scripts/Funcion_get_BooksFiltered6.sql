/*DOCUMENTACI�N INTERNA
Descripci�n: Funci�n que utiliza un cursor para almacenar la consulta de libros con el filtro de autor recibido por par�metro
Autor principal: Allison Montero
Fecha de creaci�n: 9/05/2021
*/
CREATE OR REPLACE FUNCTION get_BooksFiltered6(inAuthor IN LB.Book.author%TYPE) RETURN SYS_REFCURSOR 
AS
  pRecordSet SYS_REFCURSOR;
  
BEGIN 
        OPEN pRecordSet FOR
        select * from LB.Book
        WHERE author = inAuthor;
        RETURN pRecordSet;
        
END get_BooksFiltered6;

--Consulta de prueba
select get_BooksFiltered6('Stephen King')
FROM DUAL;