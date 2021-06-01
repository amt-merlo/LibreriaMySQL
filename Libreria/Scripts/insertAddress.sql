/*DOCUMENTACI�N INTERNA
Descripci�n: Procedimiento que recibe por par�metro la direcci�n que se va a almacenar en la tabla LB.Address junto con el respectivo ID de la persona a la que se asocia
Autor principal: Allison Montero
Fecha de creaci�n: 1/05/2021
*/
create or replace PROCEDURE insertAddress(inID IN NUMBER, inAddress IN VARCHAR2) AS
BEGIN
    INSERT INTO LB.Address(ID_Person, Address)
    VALUES(inID, inAddress);
    
END insertAddress;
