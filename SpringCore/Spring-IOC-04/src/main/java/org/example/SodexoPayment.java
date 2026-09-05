package org.example;

public class SodexoPayment implements IPayment{
    public SodexoPayment(){
        System.out.println("Sodexo Constructor Executed");
    }
    @Override
    public void pay() {
        System.out.println("Sodexo Payment");
    }
}
