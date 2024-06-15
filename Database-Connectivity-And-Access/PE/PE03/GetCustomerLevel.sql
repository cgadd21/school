-- Name: Gadd, Cooper
-- Class: ISTE330
-- Date: 10/27/2023
-- PE#: 03
-- Professor Habermas

USE classicmodels;
DROP PROCEDURE IF EXISTS GetCustomerLevel;
DELIMITER //
CREATE PROCEDURE GetCustomerLevel(
    IN p_customerNumber int(11), 
    OUT p_customerLevel  varchar(10))
    BEGIN
        DECLARE creditlim double;
        SELECT creditlimit INTO creditlim
        FROM customers
        WHERE customerNumber = p_customerNumber;

        IF creditlim > 50000 THEN
            SET p_customerLevel = 'PLATINUM';
        ELSEIF creditlim >= 10000 THEN 
            SET p_customerLevel = 'GOLD';
        ELSE
            SET p_customerLevel = 'SILVER';
        END IF;
    END;
//
DELIMITER ;