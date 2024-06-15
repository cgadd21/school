-- Gadd, Cooper
-- 9/10/2023
-- ISTE 330.02
-- HW#01

SELECT "ISTE 330.02", "HW01" AS "Student Gadd", NOW() AS "Date working on HW01";

-- Students: Replace "Student LastName" with your own Lastname.

-- ISTE-330 Database Connectivity and Access
-- HW01 - SQL review


USE travel;
-- Opened Database Travel;     Script travelnew29.sql

-- 1.

SELECT "Question 01" AS "HW01 ISTE330";
SELECT '1.What are the names and complete addresses of all passengers listed in order by last name? Please use the concat function and put the name in the format Lastname, Firstname.  Also match the column headings.' AS 'QUESTION 1';

SELECT CONCAT(LName,', ',FName) AS 'Passenger',street,city,zips.State,zip
FROM travel.passenger
JOIN travel.zips USING (Zip)
ORDER BY LName;

-- 2.	

SELECT "Question 02" AS "HW01 ISTE330";
SELECT '2. What are the trip numbers, departure times, and departure locations code for all bus trips?' AS 'QUESTION 2';

SELECT tripnum,departuretime,departureloccode
FROM travel.trip_directory
JOIN travel.tripcodes USING (TripType)
WHERE TypeName = 'Bus';

-- 3.	
SELECT '3. What are the names of the passengers who are traveling in October?' AS 'QUESTION 3';

SELECT CONCAT(LName,', ',FName) AS 'Passenger'
FROM travel.trip_people
JOIN travel.passenger USING (PassengerID)
WHERE MONTH(Date) = 10;

-- 4.	
SELECT '4. How many trips in the trip directory leave from each city?' AS 'QUESTION 4';

SELECT Location, COUNT(DepartureLocCode) AS 'Number of Departures'
FROM travel.trip_directory
JOIN travel.locations ON locations.LocationCode = trip_directory.DepartureLocCode
GROUP BY locations.Location,trip_directory.DepartureLocCode
ORDER BY locations.Location DESC;

-- 5.	
SELECT '5. Who, if anyone, is working the Rochester trip to Buffalo during September 2017?' AS 'QUESTION 5';

SELECT name
FROM travel.staff
JOIN travel.trip USING (tripnum)
JOIN travel.locations ON locations.LocationCode = trip.ArrivalLocCode
WHERE Location = 'Buffalo'
AND MONTH(staff.date) = 9
AND YEAR(staff.date) = 2017;

-- 6.	
SELECT '6. Greg Zalewski who works for Rides ‘R’ Us is from Framingham. Who, if anyone, will he meet from his town when he works on a trip, and during what trip number?' AS 'QUESTION 6';

SELECT tripnum, CONCAT(FName,' ',LName) AS 'People from Framingham'
FROM travel.trip_people
JOIN travel.passenger USING (PassengerID)
JOIN travel.zips USING (Zip)
JOIN travel.staff USING (TripNum)
WHERE zips.city = 'Framingham'
AND staff.name = 'Greg Zalewski';

-- 7.
SELECT '7.What people from Rochester, travel by bus?' AS 'QUESTION 7';

SELECT fname, lname
FROM travel.trip_directory
JOIN travel.tripcodes USING (TripType)
JOIN travel.trip_people USING (TripNum)
JOIN travel.passenger USING (PassengerID)
JOIN travel.zips USING (Zip)
WHERE TypeName = 'Bus'
AND city = 'Rochester';
    
-- 8.
SELECT '8. What is the description of the equipment on which Rich Gleason travels?' AS 'QUESTION 8';

SELECT equipmentdescription
FROM travel.trip
JOIN travel.equipment USING (EquipId)
JOIN travel.trip_people USING (TripNum)
JOIN travel.passenger USING (PassengerID)
WHERE fname = 'Rich'
AND lname = 'Gleason';
    
-- 9.	
SELECT '9.Who are the passengers that travel by plan and depart from �Buffalo�? Organize the output in ascending alphabetical order by passenger�s last name.  You must match the two columns and the actual column headings.' AS 'QUESTION 9';

SELECT Location AS 'Departure Location',CONCAT(lname,', ',fname) AS 'Passanger'
FROM travel.trip
JOIN travel.locations ON locations.LocationCode = trip.DepartureLocCode
JOIN travel.trip_people USING (TripNum)
JOIN travel.passenger USING (PassengerID)
JOIN travel.trip_directory USING (TripNum)
JOIN travel.tripcodes USING (TripType)
WHERE Location = 'Buffalo'
AND typename = 'Plane'
ORDER BY lname;
    
-- 10.	
SELECT '10. On which scheduled flights might there be people with cell phones?' AS 'QUESTION 10';

SELECT tripnum,trip.date AS 'date'
FROM travel.trip
JOIN travel.trip_directory USING (TripNum)
JOIN travel.tripcodes USING (TripType)
JOIN travel.trip_people USING (TripNum)
JOIN travel.passenger USING (PassengerID)
JOIN travel.phones USING (PassengerID)
WHERE TypeName = 'Plane'
AND PhoneType = 'Cell'
GROUP BY tripnum, trip.date;
    
-- 11.	
SELECT '11. On how many trips has each piece of equipment been used? Organize the output in ascending alphabetical order ' AS 'QUESTION 11';

SELECT equipmentname,equipid,COUNT(TripNum) AS 'NumTrips'
FROM travel.equipment
LEFT JOIN travel.trip USING (EquipId)
GROUP BY equipmentname,equipid
ORDER BY equipmentname;

-- 12.	
SELECT '12. What equipment has never been used on a trip?' AS 'QUESTION 12';

SELECT equipid,equipmentname,COUNT(TripNum) AS 'NumTrips'
FROM travel.equipment
LEFT JOIN travel.trip USING (EquipId)
GROUP BY equipmentname, equipid
HAVING COUNT(TripNum) = 0
ORDER BY equipmentname;
   
-- 13.	
SELECT '13. During the period of 9/1/2017 through 10/31/2017, what types of transportation had more than 1 trip?' AS 'QUESTION 13';

SELECT typename, COUNT(TripNum) AS 'NumTrips'
FROM travel.trip
JOIN travel.trip_directory USING (TripNum)
JOIN travel.tripcodes USING (TripType)
WHERE TypeName = 'Plane'
AND trip.date BETWEEN '2017-09-01' AND '2017-10-31'
GROUP BY typename;
