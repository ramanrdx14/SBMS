package in.rdx;

public class Test {
    public static void main(String[] args) {
        //Constructor injection
        PaymentProcessor pp1 = new PaymentProcessor(new CreditCardPayment());
        pp1.processPayment(400.00);

        PaymentProcessor pp2 = new PaymentProcessor();
        pp2.setPayment(new DebitCardPayment());
        pp2.processPayment(800.00);

        PaymentProcessor pp3 = new PaymentProcessor();
        pp3.setPayment(new SodexoCard());
        pp3.processPayment(200.00);

    }
}
//Strategy Design Pattern

// 1. Use composition over inheritance
// 2. Use interface over direct class extension
// 3. Use code extension over modification