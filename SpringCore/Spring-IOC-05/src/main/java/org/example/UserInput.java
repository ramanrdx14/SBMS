package org.example;

import java.util.Scanner;

public class UserInput {
    InputProvider inputProvider;
    public UserInput(InputProvider inputProvider){
        this.inputProvider = inputProvider;
    }
    public String getInputString(){
        return inputProvider.provideInput(new Scanner(System.in));

    }
}
