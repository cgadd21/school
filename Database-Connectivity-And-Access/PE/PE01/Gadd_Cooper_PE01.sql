-- Name: Gadd, Cooper
-- Class: ISTE330
-- Date: 9/2/2023
-- PE#: 01
-- Professor Habermas
SELECT "ISTE.330.02", "PE01" AS "Gadd", NOW() AS "Date working on PE01";

##############
##Question 1##
##############
SELECT 'Question 01' AS "PE01 ISTE330";
USE jobs;
-- Open database jobs.
SELECT city, COUNT(*)
FROM jobs.employer 
WHERE city LIKE "_E%"
OR city LIKE "_O%"
OR city LIKE "_A%"
GROUP BY city
HAVING COUNT(*) > 1
ORDER BY city DESC;

##############
##Question 2##
##############
SELECT 'Question 02' AS "PE01 ISTE330";
USE lawncare;
-- Open database lawncare.
SELECT COUNT(day) AS 'How_Many_Lawns',day as 'Day_Of_the_Week' 
FROM lawncare.customer
GROUP BY day
ORDER BY How_Many_Lawns ASC;

##############
##Question 3##
##############
SELECT 'Question 03' AS "PE01 ISTE330";
USE studentdb;
-- Open database studentdb.
SELECT CONCAT(lastName,', ',firstName) AS 'Name',class,departmentID AS 'Department',gpa AS 'GPA'
FROM studentdb.student
WHERE class = 'SR' OR class = 'GR'
GROUP BY lastName,firstName,class,departmentID,gpa
ORDER BY CONCAT(lastName,', ',firstName);

##############
##Question 4##
##############
SELECT 'Question 04' AS "PE01 ISTE330";
USE studentdb;
-- Open database studentdb.
SELECT COUNT(class) AS 'How_Many_Students_Per_Class', class
FROM studentdb.student
GROUP BY class;

##############
##Question 5##
##############
SELECT 'Question 05' AS "PE01 ISTE330";
USE book;
-- Open database book.
SELECT Title AS 'Title of Book',GROUP_CONCAT(DISTINCT CONCAT(lastName,', ',firstName) ORDER BY lastName ASC SEPARATOR ' | ') AS 'Author(s)'
FROM book.book
JOIN book.bookauthor USING (ISBN)
JOIN book.author USING (AuthorID)
GROUP BY Title
ORDER BY Title;

##############
##Question 6##
##############
SELECT 'Question 06' AS "PE01 ISTE330";
USE book;
-- Open database book.
SELECT OwnerID AS "Owner's ID", CONCAT(LastName,', ',FirstName) AS "Owner's Name", MAX(Price) AS 'MAX(price)', MIN(Price) AS 'MIN(price)'
FROM book.owner
JOIN book.ownersbook USING (OwnerID)
GROUP BY OwnerID,LastName,FirstName
ORDER BY OwnerID DESC;