DROP DATABASE IF EXISTS bankDB;
CREATE DATABASE bankDB;
USE bankDB;

CREATE TABLE IF NOT EXISTS AccountHolder (
    ownerId INT,
    accountOwner VARCHAR(50) NOT NULL,
    CONSTRAINT accountholder_ownerId_pk PRIMARY KEY (ownerId)
);

CREATE TABLE IF NOT EXISTS Account (
    accountId INT,
    accountNumber INT,
    ownerId INT,
    accountType CHAR(2),
    activate BOOLEAN,
    amount DECIMAL(12 , 2 ),
    CONSTRAINT account_accountId_pk PRIMARY KEY (accountId),
    CONSTRAINT account_ownerId_fk FOREIGN KEY (ownerId)
        REFERENCES accountholder (ownerId)
);

--
-- Dumping data into table "AccountHolder"
--

INSERT INTO accountholder VALUES(1, "Sam Smith");
INSERT INTO accountholder VALUES(2, "Anthony Lambart");
INSERT INTO accountholder VALUES(3, "Willaim Mackay");
INSERT INTO accountholder VALUES(4, "Nicola Parr");
INSERT INTO accountholder VALUES(5, "Brandon Peters");
INSERT INTO accountholder VALUES(6, "Stephanie Welch");
INSERT INTO accountholder VALUES(7, "Jonathan Metcalfe");
INSERT INTO accountholder VALUES(8, "Jennifer Slater");
INSERT INTO accountholder VALUES(9, "Mary MacLeod");
INSERT INTO accountholder VALUES(10, "Fiona Wilkins");
INSERT INTO accountholder VALUES(11, "Joshua Murray");
INSERT INTO accountholder VALUES(12, "David Wilkins");
INSERT INTO accountholder VALUES(13, "Katherine Mathis");
INSERT INTO accountholder VALUES(14, "Luke Henderson");
INSERT INTO accountholder VALUES(15, "Kylie Walsh");
INSERT INTO accountholder VALUES(16, "Hannah Howard");
INSERT INTO accountholder VALUES(17, "Molly Knox");
INSERT INTO accountholder VALUES(18, "Wendy Richard");
INSERT INTO accountholder VALUES(19, "Steve Walker");
INSERT INTO accountholder VALUES(20, "Emily Stacy");

--
-- Dumping data into table "Account"
--
INSERT INTO account VALUES(101, 987601, 1, "C", true, 2375.50); 
INSERT INTO account VALUES(102, 987601, 1, "S", true, 122.75); 
INSERT INTO account VALUES(103, 987602, 2, "C", true, 1263.34);
INSERT INTO account VALUES(104, 987602, 2, "S", false, 24.67);
INSERT INTO account VALUES(105, 987603, 3, "C", true, 76234.54);
INSERT INTO account VALUES(106, 987603, 3, "S", true, 1276.48);
INSERT INTO account VALUES(107, 987604, 4, "C", true, 34912.45);
INSERT INTO account VALUES(108, 987604, 4, "S", true, 934.46);
INSERT INTO account VALUES(109, 987605, 5, "C", false, 125693.52);
INSERT INTO account VALUES(110, 987605, 5, "S", true, 23.76); 
INSERT INTO account VALUES(111, 987606, 6, "C", true, 4328.47);
INSERT INTO account VALUES(112, 987606, 6, "S", true, 873.61);    
INSERT INTO account VALUES(113, 987607, 7, "C", true, 5725.62); 
INSERT INTO account VALUES(114, 987607, 7, "S", true, 16248.56); 
INSERT INTO account VALUES(115, 987608, 8, "C", true, 9236.27); 
INSERT INTO account VALUES(116, 987608, 8, "S", true, 1723.26); 
INSERT INTO account VALUES(117, 987609, 9, "C", false, 1274.87); 
-- INSERT INTO account VALUES(118, 987609, 9, "S", true, 2752.16); 
INSERT INTO account VALUES(119, 987610, 10, "C", true, 56123.36); 
INSERT INTO account VALUES(120, 987610, 10, "S", true, 34174.82); 
INSERT INTO account VALUES(121, 987611, 11, "C", false, 61245.62); 
INSERT INTO account VALUES(122, 987611, 11, "S", true, 9125.92); 
INSERT INTO account VALUES(123, 987612, 12, "C", true, 623.42); 
INSERT INTO account VALUES(124, 987612, 12, "S", false, 2789.13); 
INSERT INTO account VALUES(125, 987613, 13, "C", true, 28125.82); 
INSERT INTO account VALUES(126, 987613, 13, "S", true, 4512.49); 
INSERT INTO account VALUES(127, 987614, 14, "C", true, 71263.04); 
INSERT INTO account VALUES(128, 987614, 14, "S", true, 8236.01); 
INSERT INTO account VALUES(129, 987615, 15, "C", true, 72253.72); 
INSERT INTO account VALUES(130, 987615, 15, "S", false, 1282.92); 
INSERT INTO account VALUES(131, 987616, 16, "C", true, 4512.52); 
INSERT INTO account VALUES(132, 987616, 16, "S", true, 1794.67); 
INSERT INTO account VALUES(133, 987617, 17, "C", true, 13724.35); 
INSERT INTO account VALUES(134, 987617, 17, "S", true, 1368.26); 
INSERT INTO account VALUES(135, 987618, 18, "C", true, 7125.26); 
INSERT INTO account VALUES(136, 987618, 18, "S", false, 923.28); 
INSERT INTO account VALUES(137, 987619, 19, "C", true, 1475.61); 
INSERT INTO account VALUES(138, 987619, 19, "S", true, 9346.37); 
INSERT INTO account VALUES(139, 987620, 20, "C", true, 127.62); 
INSERT INTO account VALUES(140, 987620, 20, "S", false, 6124.15);      
INSERT INTO account VALUES(141, 987621, 4, "C", true, 726253.23);
INSERT INTO account VALUES(142, 987622, 15, "S", false, 74529.82);
INSERT INTO account VALUES(143, 987623, 17, "S", true, 21754.25);
INSERT INTO account VALUES(144, 987624, 17, "C", true, 63412.36);
INSERT INTO account VALUES(145, 987625, 9, "S", true, 54123.83);
INSERT INTO account VALUES(146, 987626, 11, "C", false, 983.21);
INSERT INTO account VALUES(147, 987627, 7, "S", true, 2.15);
INSERT INTO account VALUES(148, 987628, 13, "C", true, 0.24);
INSERT INTO account VALUES(149, 987629, 19, "S", true, 12.56);
INSERT INTO account VALUES(150, 987630, 5, "S", true, 14.52);
INSERT INTO account VALUES(151, 987631, 7, "C", false, 54.12);
INSERT INTO account VALUES(152, 987632, 16, "S", true, 231.23);


-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 

-- Use these two statements for debugging. 
-- Execute them in MySQLWorkbench or manually in the DOS window


SELECT * from AccountHolder where accountOwner = "Sam Smith";

SELECT * from account where ownerid = 1 and accounttype = 'C';

