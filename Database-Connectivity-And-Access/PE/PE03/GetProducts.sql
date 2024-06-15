-- Name: Gadd, Cooper
-- Class: ISTE330
-- Date: 10/27/2023
-- PE#: 03
-- Professor Habermas

USE classicmodels;
DROP PROCEDURE IF EXISTS GetProducts;
DELIMITER //
CREATE PROCEDURE GetProducts()
    BEGIN
        SELECT productCode,productName,quantityInStock FROM products LIMIT 10;
    END;
//
DELIMITER ;