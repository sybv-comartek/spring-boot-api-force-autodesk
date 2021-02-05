package com.example.springbootapiforceautodesk.repositorys.projects;

import java.util.List;

import com.example.springbootapiforceautodesk.models.projects.Project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Component
@Repository
@EnableJpaRepositories
public interface ProjectItf extends JpaRepository<Project,Long> {
    Project getById(int id);
    @Query("SELECT p FROM Project p WHERE p.name LIKE %?1%")
    List<Project> searchProjects(String query);
}