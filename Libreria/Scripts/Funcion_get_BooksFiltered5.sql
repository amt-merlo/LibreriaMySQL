/*DOCUMENTACIÓN INTERNA
Descripción: Función que utiliza un cursor para almacenar la consulta de libros con el filtro de título recibido por parámetro
Autor principal: Allison Montero
Fecha de creación: 9/05/2021
*/
CREATE OR REPLACE FUNCTION get_BooksFiltered5(inTitle IN LB.Book.Title%TYPE) RETURN SYS_REFCURSOR 
AS
  pRecordSet SYS_REFCURSOR;
  
BEGIN 
        OPEN pRecordSet FOR
        select * from LB.Book
        WHERE title = inTitle;
        RETURN pRecordSet;
        
END get_BooksFiltered5;

--Consulta de prueba
select get_BooksFiltered5('El Resplandor')
FROM DUAL;