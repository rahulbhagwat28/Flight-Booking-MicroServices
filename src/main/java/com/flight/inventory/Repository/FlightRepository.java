package com.flight.inventory.Repository;


import com.flight.inventory.Mappers.FlightRowMapper;
import com.flight.inventory.Models.Flights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface FlightRepository {

    public List<Flights> getAllFlights();




}