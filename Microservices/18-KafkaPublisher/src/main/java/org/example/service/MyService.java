package org.example.service;

import org.example.bindings.Orders;
import org.example.constant.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    @Autowired
    KafkaTemplate<String,Orders> kafkaTemplate;

    public String sendMessage(Orders orders){
        kafkaTemplate.send(AppConstants.TOPIC,orders);
        return  "Msg Send Successfully ";
    }
}
