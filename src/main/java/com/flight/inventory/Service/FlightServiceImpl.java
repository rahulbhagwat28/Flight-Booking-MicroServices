package com.flight.inventory.Service;

import com.flight.inventory.Mappers.FlightRowMapper;
import com.flight.inventory.Models.Flights;
import com.flight.inventory.Repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService{

    @Autowired
    private FlightRepository flightRepository;


    @Override
    public List<Flights> getAllFlights() {

        return flightRepository.getAllFlights();

    }
}
