package org.example.rest;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
    @GetMapping("/")
    public String githubLogin(){

        return "Logged In Via Github";
    }
    @GetMapping("/profile")
    public String profile(@AuthenticationPrincipal OAuth2User auth2User){
        String  username = auth2User.getAttribute("login");
        String  name     = auth2User.getAttribute("name");
        String  email    = auth2User.getAttribute("email");
        return "Profile Page "+ username+" "+name+" "+email;
    }
}
