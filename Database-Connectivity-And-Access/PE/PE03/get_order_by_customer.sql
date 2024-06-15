-- Name: Gadd, Cooper
-- Class: ISTE330
-- Date: 10/27/2023
-- PE#: 03
-- Professor Habermas

USE classicmodels;

drop procedure if EXISTS get_order_by_cust;
-- The following example demonstrates how to use an out parameter in 
-- the stored procedure.
DELIMITER $$
 
CREATE PROCEDURE get_order_by_cust(
 IN cust_no INT,
 OUT shipped INT,
 OUT canceled INT,
 OUT resolved INT,
 OUT disputed INT)
BEGIN
 -- shipped
 SELECT
            count(*) INTO shipped
        FROM
            orders
        WHERE
            customerNumber = cust_no
                AND status = 'Shipped';
 
 -- canceled
 SELECT
            count(*) INTO canceled
        FROM
            orders
        WHERE
            customerNumber = cust_no
                AND status = 'Canceled';
 
 -- resolved
 SELECT
            count(*) INTO resolved
        FROM
            orders
        WHERE
            customerNumber = cust_no
                AND status = 'Resolved';
 
 -- disputed
 SELECT
            count(*) INTO disputed
        FROM
            orders
        WHERE
            customerNumber = cust_no
                AND status = 'Disputed';
 
END$$
DELIMITER ;


-- CALL get_order_by_cust(141,@shipped,@canceled,@resolved,@disputed);
 
-- SELECT @shipped,@canceled,@resolved,@disputed;