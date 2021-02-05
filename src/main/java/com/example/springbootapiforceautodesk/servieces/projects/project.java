package com.example.springbootapiforceautodesk.servieces.projects;

import java.util.List;

import com.example.springbootapiforceautodesk.models.projects.Project;

public interface project {
    Project saveProject(Project project);
    boolean updateProject(int id,String name,String description);
    boolean deleteProject(int id);
    List<Project> searchProject(String query);
}
