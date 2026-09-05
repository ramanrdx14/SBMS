package org.example.service;

import org.example.binding.Passenger;
import org.example.binding.Ticket;

import java.util.Collection;

public interface TicketService {
    public Ticket bookTicket(Passenger passenger);
    public Collection<Ticket> getAllTickets();
}
