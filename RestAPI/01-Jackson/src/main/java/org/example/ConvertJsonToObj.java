package org.example;

import tools.jackson.databind.ObjectMapper;

public class ConvertJsonToObj {
    public Customer convert(String json){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json,Customer.class);
    }
}
