package org.example.service;

import org.example.bindings.Passenger;
import org.example.bindings.Ticket;
import reactor.core.publisher.Mono;

import java.util.Collection;

public interface TIcketService {
    public Ticket bookTicket(Passenger passenger);
    public Collection<Ticket> getAllTicket();
    public Mono<Ticket> bookTicketMono(Passenger passenger);
    public Mono<Ticket[]> getAllTicketMono();
}
