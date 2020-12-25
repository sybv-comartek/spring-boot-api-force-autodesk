package com.example.springbootapiforceautodesk.repositorys.login;
import com.example.springbootapiforceautodesk.models.user.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Component
@Repository
public interface loginRepositoryItf extends JpaRepository<User,Long> {
    User getByEmail(String email);
}
