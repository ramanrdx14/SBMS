package org.example.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

@Service
public class MyService {
    public void callCatFacts(){
        System.out.println("API - Call Starts ++++++++");
        String API_URI = "https://catfact.ninja/fact";
        WebClient webClient = WebClient.create();
        Disposable accept = webClient.get()
                .uri(API_URI)
                .header("Accept", "application/json")
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(MyService::handleResponse);// asynchronous call with the help of subscriber

        System.out.println("API - Call Ends  ++++++++");
    }
    public static void handleResponse(String s){
        System.out.println(s);
    }
}
