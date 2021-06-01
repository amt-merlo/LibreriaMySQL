--Consulta 1 libros por orden alfabético
SELECT * FROM LB.Item ORDER BY name ASC;
--Cantidad
SELECT COUNT(*) FROM LB.Item ORDER BY name ASC;

--Consulta 1 libros por orden alfabético, con filtro de título
SELECT * FROM LB.Book WHERE title = 'Orgullo y Prejuicio' ORDER BY name ASC;
--Cantidad
SELECT COUNT(*) FROM LB.Book WHERE title = 'Orgullo y Prejuicio' ORDER BY name ASC;

--Consulta 1 libros por orden alfabético, con filtro de autor
SELECT * FROM LB.Book WHERE author = 'Orgullo y Prejuicio' ORDER BY name ASC;
--Cantidad
SELECT COUNT(*) FROM LB.Book WHERE author = 'Orgullo y Prejuicio' ORDER BY name ASC;

--Consulta 1 libros por orden alfabético, con filtro de Editorial
SELECT * FROM LB.Book WHERE publishinghouse = 'Orgullo y Prejuicio' ORDER BY name ASC;
--Cantidad
SELECT COUNT(*) FROM LB.Book WHERE publishinghouse = 'Orgullo y Prejuicio' ORDER BY name ASC;

