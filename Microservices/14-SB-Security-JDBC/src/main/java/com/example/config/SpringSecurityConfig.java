package com.example.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    @Autowired
    private DataSource dataSource;

    @Autowired
    public void JdbcAuth(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(new BCryptPasswordEncoder())
                .usersByUsernameQuery("select user_name,user_password,true from users where user_name = ?")
                .authoritiesByUsernameQuery("select u.user_name,r.role_name from users u join user_roles ur on u.user_id = ur.user_id join roles r on ur.role_id = r.role_id where u.user_name = ?");
    }
    @Bean
   public SecurityFilterChain securityFilter(HttpSecurity security) throws Exception {
       security.csrf(csrf->csrf.disable())
               .authorizeHttpRequests(auth->{
                auth.requestMatchers("/swagger-ui/**",
                                        "/v3/api-docs/**",
                                        "/user/add",
                                        "/user/all")
                  .permitAll()
                        .requestMatchers("/user/admin/**").hasAuthority("admin")
                        .requestMatchers("/user/welcome/**").hasAuthority("user")
                        .anyRequest().authenticated();

      }).httpBasic(Customizer.withDefaults());
      return security.build();
   }
}