/*DOCUMENTACI�N INTERNA
Descripci�n: Funci�n que utiliza un cursor para almacenar la consulta de libros con el filtro de autor y t�tulo recibidos por par�metro
Autor principal: Allison Montero
Fecha de creaci�n: 9/05/2021
*/
CREATE OR REPLACE FUNCTION get_BooksFiltered2(inTitle IN LB.Book.Title%TYPE, inAuthor IN LB.Book.Author%TYPE) RETURN SYS_REFCURSOR 
AS
  pRecordSet SYS_REFCURSOR;
  
BEGIN 
        OPEN pRecordSet FOR
        select * from LB.Book
        WHERE title = inTitle AND author = inAuthor;
        RETURN pRecordSet;
        
END get_BooksFiltered2;

--Consulta de prueba
select get_BooksFiltered2('El Resplandor', 'Stephen King')
FROM DUAL;