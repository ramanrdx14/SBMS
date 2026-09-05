package org.example.controller;

import org.example.binding.Passenger;
import org.example.binding.Ticket;
import org.example.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/ticket")
public class MyRestController {
    @Autowired
    TicketService ticketService;

    @PostMapping("/book")
    public ResponseEntity<Ticket> bookTicket(@RequestBody Passenger passenger){
        Ticket ticket = ticketService.bookTicket(passenger);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<Collection<Ticket>> getAllTicket(){
        return new ResponseEntity<>(ticketService.getAllTickets(),HttpStatus.OK);
    }
}
