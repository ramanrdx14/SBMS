package in.rdx;

public class PaymentProcessor {
    IPayment payment;
    public PaymentProcessor(IPayment payment) {
        this.payment = payment;
    }

    public PaymentProcessor(){}

    public void setPayment(IPayment payment) {
        this.payment = payment;
    }

    public void processPayment(double amount){
        payment.pay(amount);
    }
}
