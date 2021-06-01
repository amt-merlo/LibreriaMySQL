ALTER USER LB quota unlimited on USERS;
--Filling of the catalog Person_Type
INSERT INTO LB.Person_Type (type) 
VALUES ('Student');

INSERT INTO LB.Person_Type (type)
VALUES ('Friend');

INSERT INTO LB.Person_Type (type)
VALUES ('Relative');

INSERT INTO LB.Person_Type (type)
VALUES ('Other');


--Filling of the clasification's table 
INSERT INTO LB.Book_Clasification (clasification)
VALUES ('Fiction');

INSERT INTO LB.Book_Clasification (clasification)
VALUES ('Novel');

INSERT INTO LB.Book_Clasification (clasification)
VALUES ('Action and Adventure');

INSERT INTO LB.Book_Clasification (clasification)
VALUES ('Classics');

INSERT INTO LB.Book_Clasification (clasification)
VALUES ('Detective and Mistery');

INSERT INTO LB.Book_Clasification (clasification)
VALUES ('Fantasy');

INSERT INTO LB.Book_Clasification (clasification)
VALUES ('Romance');

INSERT INTO LB.Book_Clasification (clasification)
VALUES ('Science-Fiction');

INSERT INTO LB.Book_Clasification (clasification)
VALUES ('Suspense-Thriller');

INSERT INTO LB.Book_Clasification (clasification)
VALUES ('Autobiography');

INSERT INTO LB.Book_Clasification (clasification)
VALUES ('Poetry');


--Filling of the genre table for movies
INSERT INTO LB.Genre (genre)
VALUES ('Action');

INSERT INTO LB.Genre (genre)
VALUES ('Comedy');

INSERT INTO LB.Genre (genre)
VALUES ('Drama');

INSERT INTO LB.Genre (genre)
VALUES ('Fantasy');

INSERT INTO LB.Genre (genre)
VALUES ('Horror');

INSERT INTO LB.Genre (genre)
VALUES ('Mistery');

INSERT INTO LB.Genre (genre)
VALUES ('Romance');

INSERT INTO LB.Genre (genre)
VALUES ('Thriller');

--Para ver el resultado
SELECT * FROM LB.person_type;
SELECT * FROM LB.Book_Clasification;
SELECT * FROM LB.Genre;

DELETE FROM LB.Person_Type;
DELETE FROM LB.Genre;
DELETE FROM LB.book_clasification;
