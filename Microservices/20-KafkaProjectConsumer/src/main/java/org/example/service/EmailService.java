package org.example.service;

import org.example.bindings.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    JavaMailSender javaMailSender;
    public void sendMail(Orders orders){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(orders.getEmail());
        mailMessage.setSubject("Order Processed Successfully "+orders.getOrderId());
        mailMessage.setText(orders.getMessageBody());

        javaMailSender.send(mailMessage);
    }
}
