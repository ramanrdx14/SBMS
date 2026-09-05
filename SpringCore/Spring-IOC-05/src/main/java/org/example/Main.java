package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.PreparedStatement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ApplicationContext ap = new ClassPathXmlApplicationContext("springconfig.xml");
        UserInput ui = ap.getBean(UserInput.class);
        String input = ui.getInputString();
        try{
            Connection con = DBFactory.getConnection();
            PreparedStatement pst = con.prepareStatement("insert into user_text values (?) ");
            pst.setString(1,input);
            boolean isExecuted = pst.execute();
            if(isExecuted){
                System.out.println("Done !!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}