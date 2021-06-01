--Se eliminan los triggers de auditoría
DROP TRIGGER Person_OnInsert;
DROP TRIGGER Person_OnUpdate;
DROP TRIGGER Email_OnInsert;
DROP TRIGGER Email_OnUpdate;
DROP TRIGGER Address_OnInsert;
DROP TRIGGER Address_OnUpdate;
DROP TRIGGER PersonType_OnInsert;
DROP TRIGGER PersonType_OnUpdate;
DROP TRIGGER LoanControl_OnInsert;
DROP TRIGGER LoanControl_OnUpdate;
DROP TRIGGER Item_OnInsert;
DROP TRIGGER Item_OnUpdate;
DROP TRIGGER Book_OnInsert;
DROP TRIGGER Book_OnUpdate;
DROP TRIGGER BookClasification_OnInsert;
DROP TRIGGER BookClasification_OnUpdate;
DROP TRIGGER Videogame_OnInsert;
DROP TRIGGER Videogame_OnUpdate;
DROP TRIGGER Movie_OnInsert;
DROP TRIGGER Movie_OnUpdate;
DROP TRIGGER Genre_OnInsert;
DROP TRIGGER Genre_OnUpdate;
DROP TRIGGER Magazine_OnInsert;
DROP TRIGGER Magazine_OnUpdate;

--Se eliminan los procedures
DROP PROCEDURE insertPerson;
DROP PROCEDURE insertEmail;
DROP PROCEDURE insertAddress;

--Se eliminan las funciones
DROP FUNCTION get_Books;
DROP FUNCTION get_Clasification;
DROP FUNCTION get_BooksFiltered1;
DROP FUNCTION get_BooksFiltered2;
DROP FUNCTION get_BooksFiltered3;
DROP FUNCTION get_BooksFiltered4;
DROP FUNCTION get_BooksFiltered5;
DROP FUNCTION get_BooksFiltered6;
DROP FUNCTION get_BooksFiltered7;


--Se eliminan los triggers primero
DROP TRIGGER person_trigger;
DROP TRIGGER email_trigger;
DROP TRIGGER address_trigger;
DROP TRIGGER persontype_trigger;
DROP TRIGGER loancontrol_trigger;
DROP TRIGGER item_trigger;
DROP TRIGGER book_trigger;
DROP TRIGGER bookclasification_trigger;
DROP TRIGGER videogame_trigger;
DROP TRIGGER movie_trigger;
DROP TRIGGER genre_trigger;
DROP TRIGGER magazine_trigger;

--Se eliminan las secuencias despuï¿½s
DROP SEQUENCE person_seq;
DROP SEQUENCE email_seq;
DROP SEQUENCE address_seq;
DROP SEQUENCE persontype_seq;
DROP SEQUENCE loancontrol_seq;
DROP SEQUENCE item_seq;
DROP SEQUENCE book_seq;
DROP SEQUENCE bookclasification_seq;
DROP SEQUENCE videogame_seq;
DROP SEQUENCE movie_seq;
DROP SEQUENCE genre_seq;
DROP SEQUENCE magazine_seq;

--Por ï¿½ltimo, se eliminan las tablas
DROP TABLE LB.Person_Type;
DROP TABLE LB.Loan_Control;
DROP TABLE LB.Book;
DROP TABLE LB.Book_Clasification;
DROP TABLE LB.Videogame;
DROP TABLE LB.Movie;
DROP TABLE LB.Magazine;
DROP TABLE LB.Genre;
DROP TABLE LB.Address;
DROP TABLE LB.Email;
DROP TABLE LB.Item;
DROP TABLE LB.Person;


--Se crea un esquema
CREATE USER LB IDENTIFIED BY LB; -- ESTE SE HACE SOLO LA PRIMERA VEZ !!!!

--Se crean las tablas necesarias
CREATE TABLE LB.Person (ID_Number INT PRIMARY KEY NOT NULL,
                        ID_PersonType INT NOT NULL,
                        Firstname NCHAR(30) NOT NULL, 
                        Lastname NCHAR(30) NOT NULL,
                        Birthdate DATE NOT NULL,
                        --Campos de auditorï¿½a
                        CreatedOn DATE,
                        CreatedBy NCHAR(30),
                        UpdatedOn DATE,
                        UpdatedBy NCHAR(30));
                        
CREATE TABLE LB.Email (ID INT PRIMARY KEY NOT NULL, 
                       ID_Person INT NOT NULL, 
                       Email NCHAR(30) NOT NULL,
                       --Campos de auditorï¿½a
                        CreatedOn DATE,
                        CreatedBy NCHAR(30),
                        UpdatedOn DATE,
                        UpdatedBy NCHAR(30));
                       
CREATE TABLE LB.Address(ID INT PRIMARY KEY NOT NULL,  
                       ID_Person INT NOT NULL, 
                       Address nchar(500),
                       --Campos de auditorï¿½a
                        CreatedOn DATE,
                        CreatedBy NCHAR(30),
                        UpdatedOn DATE,
                        UpdatedBy NCHAR(30));

