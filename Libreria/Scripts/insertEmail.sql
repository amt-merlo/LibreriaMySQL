/*DOCUMENTACI�N INTERNA
Descripci�n: Procedimiento que recibe por par�metro unn email para insertarlo en la tabla LB.Email junto con el ID de la persona a la que se asocia
Autor principal: Allison Montero
Fecha de creaci�n: 1/05/2021
*/
create or replace PROCEDURE insertEmail(inPersonID IN NUMBER, inEmail IN VARCHAR2) AS
BEGIN
    INSERT INTO LB.Email(ID_Person, Email)
    VALUES(inPersonID, inEmail);
END insertEmail;


