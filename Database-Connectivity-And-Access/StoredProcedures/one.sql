USE travel;
delimiter //
CREATE PROCEDURE sample01()
   BEGIN
	   SELECT date, tripNum, role, name AS "Staff_Name"  from staff
                ORDER BY Staff_Name;
   END;
//
delimiter ;
call sample01();  