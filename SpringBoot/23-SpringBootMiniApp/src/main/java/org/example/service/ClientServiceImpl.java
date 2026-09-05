package org.example.service;

import org.example.entity.Client;
import org.example.repo.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClinetService{
    @Autowired
    ClientRepo clientRepo;

    @Autowired
    JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    String sender;

    @Override
    public void saveClientDetails(Client client) {
        clientRepo.save(client);
    }
    public Client findByEmail(String email){
        return clientRepo.findByEmail(email);
    }
    public void sendEmail(String client){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender);
        message.setTo(client);
        message.setSubject("Course Enrolled !!");
        message.setText("Thanks For Enrollment "+client);
        mailSender.send(message);
    }
}
