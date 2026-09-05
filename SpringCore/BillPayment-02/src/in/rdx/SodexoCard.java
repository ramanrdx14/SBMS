package in.rdx;

public class SodexoCard implements IPayment{
    @Override
    public boolean pay(double amount) {
        System.out.println("Sodexo Payement is in progress for rupees "+amount);
        return true;
    }
}
