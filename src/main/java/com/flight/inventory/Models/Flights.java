package com.flight.inventory.Models;


import com.flight.inventory.Enums.FlightStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flights {

    private Long id;
    private String flight_number;
    private String flight_name;
    private String origin;
    private String destination;
    private FlightStatus status;
    private int seat_capacity;
    private double ticket_price;

}



