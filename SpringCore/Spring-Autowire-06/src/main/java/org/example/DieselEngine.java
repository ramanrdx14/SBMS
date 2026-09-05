package org.example;

public class DieselEngine implements Engine{
    DieselEngine(){
        System.out.println("Diesel Engine object created");
    }
    @Override
    public void start() {
        System.out.println("Diesel Engine");
    }
}
