package com.example.springbootapiforceautodesk.servieces.login;
import javax.transaction.Transactional;

import com.example.springbootapiforceautodesk.models.user.User;
import com.example.springbootapiforceautodesk.repositorys.login.loginRepositoryItf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Transactional
@Service
public class loginServieveImpl  {
    @Autowired
    private loginRepositoryItf loginRepository;
    public User get(String email){
        return loginRepository.getByEmail(email);
    }
}
