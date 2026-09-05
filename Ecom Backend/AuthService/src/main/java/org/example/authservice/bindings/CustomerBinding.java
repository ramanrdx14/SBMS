package org.example.authservice.bindings;

import org.springframework.stereotype.Component;

@Component
public class CustomerBinding {
    String customerEmail;
    String customerPwd;

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPwd() {
        return customerPwd;
    }

    public void setCustomerPwd(String customerPwd) {
        this.customerPwd = customerPwd;
    }
}
