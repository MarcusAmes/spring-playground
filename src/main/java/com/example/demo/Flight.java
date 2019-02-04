package com.example.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.Date;
import java.util.List;

public class Flight {
    private Date departs;
    private List<Ticket> tickets;

    @JsonGetter("Departs")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    public Date getDeparts() {
        return departs;
    }

    @JsonSetter("departs")
    public void setDeparts(Date departs) {
        this.departs = departs;
    }

    @JsonGetter("Tickets")
    public List<Ticket> getTickets() {
        return tickets;
    }

    @JsonSetter("tickets")
    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "departs=" + departs +
                ", tickets=" + tickets +
                '}';
    }
}
