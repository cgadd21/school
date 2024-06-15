USE book;
DELIMITER //
CREATE PROCEDURE sample02()
   BEGIN
     SELECT title AS "Title", 
       GROUP_CONCAT(concat(LastName,", ",FirstName) order by LastName  separator' | ') as "Author(s)"
       FROM book join bookAuthor USING (isbn)
                 join author USING (authorID) 
                  GROUP BY title
                   ORDER BY title;
   END;
//
DELIMITER ;
CALL sample02();  




