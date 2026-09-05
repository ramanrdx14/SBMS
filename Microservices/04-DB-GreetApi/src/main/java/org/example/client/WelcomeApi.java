package org.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "03-SB-WelcomeApi")
public interface WelcomeApi {
    @GetMapping("/welcome")
    public String getWelcomeData();
}
