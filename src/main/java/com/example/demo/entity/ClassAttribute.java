package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ClassAttribute {
    private int id;
    private String name;
    private String type;
    private String access;
    private String class_id;

    public boolean isEmpty(){
        if(!this.name.isEmpty()) return false;
        return true;
    }
}
