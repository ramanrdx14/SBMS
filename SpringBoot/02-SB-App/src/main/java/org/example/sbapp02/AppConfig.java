package org.example.sbapp02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public  CreateAppSecurity getSecurityObj(){
        return new CreateAppSecurity();
    }
}
