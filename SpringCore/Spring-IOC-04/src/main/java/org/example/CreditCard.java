package org.example;

public class CreditCard implements IPayment{
    public CreditCard(){
        System.out.println("Credit Card Constructor Executed");
    }
    @Override
    public void pay() {
        System.out.println("Credit Card Payment");
    }
}
