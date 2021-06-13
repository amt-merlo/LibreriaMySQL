/*
Description: Procedure that get all data from the table books
Author: Allison M. Merlo
Creation Date: 2/06/2021
*/
DELIMITER $$
CREATE PROCEDURE lb.getBooks()
MODIFIES SQL DATA
BEGIN
  SELECT * FROM lb.Book;
END$$

/*
Description: Procedure that get data from the table book filtered by the column title, author and publishing house
Author: Allison M. Merlo
Creation Date: 2/06/2021
*/
CREATE PROCEDURE lb.get_BooksFiltered1(IN inTitle VARCHAR(100), IN inAuthor VARCHAR(100), IN inPHouse VARCHAR(100))
MODIFIES SQL DATA
BEGIN
  SELECT * FROM LB.Book
  WHERE title = inTitle AND author = inAuthor AND PublishingHouse = inPHouse;
END$$

/*
Description: Procedure that get data from the table book filtered by the column title and author
Author: Allison M. Merlo
Creation Date: 2/06/2021
*/
CREATE PROCEDURE lb.get_BooksFiltered2(IN inTitle VARCHAR(100), IN inAuthor VARCHAR(100))
MODIFIES SQL DATA
BEGIN
  SELECT * FROM LB.Book
  WHERE title = inTitle AND author = inAuthor;
END$$

/*
Description: Procedure that get data from the table books filtered by the column title and publishing house
Author: Allison M. Merlo
Creation Date: 2/06/2021
*/
CREATE PROCEDURE lb.get_BooksFiltered3(IN inTitle VARCHAR(100), IN inPHouse VARCHAR(100))
MODIFIES SQL DATA
BEGIN
  SELECT * FROM LB.Book
  WHERE title = inTitle AND PublishingHouse = inPHouse;
END$$

/*
Description: Procedure that get data from the table book filtered by the column author and publishing house
Author: Allison M. Merlo
Creation Date: 2/06/2021
*/
CREATE PROCEDURE lb.get_BooksFiltered4(IN inAuthor VARCHAR(100), IN inPHouse VARCHAR(100))
MODIFIES SQL DATA
BEGIN
  SELECT * FROM LB.Book
  WHERE author = inAuthor AND PublishingHouse = inPHouse;
END$$

/*
Description: Procedure that get data from the table book filtered by the title
Author: Allison M. Merlo
Creation Date: 2/06/2021
*/
CREATE PROCEDURE lb.get_BooksFiltered5(IN inTitle VARCHAR(100))
MODIFIES SQL DATA
BEGIN
  SELECT * FROM LB.Book
  WHERE title = inTitle;
END$$

/*
Description: Procedure that get data from the table book filtered by the author
Author: Allison M. Merlo
Creation Date: 2/06/2021
*/
CREATE PROCEDURE lb.get_BooksFiltered6(IN inAuthor VARCHAR(100))
MODIFIES SQL DATA
BEGIN
  SELECT * FROM LB.Book
  WHERE author = inAuthor;
END$$

/*
Description: Procedure that get data from the table book filtered by the column publishing house
Author: Allison M. Merlo
Creation Date: 2/06/2021
*/
CREATE PROCEDURE lb.get_BooksFiltered7(IN inPHouse VARCHAR(100))
MODIFIES SQL DATA
BEGIN
  SELECT * FROM LB.Book
  WHERE PublishingHouse = inPHouse;
END$$