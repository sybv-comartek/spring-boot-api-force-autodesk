package com.example.springbootapiforceautodesk.controlers.login;
import com.example.springbootapiforceautodesk.models.user.AuthRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping(value = "/login")
public class loginControler {
    @Autowired
    private jwtUntil jwtUntil;
    @Autowired
    private AuthenticationManager uthenticationManager;
    // @RequestMapping(value="", method=RequestMethod.POST)
    // public String requestMethodName(@RequestParam (value = "email") String email,
    // @RequestParam(value = "password") String password) {
    // }
    @RequestMapping(value = "",method = RequestMethod.POST)
    public String generateToken(@RequestBody AuthRequest authrequest ) throws Exception {
        try {
            uthenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authrequest.getEmail(),authrequest.getPassword())
            );
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Errrrkjsdsdkfjksvdf"+"    "+e);
            throw new Exception("inavalid email/password");
        }
        return jwtUntil.generateToken(authrequest.getEmail());
    }
}
