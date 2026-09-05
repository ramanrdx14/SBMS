package in.rdx.test;


import in.rdx.beans.Car;
import in.rdx.beans.DieselEngine;
import in.rdx.beans.PetrolEngine;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
        System.out.println("++++++++++++++++++ IOC ++++++++++++++++++");
        Car car = context.getBean(Car.class);
        car.drive();
    }
}