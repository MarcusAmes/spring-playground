package com.example.demo;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Ticket {
    private int price;
    private Passenger passenger;

    @JsonGetter("Price")
    public int getPrice() {
        return price;
    }

    @JsonSetter("price")
    public void setPrice(int price) {
        this.price = price;
    }

    @JsonGetter("Passenger")
    public Passenger getPassenger() {
        return passenger;
    }

    @JsonSetter("passenger")
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
