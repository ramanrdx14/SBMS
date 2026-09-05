package org.example.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.example.bindings.Orders;
import org.example.constant.AppConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JacksonJsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MyAppConfig {

    @Bean
    public ProducerFactory<String, Orders> producerFactory(){

        Map<String,Object> map = new HashMap<>();

        map.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConstant.HOST);
        map.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        map.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JacksonJsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(map,new StringSerializer(),new JacksonJsonSerializer());
    }

    @Bean
    public KafkaTemplate<String,Orders> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }
}
