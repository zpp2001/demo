package com.example.demo.service;

import com.example.demo.entity.Interface;
import com.example.demo.mapper.InterfaceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterfaceService {
    @Autowired
    private InterfaceMapper interfaceMapper;

    public void updateInterface(Interface interfaceEntitty){
        interfaceMapper.updateInterface(interfaceEntitty);

    }
    public List<Interface> getInterface(String project_id){
      return  interfaceMapper.getInterface(project_id);
    }
}
