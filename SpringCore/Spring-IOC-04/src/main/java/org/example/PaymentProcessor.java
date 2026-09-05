package org.example;

public class PaymentProcessor {
    IPayment payment;

    public PaymentProcessor(){
        System.out.println("PaymentProcessor Constructor Executed");
    }
    public PaymentProcessor(IPayment payment){
        this.payment = payment;
    }

    public void setPayment(IPayment payment) {
        this.payment = payment;
    }

    public void processPayment(){
        payment.pay();
    }
}
