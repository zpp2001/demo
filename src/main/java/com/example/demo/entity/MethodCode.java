package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MethodCode {
    private int id;
    private byte[] code;
    int method_id;
}
