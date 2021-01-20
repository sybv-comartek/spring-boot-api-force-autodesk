package com.example.springbootapiforceautodesk.servieces.login;

import com.example.springbootapiforceautodesk.models.user.TokenUser;

public interface loginServiece {
    TokenUser saveToken(TokenUser token);   
}
