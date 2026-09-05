package in.rdx;

public class DebitCardPayment implements IPayment{
    @Override
    public boolean pay(double amount) {
        System.out.println("DebitCard Payment of Rupees "+amount+" Paid!");
        return true;
    }
}
