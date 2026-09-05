package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Eagerly Loading & Lazy loading

        ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
        PaymentProcessor pp = context.getBean(PaymentProcessor.class);
        pp.processPayment();

    }
}