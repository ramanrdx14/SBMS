package org.example;

public class DebitCardPayment implements IPayment{
    public DebitCardPayment(){
        System.out.println("Debit Card Constructor Executed");
    }
    @Override
    public void pay() {
        System.out.println("Debit Card Payment");
    }
}
