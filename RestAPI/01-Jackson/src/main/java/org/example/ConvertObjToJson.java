package org.example;

import tools.jackson.databind.ObjectMapper;

public class ConvertObjToJson {

    public String convert(Customer customer){
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(customer);
        return json;
    }

}
