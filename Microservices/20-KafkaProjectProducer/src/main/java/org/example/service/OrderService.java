package org.example.service;

import org.example.bindings.Orders;
import org.example.constant.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    KafkaTemplate<String,Orders> kafkaTemplate;
    public boolean buyOrder(Orders orders) {
        try{
            kafkaTemplate.send(AppConstant.TOPIC,orders.getOrderName(),orders);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
