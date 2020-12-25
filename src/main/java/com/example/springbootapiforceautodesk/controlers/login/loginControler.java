package com.example.springbootapiforceautodesk.controlers.login;
import com.example.springbootapiforceautodesk.models.user.User;
import com.example.springbootapiforceautodesk.servieces.login.loginServieveImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value = "/login")
public class loginControler {
    @Autowired
    private loginServieveImpl loginImpl;
    @Autowired
    private cryptWithMD5 cryptWithMD5;
    @RequestMapping(value="", method=RequestMethod.POST)
    public boolean requestMethodName(@RequestParam (value = "email") String email,
    @RequestParam(value = "password") String password) {
        User user=loginImpl.get(email);
        String passwordMd5=cryptWithMD5.decodeCryptWithMD5(password);
        if(user!=null){
            if(user.getPassword().toString().equals(passwordMd5)){
                return true;
            }
            return false;
        }
        return false;
    }
}
