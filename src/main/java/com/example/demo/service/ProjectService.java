package com.example.demo.service;

import com.example.demo.entity.Project;
import com.example.demo.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    ProjectMapper projectMapper;
    @Autowired
    public void setProjectMapper(ProjectMapper projectMapper){
        this.projectMapper=projectMapper;
    }
    public void setProject(Project project){
        projectMapper.setProject(project);
    }
    public int getProjectID(String name){
        return projectMapper.getProjectID(name);
    }
    public Project getProjectName(String id){
        return projectMapper.getProjectName(id);
    }

}
