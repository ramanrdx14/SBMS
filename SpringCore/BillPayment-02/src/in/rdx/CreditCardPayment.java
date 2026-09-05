package in.rdx;

public class CreditCardPayment implements IPayment{
    @Override
    public boolean pay(double amount) {
        System.out.println("CreditCard Payment of Rupees "+amount+" Paid!");
        return true;
    }
}
