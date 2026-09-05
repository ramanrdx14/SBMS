package org.example.sbapp02;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ReportDao {
    ReportDao(){
        System.out.println("Report Dao Object Created ::");
    }
}
