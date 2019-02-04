package com.example.demo;

import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightsController {

    @GetMapping("/flight")
    public Flight getFlight() {
        Flight flight = new Flight();
        flight.setDeparts(new Date());

        Ticket ticket = new Ticket();
        ticket.setPrice(200);
        Passenger passenger = new Passenger();
        passenger.setFirstName("Some name");
        passenger.setLastName("Some other name");
        ticket.setPassenger(passenger);
        flight.setTickets(Arrays.asList(ticket));
        return flight;
    }

    class Result {
        private int result;

        public int getResult() {
            return result;
        }

        void setResult(int result) {
            this.result = result;
        }
    }

    @PostMapping("/tickets/total")
    public Result getTickets(@RequestBody Flight flight) {
        int total = 0;
        for (Ticket ticket : flight.getTickets()) {
            total += ticket.getPrice();
        }

        Result result = new Result();
        result.setResult(total);

        return result;
    }

    @GetMapping(value = {"", "/"})
    public List<Flight> getFlights() {
        Flight flight = new Flight();
        flight.setDeparts(new Date());

        Ticket ticket = new Ticket();
        ticket.setPrice(200);
        Passenger passenger = new Passenger();
        passenger.setFirstName("Some name");
        passenger.setLastName("Some other name");
        ticket.setPassenger(passenger);
        flight.setTickets(Arrays.asList(ticket));

        Flight flight2 = new Flight();
        flight2.setDeparts(new Date());

        Ticket ticket2 = new Ticket();
        ticket2.setPrice(400);
        Passenger passenger2 = new Passenger();
        passenger2.setFirstName("Some other name");
        ticket2.setPassenger(passenger2);
        flight2.setTickets(Arrays.asList(ticket2));
        return Arrays.asList(flight, flight2);
    }
}
