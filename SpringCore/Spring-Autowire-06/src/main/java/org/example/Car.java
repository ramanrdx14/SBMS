package org.example;

public class Car {
    Engine engine;

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    public Car(){}
    public Car(Engine engine) {
        this.engine = engine;
    }

    public void drive(){
        engine.start();
    }
}
