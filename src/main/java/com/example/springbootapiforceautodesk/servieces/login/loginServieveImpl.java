package com.example.springbootapiforceautodesk.servieces.login;
import java.util.ArrayList;

import com.example.springbootapiforceautodesk.models.user.TokenUser;
import com.example.springbootapiforceautodesk.models.user.User;
import com.example.springbootapiforceautodesk.repositorys.login.loginRepositoryItf;
import com.example.springbootapiforceautodesk.repositorys.login.tokenRepositoryItf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class loginServieveImpl implements UserDetailsService, loginServiece {
    @Autowired
    private loginRepositoryItf loginRepository;
    @Autowired
    private tokenRepositoryItf tokenRepositoryItf;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = loginRepository.getByEmail(email);
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                new ArrayList<>());
    }

    public User get(String email) {
        User user = loginRepository.getByEmail(email);
        return user;
    }

    @Override
    public TokenUser saveToken(TokenUser token) {
        // TODO Auto-generated method stub
        return tokenRepositoryItf.save(token);
    }

}