CREATE TABLE LB.Person_Type (ID INT PRIMARY KEY NOT NULL, 
                             Type nchar(30) NOT NULL,
                             --Campos de auditorï¿½a
                             CreatedOn DATE,
                             CreatedBy NCHAR(30),
                             UpdatedOn DATE,
                             UpdatedBy NCHAR(30));

CREATE TABLE LB.Loan_Control (ID INT PRIMARY KEY NOT NULL, 
                              ID_Person INT NOT NULL,
                              ID_Item INT NOT NULL,
                              Loan_Date DATE NOT NULL, 
                              Return_Date DATE NOT NULL, 
                              Days_Amount INT NOT NULL,
                              --Campos de auditorï¿½a
                              CreatedOn DATE,
                              CreatedBy NCHAR(30),
                              UpdatedOn DATE,
                              UpdatedBy NCHAR(30));

CREATE TABLE LB.Item (ID INT PRIMARY KEY NOT NULL, 
                      Name NCHAR(30) NOT NULL, 
                      Description NCHAR(60) NOT NULL, 
                      on_loan NUMBER(1,0),
                      --Campos de auditorï¿½a
                      CreatedOn DATE,
                      CreatedBy NCHAR(30),
                      UpdatedOn DATE,
                      UpdatedBy NCHAR(30)); --el on_loan nos permite saber cuï¿½les y cuï¿½ntos items estï¿½n en prï¿½stamo

CREATE TABLE LB.Book (ID INT PRIMARY KEY NOT NULL,
                      ID_Clasification INT NOT NULL,
                      ID_Item INT NOT NULL,
                      Title NCHAR(30) NOT NULL, 
                      Author NCHAR(30) NOT NULL, 
                      EDITION INT NOT NULL, 
                      CoverPage BLOB, 
                      PublishingHouse NCHAR(30) NOT NULL, 
                      Score INT NOT NULL,
                      --Campos de auditorï¿½a
                      CreatedOn DATE,
                      CreatedBy NCHAR(30),
                      UpdatedOn DATE,
                      UpdatedBy NCHAR(30));
                      
CREATE TABLE LB.Book_Clasification (ID INT PRIMARY KEY NOT NULL, 
                                    Clasification NCHAR(30) NOT NULL,
                                    --Campos de auditorï¿½a
                                    CreatedOn DATE,
                                    CreatedBy NCHAR(30),
                                    UpdatedOn DATE,
                                    UpdatedBy NCHAR(30));
                                    
CREATE TABLE LB.Videogame (ID INT PRIMARY KEY NOT NULL, 
                           ID_Item INT NOT NULL,
                           Name NCHAR(30) NOT NULL, 
                           Developer NCHAR(30) NOT NULL,
                           Genre NCHAR(30) NOT NULL,
                           --Campos de auditorï¿½a
                           CreatedOn DATE,
                           CreatedBy NCHAR(30),
                           UpdatedOn DATE,
                           UpdatedBy NCHAR(30));
                           
CREATE TABLE LB.Movie (ID INT PRIMARY KEY NOT NULL, 
                       ID_Genre INT NOT NULL,
                       ID_Item INT NOT NULL,
                       Title NCHAR(30) NOT NULL, 
                       MinDuration INT NOT NULL, 
                       Director NCHAR(30) NOT NULL, 
                       Score INT NOT NULL,
                       --Campos de auditorï¿½a
                       CreatedOn DATE,
                       CreatedBy NCHAR(30),
                       UpdatedOn DATE,
                       UpdatedBy NCHAR(30));
                       
CREATE TABLE LB.Genre (ID INT PRIMARY KEY NOT NULL,
                       Genre NCHAR(30) NOT NULL,
                       --Campos de auditorï¿½a
                       CreatedOn DATE,
                       CreatedBy NCHAR(30),
                       UpdatedOn DATE,
                       UpdatedBy NCHAR(30));

                           
CREATE TABLE LB.Magazine(ID INT PRIMARY KEY NOT NULL,
                         ID_Item INT NOT NULL,
                         Title NCHAR(30) NOT NULL, 
                         Volume INT NOT NULL,
                         --Campos de auditorï¿½a
                         CreatedOn DATE,
                         CreatedBy NCHAR(30),
                         UpdatedOn DATE,
                         UpdatedBy NCHAR(30));                    
                        
                                 
/*Se establecen las foreign keys*/ 

ALTER TABLE LB.Loan_Control
ADD CONSTRAINT FK_Person
FOREIGN KEY (ID_Person) REFERENCES LB.Person(ID_Number);

ALTER TABLE LB.Person
ADD CONSTRAINT FK_PersonType
FOREIGN KEY (ID_PersonType) REFERENCES LB.Person_Type(ID);

ALTER TABLE LB.Loan_Control
ADD CONSTRAINT FK_ControlItem
FOREIGN KEY (ID_Item) REFERENCES LB.Item(ID);

ALTER TABLE LB.Email
ADD CONSTRAINT FK_EmailPerson
FOREIGN KEY (ID_Person) REFERENCES LB.Person(ID_Number);

ALTER TABLE LB.Book
ADD CONSTRAINT FK_Clasification
FOREIGN KEY (ID_Clasification) REFERENCES LB.Book_Clasification(ID);      

