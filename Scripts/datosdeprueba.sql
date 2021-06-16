/*Libros de Ghostgirl*/
INSERT INTO LB.Item(Name, Description, on_loan)
VALUES("Item de Ghostgirl", "Libro 1 se la saga Ghostgirl", 0);

INSERT INTO LB.Book(ID_Clasification, ID_Item, Title, Author, EDITION, CoverPage, PublishingHouse, Score)
VALUES(6, 1, "Ghostgirl", "Tonya Hurley", 3, "C:\\Users\\Allison\\Desktop\\Portadas\\ghostgirl1.jpg", "Alfaguara", 8);

INSERT INTO LB.Item(Name, Description, on_loan)
VALUES("Item de Ghostgirl The Return", "Libro 2 se la saga Ghostgirl", 0);

INSERT INTO LB.Book(ID_Clasification, ID_Item, Title, Author, EDITION, CoverPage, PublishingHouse, Score)
VALUES(6, 2, "Ghostgirl The Return", "Tonya Hurley", 3, "C:\\Users\\Allison\\Desktop\\Portadas\\ghostgirl2.jpg", "Alfaguara", 8);

INSERT INTO LB.Item(Name, Description, on_loan)
VALUES("Item de Ghostgirl", "Libro 3 se la saga Ghostgirl", 0);

INSERT INTO LB.Book(ID_Clasification, ID_Item, Title, Author, EDITION, CoverPage, PublishingHouse, Score)
VALUES(6, 3, "Ghostgirl Lovesick", "Tonya Hurley", 3, "C:\\Users\\Allison\\Desktop\\Portadas\\ghostgirl3.jpg", "Alfaguara", 8);

/*Libros de Javier Castillo*/
INSERT INTO LB.Item(Name, Description, on_loan)
VALUES("Item de El dia que se perdio la cordura", "Libro 1 Javier Castillo", 0);

INSERT INTO LB.Book(ID_Clasification, ID_Item, Title, Author, EDITION, CoverPage, PublishingHouse, Score)
VALUES(5, 4, "El dia que se perdio la cordura", "Javier Castillo", 7, "C:\\Users\\Allison\\Desktop\\Portadas\\eldiaqueseperdiolacordura.jpg", "Suma de Letras", 9);

INSERT INTO LB.Item(Name, Description, on_loan)
VALUES("Item de El dia que se perdio el amor", "Libro 2 Javier Castillo", 0);

INSERT INTO LB.Book(ID_Clasification, ID_Item, Title, Author, EDITION, CoverPage, PublishingHouse, Score)
VALUES(5, 5, "El dia que se perdio el amor", "Javier Castillo", 7, "C:\\Users\\Allison\\Desktop\\Portadas\\eldiaqueseperdioelamor.jpg", "Suma de Letras", 9);

INSERT INTO LB.Item(Name, Description, on_loan)
VALUES("Item de Todo lo que sucedio con Miranda Huff", "Libro 3 Javier Castillo", 0);

INSERT INTO LB.Book(ID_Clasification, ID_Item, Title, Author, EDITION, CoverPage, PublishingHouse, Score)
VALUES(5, 6, "Todo lo que sucedio con Miranda Huff", "Javier Castillo", 4, "C:\\Users\\Allison\\Desktop\\Portadas\\todoloquesucedioconmirandahuff.jpg", "Suma de Letras", 9);

INSERT INTO LB.Item(Name, Description, on_loan)
VALUES("Item de La chica de nieve", "Libro 4 Javier Castillo", 0);

INSERT INTO LB.Book(ID_Clasification, ID_Item, Title, Author, EDITION, CoverPage, PublishingHouse, Score)
VALUES(5, 7, "La chica de nieve", "Javier Castillo", 3, "C:\\Users\\Allison\\Desktop\\Portadas\\lachicadenieve.jpg", "Suma de Letras", 9);

INSERT INTO LB.Item(Name, Description, on_loan)
VALUES("Item de El juego del alma", "Libro 5 Javier Castillo", 0);

INSERT INTO LB.Book(ID_Clasification, ID_Item, Title, Author, EDITION, CoverPage, PublishingHouse, Score)
VALUES(5, 8, "El juego del alma", "Javier Castillo", 2, "C:\\Users\\Allison\\Desktop\\Portadas\\eljuegodelalma.jpg", "Suma de Letras", 9);

/*Personas*/
select LB.insertPerson(305250055, 2, "Allison", "M Merlo", "18,05,2000");
select LB.insertPerson(110520078, 3, "Farid", "Montero", "11,07,2002");

/*Prestar los de Ghostgirl*/
INSERT INTO LB.Loan_Control(ID_Person, ID_Item, Loan_Date, Return_Date, Days_Amount)
VALUES(305250055, 1, str_to_date("05,01,2020", '%d,%m,%Y'), str_to_date("05,01,2021", '%d,%m,%Y'), 365);

UPDATE LB.Item
SET on_loan = 1
WHERE ID = 1;

INSERT INTO LB.Loan_Control(ID_Person, ID_Item, Loan_Date, Return_Date, Days_Amount)
VALUES(305250055, 2, str_to_date("05,01,2020", '%d,%m,%Y'), str_to_date("05,01,2021", '%d,%m,%Y'), 365);

UPDATE LB.Item
SET on_loan = 1
WHERE ID = 2;

/*Prestar 1 de Javi*/
INSERT INTO LB.Loan_Control(ID_Person, ID_Item, Loan_Date, Return_Date, Days_Amount)
VALUES(110520078, 4, str_to_date("24,12,2020", '%d,%m,%Y'), str_to_date("05,01,2021", '%d,%m,%Y'), 13);

UPDATE LB.Item
SET on_loan = 1
WHERE ID = 4;
select * from lb.book;


insert into lb.users(Username, pass)
values("alita12", "123"); 