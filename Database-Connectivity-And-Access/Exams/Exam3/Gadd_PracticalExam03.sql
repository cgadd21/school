-- Name: Gadd, Cooper
-- Class: ISTE330
-- Date: 11/8/2023
-- Practical 03
-- Professor Habermas

use candidateskills;
DROP PROCEDURE IF EXISTS get_candidate_points;
DELIMITER //
CREATE PROCEDURE get_candidate_points(IN p_candidate_ID INT)
    BEGIN
        SELECT IFNULL(COUNT(skill_ID),0) + SUM(CASE WHEN skill_ID IN (2,3) THEN 1 WHEN skill_ID IN (9,10) THEN 2 ELSE 0 END) AS POINTS
        FROM candidate_skill 
        WHERE candidate_ID = p_candidate_ID;
    END;
//
DELIMITER ;