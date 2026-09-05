package org.example.exception;

import java.time.LocalDate;

public class AppException {
    String exceptionName;
    String msg;
    LocalDate exceptionTime;

    public String getExceptionName() {
        return exceptionName;
    }

    public void setExceptionName(String exceptionName) {
        this.exceptionName = exceptionName;
    }

    public LocalDate getExceptionTime() {
        return exceptionTime;
    }

    public void setExceptionTime(LocalDate exceptionTime) {
        this.exceptionTime = exceptionTime;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
