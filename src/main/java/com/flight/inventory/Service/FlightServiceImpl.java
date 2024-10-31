package com.flight.inventory.Service;

import com.flight.inventory.Controllers.FlightController;
import com.flight.inventory.Exception.ValidationException;
import com.flight.inventory.Mappers.FlightRowMapper;
import com.flight.inventory.Models.Flights;
import com.flight.inventory.Repository.FlightRepository;
import com.flight.inventory.RequestBody.FlightRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService{

    @Autowired
    private FlightRepository flightRepository;


    private static final Logger logger= LoggerFactory.getLogger(FlightServiceImpl.class);


    @Override
    public List<Flights> getAllFlights() {

        return flightRepository.getAllFlights();

    }

    @Override
    public void addFlight(FlightRequest flights) {


        if(flights.getFlight_number()==null || flights.getFlight_number().isEmpty()) {
            logger.error("{} should not be empty",flights.getFlight_number());
            throw new ValidationException("Flight number should not be empty");
        }

        if(flights.getFlight_name().isEmpty() || flights.getFlight_name()==null) {
            logger.error("{} should not be empty",flights.getFlight_name());
            throw new ValidationException("Flight name should not be empty");
        }



        if(flights.getOrigin().length()>3 || flights.getDestination().length()>3)
        {
            logger.error("{} or {} should not be more than 3 characters",flights.getOrigin(),flights.getDestination());
            throw new ValidationException("Flight origin or destination should not be more than 3 characters");
        }

        if(flights.getSeat_capacity()>20)
        {
            logger.error("{} should not be greater than 20",flights.getSeat_capacity());
            throw new ValidationException("Flight capacity should not be greater than 20");

        }


        flightRepository.addFlight(flights);



    }


}
