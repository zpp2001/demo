package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ClassRelationship {
    private  int id;
    private String from_class_id;
    private  String to_class_id;
    private  String relationship;
}
