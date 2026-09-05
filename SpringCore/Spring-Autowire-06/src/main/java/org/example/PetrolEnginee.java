package org.example;

public class PetrolEnginee implements Engine{
    PetrolEnginee(){
        System.out.println("Petrol Engine object created");
    }
    @Override
    public void start() {
        System.out.println("Petrol Engine");
    }
}
