package com.flight.inventory.Mappers;

import com.flight.inventory.Enums.FlightStatus;
import com.flight.inventory.Models.Flights;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FlightRowMapper implements RowMapper {


    @Override
    public Flights mapRow(ResultSet rs, int rowNum) throws SQLException {
        Flights flights=new Flights();
        flights.setId(rs.getLong("id"));
        flights.setFlight_number(rs.getString("flight_number"));
        flights.setFlight_name(rs.getString("flight_name"));
        flights.setOrigin(rs.getString("origin"));
        flights.setDestination(rs.getString("destination"));
        flights.setStatus(FlightStatus.valueOf(rs.getString("status")));
        flights.setSeat_capacity(rs.getInt("seat_capacity"));
        flights.setTicket_price(rs.getDouble("ticket_price"));

        return flights;
    }
}

