package in.rdx;

public class Test {
    public static void main(String[] args) {
        //Constructor Injection
        Car car = new Car(new PetrolEngine());
        car.drive();

        //Setter Injection
        Car car1 = new Car();
        car1.setEng(new DieselEngine());
        car1.drive();

        //Field Injection
        Car car2 = new Car();
        car2.e   = new PetrolEngine();
        car2.drive();
    }
}
