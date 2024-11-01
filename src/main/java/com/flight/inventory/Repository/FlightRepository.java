package com.flight.inventory.Repository;


import com.flight.inventory.Enums.FlightStatus;
import com.flight.inventory.Mappers.FlightRowMapper;
import com.flight.inventory.Models.Flights;
import com.flight.inventory.RequestBody.FlightRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface FlightRepository {

     List<Flights> getAllFlights();

     void addFlight(FlightRequest flights);

     void updateFlightStatus(Long flightId, FlightStatus status);







}
