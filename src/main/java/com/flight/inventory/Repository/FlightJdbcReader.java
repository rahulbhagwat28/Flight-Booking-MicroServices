package com.flight.inventory.Repository;

import com.flight.inventory.Models.Flights;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.List;

public class FlightJdbcReader implements ItemReader<Flights> {


    private  FlightRepository flightRepository;
    private Iterator<Flights> flightsIterator;

    public FlightJdbcReader(FlightRepository flightRepository)
    {
        this.flightRepository=flightRepository;
    }


    @Override
    public Flights read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if(flightsIterator==null) {
            List<Flights> flights=flightRepository.getAllFlights();
            flightsIterator=flights.iterator();
        }
        if(flightsIterator.hasNext()) {
            return flightsIterator.next();
        } else {
            return null;
        }
    }
}
