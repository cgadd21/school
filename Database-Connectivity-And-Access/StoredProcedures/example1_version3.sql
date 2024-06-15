-- Professor Habermas
-- Email:   Jim.Habermas@rit.edu
-- Test Data 3 Bank accounts 1) Sarah   2)David  3)  Kojo
-- Stored Procedure to transfer money ($)
-- MySql Transaction because of transferring money between accounts
-- Store procedure name is rollbacktest()
-- START TRANSACTION     ROLLBACK   COMMIT
-- A transaction has the following properties:
--	Atomic - the transaction cannot be subdivided and, therefore
--               it must be processed in its entirety or not at all!
--	Consistency
--	Isolation
--	Durability
DROP DATABASE IF EXISTS test;
CREATE DATABASE test;
USE test;
DROP TABLE IF EXISTS accounts;
CREATE TABLE accounts(
id int unsigned not null auto_increment,
first_name varchar(20) not null,
last_name varchar(40) not null,
balance decimal(10,2) not null default 0.0,
primary key (id))ENGINE=InnoDB;
INSERT INTO accounts VALUES
(NULL, 'Sarah', 'Vowell', 160.01),
(Null, 'David', 'Sedaris', 9000.02),
(Null, 'Kojo', 'Nnamdi', 9992.03);

DROP PROCEDURE IF EXISTS rollbacktest;
DELIMITER //
CREATE PROCEDURE rollbacktest(IN amount double, IN acct_from INT, IN acct_going_to int)
   BEGIN
        DECLARE bal DECIMAL(10,2) DEFAULT 0.0;
	START TRANSACTION;
	update accounts set balance = (balance - amount) where id = acct_from;
	update accounts set balance = (balance + amount) where id = acct_going_to;

	SELECT balance
	    INTO bal
                  FROM accounts WHERE id = acct_from;

	SELECT if (bal < 0, "Negative balance - RollBack will occur!", "Positive Balance.");
	
	SELECT balance FROM accounts where id = acct_from;
	
	IF bal < 0 THEN
	    ROLLBACK;
	ELSE
	    COMMIT;
        END IF;
   END//
DELIMITER ;

-- Lets call the StoredProcedure with the line below
CALL rollbacktest(110.00,1,2);  


SELECT id,CONCAT(last_name,", ",first_name) AS "Account_Owner",
       balance AS "Account_Balance" FROM accounts
           WHERE first_name LIKE "Sarah";           

SELECT id,CONCAT(last_name,", ",first_name) AS "Account_Owner",
        balance AS "Account_Balance" FROM accounts;