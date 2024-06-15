-- Third Example
DROP DATABASE IF EXISTS test3;

CREATE DATABASE test3;
USE test3;

CREATE TABLE accounts_owner(
ownerID                      int UNSIGNED  PRIMARY KEY,
accountOwnerFirstname        varchar(50),
accountOwnerLastname         varchar(50)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO accounts_owner VALUES
(1,"Sarah","Smith"),
(2,"David","Wilcox"),
(3,"Zaid","Al-Nuaim"),
(4,"Karen","Salley"),
(5,"Jim", "Habermas");


DROP TABLE IF EXISTS accounts;

CREATE TABLE accounts(
id               INT UNSIGNED not null auto_increment,
account_type     enum ("S","C","MM","IRA") not null,
balance          DECIMAL(10,2) not null default 0.0,
CONSTRAINT accounts_owners_fk FOREIGN KEY (id)
        REFERENCES accounts_owner (ownerId),
PRIMARY KEY (id, account_type)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO accounts VALUES
(1, "S",  160.00),
(1, "C",   40.00),
(2, "S", 9000.00),
(2, "C",  100.00),
(3, "S", 3000.00),
(3, "C",    5.00),
(4, "MM", 2000.99),
(5, "IRA", 5000.00);

