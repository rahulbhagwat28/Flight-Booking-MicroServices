

INSERT INTO flights (flight_number,flight_name,origin,destination,departureTime,arrivalTime,status,seat_capacity,ticket_price)
VALUES ('A101','American Airlines','IAD','STL',PARSEDATETIME(FORMATDATETIME(CURRENT_DATE, 'yyyy-MM-dd') || ' 16:00:00', 'yyyy-MM-dd HH:mm:ss'), PARSEDATETIME(FORMATDATETIME(CURRENT_DATE, 'yyyy-MM-dd') || ' 18:00:00', 'yyyy-MM-dd HH:mm:ss'),'ONTIME',20,299.9);



INSERT INTO flights (flight_number,flight_name,origin,destination,departureTime,arrivalTime,status,seat_capacity,ticket_price)
VALUES ('D101','Delta','IAD','STL',PARSEDATETIME(FORMATDATETIME(CURRENT_DATE, 'yyyy-MM-dd') || ' 16:00:00', 'yyyy-MM-dd HH:mm:ss'), PARSEDATETIME(FORMATDATETIME(CURRENT_DATE, 'yyyy-MM-dd') || ' 18:00:00', 'yyyy-MM-dd HH:mm:ss'),'ONTIME',20,499.9);