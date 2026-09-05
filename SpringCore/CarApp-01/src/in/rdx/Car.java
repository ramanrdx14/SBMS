package in.rdx;

public class Car {
    public Engine e;
    public  Car(){

    }
    public Car(Engine e){
        this.e = e;
    }

    public void setEng(Engine e) {
        this.e = e;
    }

    public void drive(){
        int status = e.start();
        if(status >= 0){
            System.out.println("Journey Started !");
        }else{
            System.out.println("Not able to Start the engine !!");
        }
    }
}
