package com.example.springbootapiforceautodesk.servieces.login;
import java.util.ArrayList;

import com.example.springbootapiforceautodesk.models.user.User;
import com.example.springbootapiforceautodesk.repositorys.login.loginRepositoryItf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class loginServieveImpl implements UserDetailsService {
    @Autowired
    private loginRepositoryItf loginRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user=loginRepository.getByEmail(email);
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),new ArrayList<>());
    }
}
