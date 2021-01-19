package com.example.springbootapiforceautodesk.servieces.projects;

import java.util.List;

import com.example.springbootapiforceautodesk.models.projects.Project;
import com.example.springbootapiforceautodesk.repositorys.projects.ProjectItf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class projectImpl implements project {
    @Autowired
    private ProjectItf projectItf;

    @Override
    public Project saveProject(Project project) {
        // TODO Auto-generated method stub
        return projectItf.save(project);
    }

    @Override
    public boolean updateProject(int id, String name, String description) {
        // TODO Auto-generated method stub
        Project obj = projectItf.getById(id);
        obj.setName(name);
        obj.setDescription(description);
        projectItf.save(obj);
        return true;
    }

    @Override
    public boolean deleteProject(int id) {
        Project project = projectItf.getById(id);
        // TODO Auto-generated method stub
        projectItf.delete(project);
        return true;
    }

    @Override
    public List<Project> searchProject(String query) {
        // TODO Auto-generated method stub
        if(query!=null){
            return projectItf.searchProjects(query);
        }
        return null;
    }

}
