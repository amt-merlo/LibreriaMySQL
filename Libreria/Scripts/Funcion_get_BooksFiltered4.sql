/*DOCUMENTACIÓN INTERNA
Descripción: Función que utiliza un cursor para almacenar la consulta de libros con el filtro de autor y editorial recibidos por parámetro
Autor principal: Allison Montero
Fecha de creación: 9/05/2021
*/
CREATE OR REPLACE FUNCTION get_BooksFiltered4(inAuthor IN LB.Book.Author%TYPE, inPHouse IN LB.Book.PublishingHouse%TYPE) RETURN SYS_REFCURSOR 
AS
  pRecordSet SYS_REFCURSOR;
  
BEGIN 
        OPEN pRecordSet FOR
        select * from LB.Book
        WHERE author = inAuthor AND PublishingHouse = inPHouse;
        RETURN pRecordSet;
        
END get_BooksFiltered4;

--Consulta de prueba
select get_BooksFiltered4('Stephen King', 'Suma Editorial')
FROM DUAL;