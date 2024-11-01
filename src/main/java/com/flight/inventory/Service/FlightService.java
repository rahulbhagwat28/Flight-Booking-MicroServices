package com.flight.inventory.Service;

import com.flight.inventory.Models.Flights;
import com.flight.inventory.RequestBody.FlightRequest;

import java.util.List;

public interface FlightService {

    public List<Flights> getAllFlights();

    void addFlight(FlightRequest flights);

    public void updateFlightStatus();
}
