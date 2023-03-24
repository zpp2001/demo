package com.example.demo.service;

import com.example.demo.entity.Enum;
import com.example.demo.mapper.EnumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnumService {
    @Autowired
    private EnumMapper enumMapper;
    
    public void updateEnum(Enum enumEntity){
        enumMapper.updateEnum(enumEntity);
    }
    public void getEnum(String project_id){
        enumMapper.getEnum(project_id);
    }
}
