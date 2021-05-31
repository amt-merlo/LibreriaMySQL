DELIMITER $$

CREATE PROCEDURE lb.getBooks()
MODIFIES SQL DATA
BEGIN
  SELECT * FROM lb.Book;
END$$

CREATE PROCEDURE lb.get_BooksFiltered1(IN inTitle VARCHAR(100), IN inAuthor VARCHAR(100), IN inPHouse VARCHAR(100))
MODIFIES SQL DATA
BEGIN
  SELECT * FROM LB.Book
  WHERE title = inTitle AND author = inAuthor AND PublishingHouse = inPHouse;
END$$

CREATE PROCEDURE lb.get_BooksFiltered2(IN inTitle VARCHAR(100), IN inAuthor VARCHAR(100))
MODIFIES SQL DATA
BEGIN
  SELECT * FROM LB.Book
  WHERE title = inTitle AND author = inAuthor;
END$$

CREATE PROCEDURE lb.get_BooksFiltered3(IN inTitle VARCHAR(100), IN inPHouse VARCHAR(100))
MODIFIES SQL DATA
BEGIN
  SELECT * FROM LB.Book
  WHERE title = inTitle AND PublishingHouse = inPHouse;
END$$


CREATE PROCEDURE lb.get_BooksFiltered4(IN inAuthor VARCHAR(100), IN inPHouse VARCHAR(100))
MODIFIES SQL DATA
BEGIN
  SELECT * FROM LB.Book
  WHERE author = inAuthor AND PublishingHouse = inPHouse;
END$$

CREATE PROCEDURE lb.get_BooksFiltered5(IN inTitle VARCHAR(100))
MODIFIES SQL DATA
BEGIN
  SELECT * FROM LB.Book
  WHERE title = inTitle;
END$$

CREATE PROCEDURE lb.get_BooksFiltered6(IN inAuthor VARCHAR(100))
MODIFIES SQL DATA
BEGIN
  SELECT * FROM LB.Book
  WHERE author = inAuthor;
END$$

CREATE PROCEDURE lb.get_BooksFiltered7(IN inPHouse VARCHAR(100))
MODIFIES SQL DATA
BEGIN
  SELECT * FROM LB.Book
  WHERE PublishingHouse = inPHouse;
END$$