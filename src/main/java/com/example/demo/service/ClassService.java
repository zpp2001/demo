package com.example.demo.service;

import com.example.demo.entity.Class;
import com.example.demo.mapper.ClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    private ClassMapper classMapper;
    public void updateClass(Class classEntity){
        classMapper.updateClass(classEntity);
    }
    public List<Class> getClass(String project_id){
        return classMapper.getClass(project_id);
    }
}
