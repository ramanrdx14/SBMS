package in.rdx.beans;

public class Car {
    public Car() {
        System.out.println("Car Started ...");
    }

    IEngine engine;

    public void setEngine(IEngine engine) {
        this.engine = engine;
        System.out.println("Setter Method Called");
        System.out.println("Injected Class :: "+engine.getClass().getName());
    }

    public void drive(){
        engine.start();
    }
}
