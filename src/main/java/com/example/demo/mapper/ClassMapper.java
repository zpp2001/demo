package com.example.demo.mapper;

import com.example.demo.entity.Class;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassMapper {
    //更新类表
    public void updateClass(Class classEntity);
    public List<Class> getClass(String project_id);
}
