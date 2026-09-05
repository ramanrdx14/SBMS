package org.example.controller;

import org.example.bindings.Passenger;
import org.example.bindings.Ticket;
import org.example.service.TIcketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import reactor.core.publisher.Mono;

import java.util.Collection;


@Controller
public class MyController {
    @Autowired
    TIcketService tIcketService;

    @GetMapping("/booknow")
    public String ticketInfo(Model model){
        model.addAttribute("passenger",new Passenger());
        return "passenger";
    }
    @GetMapping("/all")
    public String getAllTicket(Model model){
        Mono<Ticket[]> allTicket = tIcketService.getAllTicketMono();
        model.addAttribute("ticketlist",allTicket);
        return "viewticket";
    }

    @PostMapping("/bookticket")
    public String bookTicket(Passenger passenger,Model model){
        Mono<Ticket> ticket = tIcketService.bookTicketMono(passenger);
        model.addAttribute("status","Ticket Booked Successfully");
        model.addAttribute("ticket",ticket);
        model.addAttribute("passenger",new Passenger());
        return "passenger";
    }
}
