package com.example.demo.mapper;

import com.example.demo.entity.Project;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectMapper {
    public void setProject(Project project);
    public int getProjectID(String name);
    public int getNewID();
    public Project getProjectName(String id);
}
