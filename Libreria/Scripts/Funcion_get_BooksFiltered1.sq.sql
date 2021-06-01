/*DOCUMENTACIÓN INTERNA
Descripción: Función que utiliza un cursor para almacenar la consulta de libros con el filtro de autor, título y editorial recibidos por parámetro
Autor principal: Allison Montero
Fecha de creación: 7/05/2021
*/
CREATE OR REPLACE FUNCTION get_BooksFiltered1(inTitle IN LB.Book.Title%TYPE, inAuthor IN LB.Book.Author%TYPE, inPHouse IN LB.Book.PublishingHouse%TYPE) RETURN SYS_REFCURSOR 
AS
  pRecordSet SYS_REFCURSOR;
  
BEGIN 
        OPEN pRecordSet FOR
        select * from LB.Book
        WHERE title = inTitle AND author = inAuthor AND PublishingHouse = inPHouse;
        RETURN pRecordSet;
        
END get_BooksFiltered1;


--Consulta de prueba
select get_BooksFiltered1('El Resplandor', 'Stephen King', 'Suma Editorial')
FROM DUAL;

