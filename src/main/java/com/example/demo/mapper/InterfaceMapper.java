package com.example.demo.mapper;

import com.example.demo.entity.Interface;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterfaceMapper {
    public void updateInterface(Interface interfaceEntitty);
    public List<Interface> getInterface(String project_id);
}
