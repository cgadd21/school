USE travel;
DROP PROCEDURE IF EXISTS report01;
DELIMITER //
CREATE PROCEDURE report01()
BEGIN 
        
          SELECT date, tripNum, role,
            CONCAT((SUBSTR(name, INSTR(name, " ") + 1)),", ",
                    (LEFT(name, INSTR(name, " ")-1))
                   )
                AS "Staff_Name" from staff
                          ORDER BY Staff_Name;

END 
//
DELIMITER ;
-- SHOW CREATE procedure report01\G
call report01();