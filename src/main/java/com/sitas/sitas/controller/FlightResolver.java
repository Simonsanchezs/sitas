package com.sitas.sitas.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import com.sitas.sitas.service.FlightService;
import com.sitas.sitas.model.Flight;

import java.time.LocalDate;
import java.util.List;

@Controller
public class FlightResolver {

    @Autowired
    private FlightService flightService;

    @QueryMapping
    public List<Flight> findFlights(@Argument String startDate,
                                    @Argument String endDate,
                                    @Argument String origin,
                                    @Argument String destination,
                                    @Argument String baggageType,
                                    @Argument String classType,
                                    @Argument Integer maxPassengers,
                                    @Argument Double maxPrice) {

        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);

        return flightService.findFlights(start, end, origin, destination, baggageType, classType, maxPassengers, maxPrice);
    }
}