ALTER TABLE LB.Book
ADD CONSTRAINT FK_BookItem
FOREIGN KEY (ID_Item) REFERENCES LB.Item(ID);

ALTER TABLE LB.Videogame
ADD CONSTRAINT FK_GameItem
FOREIGN KEY (ID_Item) REFERENCES LB.Item(ID);

ALTER TABLE LB.Movie
ADD CONSTRAINT FK_Genre
FOREIGN KEY (ID_Genre) REFERENCES LB.Genre(ID);

ALTER TABLE LB.Movie
ADD CONSTRAINT FK_MovieItem
FOREIGN KEY (ID_Item) REFERENCES LB.Item(ID);

ALTER TABLE LB.Magazine
ADD CONSTRAINT FK_MagazineItem
FOREIGN KEY (ID_Item) REFERENCES LB.Item(ID);

ALTER TABLE LB.Address
ADD CONSTRAINT FK_AddressPerson
FOREIGN KEY (ID_Person) REFERENCES LB.Person(ID_Number);


/*se hacen los campos ID de tipo identity*/



--Para la tabla Email
CREATE SEQUENCE email_seq
START WITH 1
INCREMENT BY 1
MINVALUE 0;

CREATE OR REPLACE TRIGGER email_trigger 
BEFORE INSERT ON LB.Email 
FOR EACH ROW
WHEN (new.id IS NULL)
BEGIN
  SELECT email_seq.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;

--Para la tabla Address
CREATE SEQUENCE address_seq
START WITH 1
INCREMENT BY 1
MINVALUE 0;

CREATE OR REPLACE TRIGGER address_trigger 
BEFORE INSERT ON LB.Address
FOR EACH ROW
WHEN (new.id IS NULL)
BEGIN
  SELECT address_seq.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;

--Para la tabla Person_Type
CREATE SEQUENCE persontype_seq
START WITH 1
INCREMENT BY 1
MINVALUE 0;

CREATE OR REPLACE TRIGGER persontype_trigger  
BEFORE INSERT ON LB.Person_Type 
FOR EACH ROW
WHEN (new.id IS NULL)
BEGIN
  SELECT persontype_seq.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;

--Para la tabla Loan_Control
CREATE SEQUENCE loancontrol_seq
START WITH 1
INCREMENT BY 1
MINVALUE 0;

CREATE OR REPLACE TRIGGER loancontrol_trigger  
BEFORE INSERT ON LB.Loan_Control
FOR EACH ROW
WHEN (new.id IS NULL)
BEGIN
  SELECT loancontrol_seq.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;

--Para la tabla Item
CREATE SEQUENCE item_seq
START WITH 1
INCREMENT BY 1
MINVALUE 0;

CREATE OR REPLACE TRIGGER item_trigger 
BEFORE INSERT ON LB.Item
FOR EACH ROW
WHEN (new.id IS NULL)
BEGIN
  SELECT item_seq.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;

--Para la tabla Book
CREATE SEQUENCE book_seq
START WITH 1
INCREMENT BY 1
MINVALUE 0;

CREATE OR REPLACE TRIGGER book_trigger 
BEFORE INSERT ON LB.Book
FOR EACH ROW
WHEN (new.id IS NULL)
BEGIN
  SELECT book_seq.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;

--Para la tabla Book_Clasification
CREATE SEQUENCE bookclasification_seq
START WITH 1
INCREMENT BY 1
MINVALUE 0;

CREATE OR REPLACE TRIGGER bookclasification_trigger
BEFORE INSERT ON LB.Book_Clasification
FOR EACH ROW
WHEN (new.id IS NULL)
BEGIN
  SELECT bookclasification_seq.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;

--Para la tabla Videogame
CREATE SEQUENCE videogame_seq
START WITH 1
INCREMENT BY 1
MINVALUE 0;

CREATE OR REPLACE TRIGGER videogame_trigger 
BEFORE INSERT ON LB.Videogame
FOR EACH ROW
WHEN (new.id IS NULL)
BEGIN
  SELECT videogame_seq.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;

--Para la tabla Movie
CREATE SEQUENCE movie_seq
START WITH 1
INCREMENT BY 1
MINVALUE 0;

CREATE OR REPLACE TRIGGER movie_trigger  
BEFORE INSERT ON LB.Movie
FOR EACH ROW
WHEN (new.id IS NULL)
BEGIN
  SELECT movie_seq.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;

--Para la tabla Genre
CREATE SEQUENCE genre_seq
START WITH 1
INCREMENT BY 1
MINVALUE 0;

CREATE OR REPLACE TRIGGER genre_trigger  
BEFORE INSERT ON LB.Genre
FOR EACH ROW
WHEN (new.id IS NULL)
BEGIN
  SELECT genre_seq.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;

--Para la tabla Magazine
CREATE SEQUENCE magazine_seq
START WITH 1
INCREMENT BY 1
MINVALUE 0;

CREATE OR REPLACE TRIGGER magazine_trigger  
BEFORE INSERT ON LB.Magazine
FOR EACH ROW
WHEN (new.id IS NULL)
BEGIN
  SELECT magazine_seq.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;



