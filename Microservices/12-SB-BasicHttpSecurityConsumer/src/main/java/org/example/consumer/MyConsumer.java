package org.example.consumer;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class MyConsumer {
    @GetMapping("/getgreet")
    public String getResponse(){
        String url = "http://localhost:8080/greet?user={user}";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBasicAuth("user","f9446cc6-5226-48e8-b822-b530bf7a3a79");
        HttpEntity<Void> entity = new HttpEntity<>(httpHeaders);
        String body = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                String.class,
                "user"
        ).getBody();

        return body;
    }
    @GetMapping("/welcome")
    public String getWelcome(){
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("user","f9446cc6-5226-48e8-b822-b530bf7a3a79");
        String url = "http://localhost:8080/greet?user={user}";
        WebClient webClient = WebClient.create();
        webClient.get()
                .uri(url)
                .headers(httpHeaders -> headers.setBasicAuth("user","f9446cc6-5226-48e8-b822-b530bf7a3a79"))

    }
}
