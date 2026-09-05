package org.example.service;

import org.example.binding.Passenger;
import org.example.binding.Ticket;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TicketServiceImpl implements TicketService{
    private Map<Integer,Ticket> map = new HashMap<>();
    @Override
    public Ticket bookTicket(Passenger passenger) {
        Ticket ticket = new Ticket();
        Random random = new Random();
        int tno       = random.nextInt(1000);
        ticket.setTicketNo(tno);
        ticket.setDoj(passenger.getDoj());
        ticket.setEmail(passenger.getEmail());
        ticket.setFrom(passenger.getFrom());
        ticket.setTo(passenger.getTo());
        ticket.setTrainNo(passenger.getTrainNo());

        map.put(tno,ticket);
        return ticket;
    }

    @Override
    public Collection<Ticket> getAllTickets() {
        return map.values();
    }
}
