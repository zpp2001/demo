package com.example.demo.mapper;

import com.example.demo.entity.ClassMethod;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MethodMapper {
    public void updateMethods(ClassMethod method);
    public List<ClassMethod> getMethods(String class_id);
}
