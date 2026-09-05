package org.example.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.example.bindings.Orders;
import org.example.constant.AppConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JacksonJsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MyAppConfig {
        @Bean
        public ConsumerFactory<String, Orders> consumerFactory(){
            Map<String,Object> map = new HashMap<>();
            map.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConstant.HOST);
            map.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
            map.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JacksonJsonDeserializer.class);
            map.put(JacksonJsonDeserializer.TRUSTED_PACKAGES, "org.example.bindings");
            return new DefaultKafkaConsumerFactory<>(map,new StringDeserializer(),new JacksonJsonDeserializer<>(Orders.class));
        }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,Orders> concurrentKafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String,Orders> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setConcurrency(AppConstant.PARTITIONS);
        return factory;
    }
}
