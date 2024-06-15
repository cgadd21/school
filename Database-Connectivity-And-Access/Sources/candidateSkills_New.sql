-- Jim Habermas    -             Skill 8 is New
-- January 2023
-- ISTE 330                      Current
-- Modified Spring 2023          08  CyberSecurity
-- Modified Spring 2023 to drop the GROUP BY

-- SOURCE file is  -->   candidateSkills.sql
-- Contains THREE Tables/Entities 
-- <m:n>  cardinality ratio

DROP DATABASE IF EXISTS  candidateSkills; 

CREATE DATABASE candidateSkills;
USE candidateSkills;

DROP TABLE IF EXISTS  candidate;
CREATE TABLE candidate(
  candidate_ID INT UNSIGNED NOT NULL AUTO_INCREMENT,
  lastName VARCHAR(45) NOT NULL,
  firstName VARCHAR(45) NOT NULL,
  jobTitle VARCHAR(150) NULL,
  email VARCHAR(60) NULL,
  PRIMARY KEY (candidate_ID)
  )ENGINE=InnoDB DEFAULT CHARSET= utf8;
  
ALTER TABLE candidate AUTO_INCREMENT = 100;  
  
CREATE TABLE skills(
  skill_ID INT UNSIGNED NOT NULL AUTO_INCREMENT,
  skill VARCHAR(45) NOT NULL,
  PRIMARY KEY (skill_ID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE skills AUTO_INCREMENT = 1; 

DROP TABLE IF EXISTS candidate_skill;
CREATE TABLE candidate_skill(
candidate_ID INT UNSIGNED NOT NULL,
skill_ID    INT UNSIGNED NOT NULL,
PRIMARY KEY (candidate_ID, skill_ID),
CONSTRAINT candidate_skill_candidate_FK FOREIGN KEY (candidate_ID) 
      REFERENCES candidate(candidate_ID)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
      
 CONSTRAINT candidate_skill_skills_FK   FOREIGN KEY (skill_ID)    
       REFERENCES skills(skill_ID)
            ON DELETE CASCADE
            ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO skills VALUES (1, 'Pascal');
INSERT INTO skills VALUES (2, 'Java');
INSERT INTO skills VALUES (3, 'JDBC');
INSERT INTO skills VALUES (4, 'MySQL');
INSERT INTO skills VALUES (5, 'Python');
INSERT INTO skills VALUES (6, 'COBOL');
INSERT INTO skills VALUES (7, 'C');
INSERT INTO skills VALUES (8, 'CyberSecurity');
INSERT INTO skills VALUES (9, 'C++');
INSERT INTO skills VALUES (10, 'C#');
INSERT INTO skills VALUES (11, 'JavaScript');
INSERT INTO skills VALUES (12, 'PHP');
INSERT INTO skills VALUES (13, 'Ada');
INSERT INTO skills VALUES (14, "Ruby/Ruby on Rails");

INSERT INTO candidate(lastName,firstName,jobTitle,email)
            VALUES ("Habermas","Jim","Professor","Jim.Habermas@rit.edu");

INSERT INTO candidate(lastName,firstName,jobTitle,email)
             VALUES ("Bogaard","Dan","Department Head of Undergraduate Studies GCCIS","Dan.Bogaard@rit.edu");            

INSERT INTO candidate(lastName,firstName,email)
            VALUES ("Patric","David","David.Patric@rit.edu"); 
            
INSERT INTO candidate(lastName,firstName)
            VALUES ("Holden","Edward"); 

INSERT INTO candidate(lastName,firstName,jobTitle,email)
             VALUES ("Kang","Jai","Department Chair of Database","Jai.Kang@rit.edu");            


INSERT INTO candidate(lastName,firstName,jobTitle)
             VALUES ("Floeser","Michael","Professor"); 
             
INSERT INTO candidate(lastName,firstName,email)
             VALUES ("Burns","Jeff","Professor"); 

INSERT INTO candidate_skill VALUES (100, 1);
INSERT INTO candidate_skill VALUES (100, 2);
INSERT INTO candidate_skill VALUES (100, 3);
INSERT INTO candidate_skill VALUES (100, 4);
INSERT INTO candidate_skill VALUES (100, 5);
INSERT INTO candidate_skill VALUES (100, 6);
INSERT INTO candidate_skill VALUES (100, 7);
INSERT INTO candidate_skill VALUES (100, 8);
INSERT INTO candidate_skill VALUES (100, 9);
INSERT INTO candidate_skill VALUES (100, 10);
INSERT INTO candidate_skill VALUES (100, 11);
INSERT INTO candidate_skill VALUES (100, 12);
INSERT INTO candidate_skill VALUES (100, 13);
INSERT INTO candidate_skill VALUES (100, 14);


INSERT INTO candidate_skill VALUES (101, 3);
INSERT INTO candidate_skill VALUES (101, 9);
INSERT INTO candidate_skill VALUES (101, 10);
INSERT INTO candidate_skill VALUES (101, 11);
INSERT INTO candidate_skill VALUES (101, 12);
INSERT INTO candidate_skill VALUES (101, 13);
INSERT INTO candidate_skill VALUES (101, 14);


INSERT INTO candidate_skill VALUES (102, 2);
INSERT INTO candidate_skill VALUES (102, 3);
INSERT INTO candidate_skill VALUES (102, 4);
INSERT INTO candidate_skill VALUES (102, 5);
INSERT INTO candidate_skill VALUES (102, 12);
INSERT INTO candidate_skill VALUES (102, 13);
INSERT INTO candidate_skill VALUES (102, 14);

INSERT INTO candidate_skill VALUES (103, 2);
INSERT INTO candidate_skill VALUES (103, 3);
INSERT INTO candidate_skill VALUES (103, 4);
INSERT INTO candidate_skill VALUES (103, 5);
INSERT INTO candidate_skill VALUES (103, 6);
INSERT INTO candidate_skill VALUES (103, 7);
INSERT INTO candidate_skill VALUES (103, 14);

INSERT INTO candidate_skill VALUES (104, 14);
INSERT INTO candidate_skill VALUES (104, 13);
INSERT INTO candidate_skill VALUES (104, 12);
INSERT INTO candidate_skill VALUES (104, 11);
INSERT INTO candidate_skill VALUES (104, 10);
INSERT INTO candidate_skill VALUES (104, 9);
INSERT INTO candidate_skill VALUES (104, 8);
INSERT INTO candidate_skill VALUES (104, 7);
INSERT INTO candidate_skill VALUES (104, 6);
INSERT INTO candidate_skill VALUES (104, 5);
INSERT INTO candidate_skill VALUES (104, 4);

INSERT INTO candidate_skill VALUES (105, 8);
INSERT INTO candidate_skill VALUES (105, 9);
INSERT INTO candidate_skill VALUES (105, 10);
INSERT INTO candidate_skill VALUES (105, 11);
INSERT INTO candidate_skill VALUES (105, 12);
INSERT INTO candidate_skill VALUES (105, 13);
INSERT INTO candidate_skill VALUES (105, 14);

INSERT INTO candidate_skill VALUES (106, 1);
INSERT INTO candidate_skill VALUES (106, 14);
INSERT INTO candidate_skill VALUES (106, 08);

DROP PROCEDURE IF EXISTS get_candidate_skill;
DELIMITER $$
CREATE PROCEDURE get_candidate_skill(IN p_candidate_id INT)
BEGIN
	SELECT candidate.candidate_ID AS "ID", 
	        concat(lastName,", ", firstName) as "Candidate_Name",
	          group_concat(skills.skill separator' | ') AS "Skill"
	               From candidate JOIN candidate_skill USING(candidate_ID)
	                JOIN skills USING(skill_ID)
	                  WHERE candidate.candidate_ID = p_candidate_id
	                       GROUP BY candidate.candidate_ID;
END$$
DELIMITER ;

-- CALL get_candidate_skill(101);
-- CALL get_candidate_skill(106);

-- https://www.w3resource.com/mysql/mysql-procedure.php#MDST
-- https://www.tutorialspoint.com/How-can-local-variables-be-used-in-MySQL-stored-procedure

