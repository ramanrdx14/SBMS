package in.rdx.beans;

public class PetrolEngine implements IEngine{
    public PetrolEngine() {
        System.out.println("Petrol Engine Started...");
    }

    @Override
    public void start() {
        System.out.println("Petrol Engine");
    }
}
