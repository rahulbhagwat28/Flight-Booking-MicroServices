package com.flight.inventory.Repository;

import com.flight.inventory.Models.Flights;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FlightJdbcWriter implements ItemWriter<Flights> {


    private FlightRepository flightRepository;

    public FlightJdbcWriter(FlightRepository flightRepository) {
        this.flightRepository=flightRepository;
    }


    @Override
    public void write(Chunk<? extends Flights> flights) throws Exception {
        for (Flights flight:flights) {
            flightRepository.updateFlightStatus(flight.getId(),flight.getStatus());
        }
    }
}
