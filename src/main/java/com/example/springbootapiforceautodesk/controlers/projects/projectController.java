package com.example.springbootapiforceautodesk.controlers.projects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.springbootapiforceautodesk.models.projects.Project;
import com.example.springbootapiforceautodesk.servieces.projects.projectImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class projectController {
    @Autowired
    private projectImpl projectImpl;
    @RequestMapping(value = "/createproject",method = RequestMethod.POST)
    public Project create(@RequestBody Project project ) throws Exception{
        try {
            return projectImpl.saveProject(project);
        } catch (Exception e) { 
            //TODO: handle exception
            throw new Exception("create project fail!!!");
        }
    }
    @RequestMapping(value="/updateproject", method=RequestMethod.POST)
    public boolean update(@RequestBody Project project) throws Exception {
        try {
            return projectImpl.updateProject(project.getId(), project.getName(),project.getDescription());
        } catch (Exception e) {
            //TODO: handle exception
            throw new Exception("update project fail!!!");
        }
    }
    @RequestMapping(value = "/deleteproject",method = RequestMethod.POST)
    public boolean delete(@RequestParam("id") int id) throws Exception{
        try {
            // System.out.println();
            return projectImpl.deleteProject(id);
        } catch (Exception e) {
            //TODO: handle exception
            throw new Exception("delete project fail!!!");
        }
    }
    @RequestMapping(value = "/searchproject",method = RequestMethod.POST)
    public Map<String,List<Project>> search(@RequestParam("name") String query) throws Exception{
        try {
            // System.out.println();
            Map<String,List<Project>> map=new HashMap<>();
            map.put("data", projectImpl.searchProject(query));
            return map;
        } catch (Exception e) {
            //TODO: handle exception
            throw new Exception("search project fail!!!");
        }
    }
}
