USE classicmodels;
CREATE TABLE employees_audit (
    id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    employeeNumber INT(11) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    firstname VARCHAR(50) NOT NULL,
    changedat DATETIME,
    action VARCHAR(50)
);
