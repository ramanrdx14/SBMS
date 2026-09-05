package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        httpSecurity.authorizeHttpRequests((authorize)->{
            authorize.requestMatchers("/welcome").permitAll()
                    .anyRequest()
                    .authenticated();
        }).httpBasic(Customizer.withDefaults())
          .formLogin(Customizer.withDefaults());

        return httpSecurity.build();

    }
    @Bean
    public InMemoryUserDetailsManager userDetails(){
        UserDetails raniUser = User
                                .builder()
                                .roles("Admin")
                                .username("rani")
                                .password("{noop}rani")
                                .build();

        UserDetails rajuUser = User
                .builder()
                .roles("Admin")
                .username("raju")
                .password("{noop}raju")
                .build();

        return new InMemoryUserDetailsManager(raniUser,rajuUser);
    }
}