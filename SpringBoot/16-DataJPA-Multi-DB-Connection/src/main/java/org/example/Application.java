package org.example;

import org.example.db1.entity.Mobile;
import org.example.db1.repo.MobileRepo;
import org.example.db2.entity.Charger;
import org.example.db2.repo.CharagerRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        MobileRepo mrepo = context.getBean(MobileRepo.class);
        CharagerRepo crepo = context.getBean(CharagerRepo.class);

        Mobile m1 = new Mobile();
        m1.setMobileName("Nokia");

        Charger c1 = new Charger();
        c1.setChargerType("Type-C");

        mrepo.save(m1);
        crepo.save(c1);

    }
}
