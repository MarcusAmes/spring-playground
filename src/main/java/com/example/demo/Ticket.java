package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ticket {
    private int price;
    private Passenger passenger;

    @JsonProperty("Price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @JsonProperty("Passenger")
    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
