package org.example.authservice.rest;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.authservice.bindings.CustomerBinding;
import org.example.authservice.entity.Customer;
import org.example.authservice.entity.Roles;
import org.example.authservice.repo.CustomerRepo;
import org.example.authservice.repo.RolesRepo;
import org.example.authservice.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class UserLoginController {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    RolesRepo rolesRepo;
    @Autowired
    JWTService jwtService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Customer customer){
        String encodedPwd = passwordEncoder.encode(customer.getCustomerPwd());
        List<Roles> roles = customer.getRoles().stream().map(r->rolesRepo.findById(r.getRoleId()).orElseThrow()).toList();
        customer.setCustomerPwd(encodedPwd);
        customer.setRoles(roles);
        customerRepo.save(customer);
        return  new ResponseEntity<>("Customer Register Successfully", HttpStatus.ACCEPTED);
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody CustomerBinding customer, HttpServletRequest request){
        try {
            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(customer.getCustomerEmail(), customer.getCustomerPwd()));
            boolean isValidUser = authenticate.getAuthorities().stream().anyMatch(role -> role.getAuthority().equals("admin") || role.getAuthority().equals("user"));
            if(!isValidUser){
                return new ResponseEntity<>("Login Failed No Admin Access !!",HttpStatus.UNAUTHORIZED);
            }

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Login Failed",HttpStatus.UNAUTHORIZED);
        }
        String token = jwtService.generateToken(customer.getCustomerEmail());
        return new ResponseEntity<>("Logged In Successfully "+token,HttpStatus.OK);
    }
    @GetMapping("/logout")
    public ResponseEntity<String> logout(){
        return new ResponseEntity<>("Logout",HttpStatus.OK);
    }

    @GetMapping("/loggedInCustomer")
    public ResponseEntity<Integer> getCurrentLoggedInCustomer(@RequestHeader("Current_User") String email) {
        Customer customer = customerRepo.findByCustomerEmail(email);
        return new ResponseEntity<>(customer.getCustomerId(), HttpStatus.OK);
    }
}
