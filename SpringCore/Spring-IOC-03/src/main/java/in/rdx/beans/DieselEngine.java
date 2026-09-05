package in.rdx.beans;

public class DieselEngine implements IEngine{
    public DieselEngine() {
        System.out.println("Diesel Engine Started...");
    }

    @Override
    public void start() {
        System.out.println("Desiel Engine");
    }
}
