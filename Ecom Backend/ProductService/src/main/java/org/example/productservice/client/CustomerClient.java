package org.example.productservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient("AUTHSERVICE")
public interface CustomerClient {
    @GetMapping("/customer/loggedInCustomer")
    public ResponseEntity<Integer> getLoggedInCustomer(@RequestHeader("Current_User") String email);
}
