-- Name: Gadd, Cooper
-- Class: ISTE330
-- Date: 10/27/2023
-- PE#: 03
-- Professor Habermas

USE classicmodels;
DROP PROCEDURE IF EXISTS update_employees_audit;
delimiter //
CREATE PROCEDURE update_employees_audit(
    IN OLD_employeeNumber INT(11),
    IN OLD_lastname VARCHAR(50),
    IN OLD_firstname VARCHAR(50)
)
    BEGIN
        INSERT INTO employees_audit
        SET action = 'update',
        employeeNumber = OLD_employeeNumber,
        lastname = OLD_lastname,
        firstname = OLD_firstname,
        changedat = NOW();
    END;
//
delimiter ;
call update_employees_audit(1002,"Murphy", "Diane");
call update_employees_audit(1056,"Patterson", "Mary");
call update_employees_audit(1076,"Firrelli", "Jeff");