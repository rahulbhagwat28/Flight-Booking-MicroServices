CREATE TABLE flights (

   id BIGINT AUTO_INCREMENT PRIMARY KEY,
   flight_number VARCHAR(50) NOT NULL,
   flight_name VARCHAR(50) NOT NULL,
   origin VARCHAR(3) NOT NULL,
   destination VARCHAR(3) NOT NULL,
   departureTime TIMESTAMP NOT NULL,
   arrivalTime TIMESTAMP NOT NULL,
   status VARCHAR(20) NOT NULL,
   seat_capacity INT NOT NULL,
   ticket_price DECIMAL(10,2) NOT NULL
 );

