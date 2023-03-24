package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ClassMethod {
    private String id;
    private String name;
    private String return_type;
    private String access;
    private String class_id;
    private String param;

    public boolean isEmpty(){
        if(!this.id.isEmpty()) return false;
        return true;
    }
}
