package org.example.service;

import org.example.bindings.Passenger;
import org.example.bindings.Ticket;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Collection;


@Service
public class TicketServiceImpl implements TIcketService{


    @Override
    public Ticket bookTicket(Passenger passenger) {
       String api = "http://localhost:8080/ticket/book";
         RestTemplate restTemplate = new RestTemplate();
         ResponseEntity<Ticket> ticketResponseEntity = restTemplate.postForEntity(api, passenger, Ticket.class);
         return ticketResponseEntity.getBody();
    }

    @Override
    public Collection<Ticket> getAllTicket() {
         String api = "http://localhost:8080/ticket/all";
         RestTemplate restTemplate = new RestTemplate();
         ResponseEntity<Ticket[]> ticketResponseEntity = restTemplate.getForEntity(api, Ticket[].class);
         return Arrays.asList(ticketResponseEntity.getBody());
    }


    //Using Web-client
    @Override
    public Mono<Ticket> bookTicketMono(Passenger passenger) {
        String api = "http://localhost:8080/ticket/book";
        WebClient webClient = WebClient.create();
        return webClient.post()
                .uri(api)
                .bodyValue(passenger)
                .retrieve()
                .bodyToMono(Ticket.class);
    }

    @Override
    public Mono<Ticket[]> getAllTicketMono() {
        WebClient webClient = WebClient.create();
        String api = "http://localhost:8080/ticket/all";
        return webClient.get()
                .uri(api)
                .retrieve()
                .bodyToMono(Ticket[].class);
    }
}
