package org.example;

import java.util.Scanner;

public class TakeInput implements InputProvider{
    @Override
    public String provideInput(Scanner scanner) {
        return scanner.next();
    }
}
