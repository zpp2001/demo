package com.example.demo.service;

import com.example.demo.entity.ClassMethod;
import com.example.demo.mapper.MethodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MethodService {
    @Autowired
    private MethodMapper methodMapper;
    public void updateMethods(ClassMethod method){
        methodMapper.updateMethods(method);
    }
    public List<ClassMethod> getMethods(String class_id){
      return  methodMapper.getMethods(class_id);
    }
}
