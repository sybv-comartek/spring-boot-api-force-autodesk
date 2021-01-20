package com.example.springbootapiforceautodesk.repositorys.login;

import com.example.springbootapiforceautodesk.models.user.TokenUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Component
@Repository
@EnableJpaRepositories
public interface tokenRepositoryItf extends JpaRepository<TokenUser,Long> {
}
