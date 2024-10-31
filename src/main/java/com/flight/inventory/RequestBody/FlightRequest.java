package com.flight.inventory.RequestBody;

import com.flight.inventory.Enums.FlightStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightRequest {

    private String flight_number;
    private String flight_name;
    private String origin;
    private String destination;
    private FlightStatus status;
    private int seat_capacity;
    private double ticket_price;
}
