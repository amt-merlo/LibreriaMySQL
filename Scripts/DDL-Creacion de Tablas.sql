/*
Description: Drop, create and alter of all the required tables for the implementation.
Author: Allison M. Merlo
Creation Date: 30/05/2021
*/


/*Se eliminan los triggers*/
DROP TRIGGER LB.Person_OnInsert;
DROP TRIGGER LB.Person_OnUpdate;
DROP TRIGGER LB.Email_OnInsert;
DROP TRIGGER LB.Email_OnUpdate;
DROP TRIGGER LB.Address_OnInsert;
DROP TRIGGER LB.Address_OnUpdate;
DROP TRIGGER LB.PersonType_OnInsert;
DROP TRIGGER LB.PersonType_OnUpdate;
DROP TRIGGER LB.LoanControl_OnInsert;
DROP TRIGGER LB.LoanControl_OnUpdate;
DROP TRIGGER LB.Item_OnInsert;
DROP TRIGGER LB.Item_OnUpdate;
DROP TRIGGER LB.Book_OnInsert;
DROP TRIGGER LB.Book_OnUpdate;
DROP TRIGGER LB.BookClasification_OnInsert;
DROP TRIGGER LB.BookClasification_OnUpdate;
DROP TRIGGER LB.Videogame_OnInsert;
DROP TRIGGER LB.Videogame_OnUpdate;
DROP TRIGGER LB.Movie_OnInsert;
DROP TRIGGER LB.Movie_OnUpdate;
DROP TRIGGER LB.Genre_OnInsert;
DROP TRIGGER LB.Genre_OnUpdate;
DROP TRIGGER LB.Magazine_OnInsert;
DROP TRIGGER LB.Magazine_OnUpdate;

/*Se eliminan Stored Procedures*/
DROP PROCEDURE LB.createItem;
DROP PROCEDURE LB.get_BookClasifications;
DROP PROCEDURE LB.get_BooksFiltered1;
DROP PROCEDURE LB.get_BooksFiltered2;
DROP PROCEDURE LB.get_BooksFiltered3;
DROP PROCEDURE LB.get_BooksFiltered4;
DROP PROCEDURE LB.get_BooksFiltered5;
DROP PROCEDURE LB.get_BooksFiltered6;
DROP PROCEDURE LB.get_BooksFiltered7;
DROP PROCEDURE LB.get_BorrowedBooks;
DROP PROCEDURE LB.get_BorrowedBooksByID;
DROP PROCEDURE LB.get_Clasification;
DROP PROCEDURE LB.get_ClasificationID;
DROP PROCEDURE LB.get_ItemID;
DROP PROCEDURE LB.get_Loans;
DROP PROCEDURE LB.get_notBorrowed;
DROP PROCEDURE LB.get_PersonType;
DROP PROCEDURE LB.get_PersonTypeByID;
DROP PROCEDURE LB.get_PersonTypeID;
DROP PROCEDURE LB.getBooks;
DROP PROCEDURE LB.getPeople;
DROP PROCEDURE LB.insertAddress;
DROP PROCEDURE LB.insertBook;
DROP PROCEDURE LB.insertEmail;
DROP PROCEDURE LB.insertPerson;
DROP PROCEDURE LB.update_Book;
DROP PROCEDURE LB.update_Person;
DROP PROCEDURE LB.get_logbook;
DROP PROCEDURE LB.LogBookFiltered;
DROP PROCEDURE LB.get_BookCoverPage;

/*Se eliminan funciones*/
DROP FUNCTION LB.userValidation;

/*Se eliminan las tablas*/
DROP TABLE LB.book;
DROP TABLE LB.Loan_Control;
DROP TABLE LB.Email;
DROP TABLE LB.Address;
DROP TABLE LB.Person;
DROP TABLE LB.Book_Clasification;
DROP TABLE LB.VideoGame;
DROP TABLE LB.Magazine;
DROP TABLE LB.Movie;
DROP TABLE LB.Item;
DROP TABLE LB.Genre;
DROP TABLE LB.Person_Type;
DROP TABLE LB.Users;
DROP TABLE LB.LogBook;

CREATE TABLE LB.Person (ID_Number INT PRIMARY KEY NOT NULL,
                        ID_PersonType INT NOT NULL,
                        Firstname VARCHAR(40) NOT NULL, 
                        Lastname VARCHAR(40) NOT NULL,
                        Birthdate DATE NOT NULL,
                        /*Campos de auditoria*/
                        CreatedOn DATE,
                        CreatedBy VARCHAR(30),
                        UpdatedOn DATE,
                        UpdatedBy VARCHAR(30));
                        
CREATE TABLE LB.Email (ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL, 
                       ID_Person INT NOT NULL, 
                       Email VARCHAR(60) NOT NULL,
                       /*Campos de auditoria*/
                        CreatedOn DATE,
                        CreatedBy VARCHAR(30),
                        UpdatedOn DATE,
                        UpdatedBy VARCHAR(30));
                       
