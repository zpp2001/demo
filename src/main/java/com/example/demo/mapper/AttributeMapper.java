package com.example.demo.mapper;

import com.example.demo.entity.ClassAttribute;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttributeMapper {
    public void insertAttributes(List<ClassAttribute> attributes);
    public void updateAttributes(ClassAttribute attribute);
    public List<ClassAttribute> getAttributes(String class_id);
}
