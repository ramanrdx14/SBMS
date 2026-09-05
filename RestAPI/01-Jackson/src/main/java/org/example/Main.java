package org.example;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(101,"jhon",100000.97);
        ConvertObjToJson convertObjToJson = new ConvertObjToJson();
        String json = convertObjToJson.convert(customer);
        System.out.println("JSON DATA "+json);

        ConvertJsonToObj convertJsonToObj = new ConvertJsonToObj();
        Customer derived = convertJsonToObj.convert(json);
        System.out.println("JAVA OBJ "+derived);

    }
}
