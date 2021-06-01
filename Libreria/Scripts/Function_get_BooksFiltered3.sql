/*DOCUMENTACI�N INTERNA
Descripci�n: Funci�n que utiliza un cursor para almacenar la consulta de libros con el filtro de t�tulo y editorial recibidos por par�metro
Autor principal: Allison Montero
Fecha de creaci�n: 9/05/2021
*/
CREATE OR REPLACE FUNCTION get_BooksFiltered3(inTitle IN LB.Book.Title%TYPE, inPHouse IN LB.Book.PublishingHouse%TYPE) RETURN SYS_REFCURSOR 
AS
  pRecordSet SYS_REFCURSOR;
  
BEGIN 
        OPEN pRecordSet FOR
        select * from LB.Book
        WHERE title = inTitle AND PublishingHouse = inPHouse;
        RETURN pRecordSet;
        
END get_BooksFiltered3;

--Consulta de prueba
select get_BooksFiltered3('El Resplandor', 'Suma Editorial')
FROM DUAL;