CREATE TABLE LB.Address(ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,  
                       ID_Person INT NOT NULL, 
                       Address VARCHAR(500),
                       /*Campos de auditoria*/
                        CreatedOn DATE,
                        CreatedBy VARCHAR(30),
                        UpdatedOn DATE,
                        UpdatedBy VARCHAR(30));

CREATE TABLE LB.Person_Type (ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL, 
                             Type VARCHAR(30) NOT NULL,
                             /*Campos de auditoria*/
                             CreatedOn DATE,
                             CreatedBy VARCHAR(30),
                             UpdatedOn DATE,
                             UpdatedBy VARCHAR(30));

CREATE TABLE LB.Loan_Control (ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL, 
                              ID_Person INT NOT NULL,
                              ID_Item INT NOT NULL,
                              Loan_Date DATE NOT NULL, 
                              Return_Date DATE NOT NULL, 
                              Days_Amount INT NOT NULL,
                              /*Campos de auditoria*/
                              CreatedOn DATE,
                              CreatedBy VARCHAR(30),
                              UpdatedOn DATE,
                              UpdatedBy VARCHAR(30));

CREATE TABLE LB.Item (ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL, 
                      Name VARCHAR(200) NOT NULL, 
                      Description VARCHAR(200) NOT NULL, 
                      on_loan INT,
                      /*Campos de auditoria*/
                      CreatedOn DATE,
                      CreatedBy VARCHAR(30),
                      UpdatedOn DATE,
                      UpdatedBy VARCHAR(30)); /*el on_loan nos permite saber cuï¿½les y cuï¿½ntos items estï¿½n en prestamo*/

CREATE TABLE LB.Book (ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
                      ID_Clasification INT NOT NULL,
                      ID_Item INT NOT NULL,
                      Title VARCHAR(200) NOT NULL, 
                      Author VARCHAR(200) NOT NULL, 
                      EDITION INT NOT NULL, 
                      CoverPage VARCHAR(200), 
                      PublishingHouse VARCHAR(100) NOT NULL, 
                      Score INT NOT NULL,
                      /*Campos de auditoria*/
                      CreatedOn DATE,
                      CreatedBy VARCHAR(30),
                      UpdatedOn DATE,
                      UpdatedBy VARCHAR(30));
                      
CREATE TABLE LB.Book_Clasification (ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL, 
                                    Clasification VARCHAR(100) NOT NULL,
                                    /*Campos de auditoria*/
                                    CreatedOn DATE,
                                    CreatedBy VARCHAR(30),
                                    UpdatedOn DATE,
                                    UpdatedBy VARCHAR(30));
                                    
CREATE TABLE LB.Videogame (ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL, 
                           ID_Item INT NOT NULL,
                           Name VARCHAR(30) NOT NULL, 
                           Developer VARCHAR(30) NOT NULL,
                           Genre VARCHAR(30) NOT NULL,
                           /*Campos de auditoria*/
                           CreatedOn DATE,
                           CreatedBy VARCHAR(30),
                           UpdatedOn DATE,
                           UpdatedBy VARCHAR(30));
                           
CREATE TABLE LB.Movie (ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL, 
                       ID_Genre INT NOT NULL,
                       ID_Item INT NOT NULL,
                       Title VARCHAR(30) NOT NULL, 
                       MinDuration INT NOT NULL, 
                       Director VARCHAR(30) NOT NULL, 
                       Score INT NOT NULL,
                       /*Campos de auditoria*/
                       CreatedOn DATE,
                       CreatedBy VARCHAR(30),
                       UpdatedOn DATE,
                       UpdatedBy VARCHAR(30));
                       
CREATE TABLE LB.Genre (ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
                       Genre VARCHAR(30) NOT NULL,
                       /*Campos de auditoria*/
                       CreatedOn DATE,
                       CreatedBy VARCHAR(30),
                       UpdatedOn DATE,
                       UpdatedBy VARCHAR(30));

                           
CREATE TABLE LB.Magazine(ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
                         ID_Item INT NOT NULL,
                         Title VARCHAR(30) NOT NULL, 
                         Volume INT NOT NULL,
                         /*Campos de auditoria*/
                         CreatedOn DATE,
                         CreatedBy VARCHAR(30),
                         UpdatedOn DATE,
                         UpdatedBy VARCHAR(30));                    
					
CREATE TABLE LB.Users(username VARCHAR(100) PRIMARY KEY NOT NULL, 
					  pass VARCHAR(100) NOT NULL);
                      
CREATE TABLE LB.LogBook(ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
						ChangeDate DATE NOT NULL,
                        ChangeHour VARCHAR(20) NOT NULL,
                        ChangeType VARCHAR(80) NOT NULL,
                        Object VARCHAR(80) NOT NULL,
                        ChangeDescription VARCHAR(200) NOT NULL,
                        Username VARCHAR(100) NOT NULL);
                      
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