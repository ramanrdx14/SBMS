package org.example.service;

import org.example.bindings.Orders;
import org.example.constant.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {
    @Autowired
    EmailService emailService;
    @KafkaListener(topics = AppConstant.TOPIC,groupId = "my-group-v1" , containerFactory = "concurrentKafkaListenerContainerFactory")
    public void getOrders(Orders orders){
        System.out.println(" Email :::: "+orders.getEmail());
        emailService.sendMail(orders);
        System.out.println("++++++++ Messege Recieved Sucessfully ++++++++");
    }
}
