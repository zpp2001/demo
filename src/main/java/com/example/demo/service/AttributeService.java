package com.example.demo.service;

import com.example.demo.entity.ClassAttribute;
import com.example.demo.mapper.AttributeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeService {
    @Autowired
    AttributeMapper attributeMapper;
    public void insertAttributes(List<ClassAttribute> attributes){
        attributeMapper.insertAttributes(attributes);
    }
    public void updateAttribute(ClassAttribute attribute){
        attributeMapper.updateAttributes(attribute);
    }
    public List<ClassAttribute> getAttributes(String class_id){
        return attributeMapper.getAttributes(class_id);
    }
}
