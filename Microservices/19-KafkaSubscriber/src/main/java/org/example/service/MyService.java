package org.example.service;

import org.example.bindings.Orders;
import org.example.constants.AppConstants;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
public class MyService {
    @KafkaListener(topics = AppConstants.TOPIC,groupId = "raman_order_id")
    public void subscribeMessage(String order){
        System.out.println(":::: Message Recieved +++++++++");
        ObjectMapper objectMapper = new ObjectMapper();
        Orders orders = objectMapper.readValue(order, Orders.class);
        System.out.println(orders.getOrderName());
    }
}
