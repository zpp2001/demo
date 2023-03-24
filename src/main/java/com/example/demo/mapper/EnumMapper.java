package com.example.demo.mapper;

import com.example.demo.entity.Enum;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface EnumMapper {
    public void updateEnum(Enum enumEntity);
    public void getEnum(String project_id);
}
