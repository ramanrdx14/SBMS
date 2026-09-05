package org.example.Service;

import org.example.dao.IuserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    private  PwdService pwdService;
    @Autowired
    private IuserDao IuserDao;
    @Autowired
    private EmailService emailService;

    public UserService() {
    }

    /*

    Setter Injection

    @Autowired
    public void setPwdService(PwdService pwdService) {
        this.pwdService = pwdService;
    }
    @Autowired
    public void setIuserDao(IuserDao IuserDao) {
        this.IuserDao = IuserDao;
    }
    @Autowired
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }
     */

    /*

    Constructor Injection

    @Autowired
    public UserService(PwdService pwdService, IuserDao iuserDao, EmailService emailService) {
        this.pwdService = pwdService;
        IuserDao = iuserDao;
        this.emailService = emailService;
    }
    */
    public void registerUser(String name, String email, String pwd){
        //password encryption
        String encryptPassword = pwdService.encrypyPassword(pwd);
        //save user
        boolean isSaved        = IuserDao.saveUser(name,email,encryptPassword);
        if(isSaved){
            //send email
            boolean isSend = emailService.sendEmail();
            System.out.println("User Registration Completed");
        }
    }
}
