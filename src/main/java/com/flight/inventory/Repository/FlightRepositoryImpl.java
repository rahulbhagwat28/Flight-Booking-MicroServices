package com.flight.inventory.Repository;



import com.flight.inventory.Enums.FlightStatus;
import com.flight.inventory.Mappers.FlightRowMapper;
import com.flight.inventory.Models.Flights;

import com.flight.inventory.RequestBody.FlightRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Repository
public class FlightRepositoryImpl implements FlightRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    // Today's date at 4 PM as String
    String departureTimestamp = LocalDateTime.of(LocalDate.now(), LocalTime.of(16, 0)).format(formatter);

    // Today's date at 6 PM as String
    String arrivalTimestamp = LocalDateTime.of(LocalDate.now(), LocalTime.of(18, 0)).format(formatter);

    private String getQuery="SELECT * from flights";
    private String insertQuery= "INSERT INTO flights (flight_number,flight_name,origin" +
            ",destination,departureTime,arrivalTime,status,seat_capacity,ticket_price)"+
            "VALUES (?,?,?,?,?,?,?,?,?)";
    private String updateQuery="UPDATE flights SET status = ? WHERE id=?";

    private static final Logger logger= LoggerFactory.getLogger(FlightRepositoryImpl.class);

    @Override
    public List<Flights> getAllFlights() {


        logger.info("getting all flights from the database");
        return jdbcTemplate.query(getQuery,new FlightRowMapper());

    }

    @Override
    public void addFlight(FlightRequest flights) {

        Flights flightEntity=new Flights();
        logger.info("inserting records in the DB");

        flightEntity.setFlight_number(flights.getFlight_number());
        flightEntity.setFlight_name(flights.getFlight_name());
        flightEntity.setOrigin(flights.getOrigin());
        flightEntity.setDestination(flights.getDestination());
        flightEntity.setStatus(flights.getStatus());
        flightEntity.setSeat_capacity(flights.getSeat_capacity());
        flightEntity.setTicket_price(flights.getTicket_price());

        System.out.println(insertQuery);

         jdbcTemplate.update(insertQuery,
                flightEntity.getFlight_number(),
                flightEntity.getFlight_name(),
                flightEntity.getOrigin(),
                flightEntity.getDestination(),
                departureTimestamp,
                arrivalTimestamp,
                flightEntity.getStatus().name(),
                flightEntity.getSeat_capacity(),
                flightEntity.getTicket_price());


    }

    @Override
    public void updateFlightStatus(Long flightId, FlightStatus status) {

        logger.info("Updating flight status for id {}",flightId);
        jdbcTemplate.update(updateQuery,status.name(),flightId);

    }
}
