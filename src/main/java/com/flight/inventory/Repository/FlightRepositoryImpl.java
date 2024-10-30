package com.flight.inventory.Repository;

import com.flight.inventory.Controllers.FlightController;
import com.flight.inventory.Mappers.FlightRowMapper;
import com.flight.inventory.Models.Flights;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FlightRepositoryImpl implements FlightRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String getQuery="SELECT * from flights";

    private static final Logger logger= LoggerFactory.getLogger(FlightRepositoryImpl.class);

    @Override
    public List<Flights> getAllFlights() {


        logger.info("getting all flights from the database");
        return jdbcTemplate.query(getQuery,new FlightRowMapper());

    }
}
