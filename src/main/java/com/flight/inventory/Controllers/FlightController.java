package com.flight.inventory.Controllers;


import com.flight.inventory.Models.Flights;
import com.flight.inventory.Service.FlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class FlightController {


    private static final Logger logger= LoggerFactory.getLogger(FlightController.class);

    @Autowired
    FlightService flightService;

    @GetMapping("/flights")
    public ResponseEntity<List<Flights>> getFlights()
    {

            logger.info("getting all flights");

            List<Flights> flights = flightService.getAllFlights();

            if (flights.isEmpty()) {
                logger.info("Flights are empty");
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            } else {

                return ResponseEntity.ok(flights);
            }


    }
}
