



INSERT INTO LB.ITEM(name, description, on_loan)
VALUES('El Resplandor', 'El mejor libro de la historia', 1);

INSERT INTO LB.BOOK(ID_Clasification, ID_Item, Title, Author, Edition, PublishingHouse, Score)
VALUES(9, 1, 'El Resplandor', 'Stephen King', 9, 'Suma Editorial', 9);


INSERT INTO LB.ITEM(name, description, on_loan)
VALUES('Dr. Sueño', 'El mejor libro de la historia 2', 0);

INSERT INTO LB.BOOK(ID_Clasification, ID_Item, Title, Author, Edition, PublishingHouse, Score)
VALUES(9, 2, 'Dr. Sueño', 'Stephen King', 12, 'Suma Editorial', 10);

INSERT INTO LB.ITEM(name, description, on_loan)
VALUES('Origen', 'Mi libro fav 2', 1);

INSERT INTO LB.BOOK(ID_Clasification, ID_Item, Title, Author, Edition, PublishingHouse, Score)
VALUES(3, 3, 'Origen', 'Dan Brown', 9, 'Booket', 9);


INSERT INTO LB.ITEM(name, description, on_loan)
VALUES('Inferno', 'Mi libro fav', 0);

INSERT INTO LB.BOOK(ID_Clasification, ID_Item, Title, Author, Edition, PublishingHouse, Score)
VALUES(3, 4, 'Inferno', 'Dan Brown', 6, 'Booket', 10);

select * from lb.book;
select * from lb.address;
select * from LB.item;
select * from LB.book_clasification;

delete from LB.Book;
delete from LB.Item;

INSERT INTO LB.loan_control(id_item, id_person, loan_date, return_date, days_amount)
VALUES(1, 305250055, '10/05/2021', '13/05/2021', 4);
select * from lb.loan_control;
