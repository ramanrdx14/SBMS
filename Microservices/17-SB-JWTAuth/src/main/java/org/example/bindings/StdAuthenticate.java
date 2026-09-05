package org.example.bindings;

import org.springframework.stereotype.Component;

@Component
public class StdAuthenticate {
    String stdName;
    String stdPwd;

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public String getStdPwd() {
        return stdPwd;
    }

    public void setStdPwd(String stdPwd) {
        this.stdPwd = stdPwd;
    }
}
