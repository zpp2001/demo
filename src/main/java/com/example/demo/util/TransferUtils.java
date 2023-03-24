package com.example.demo.util;

public class TransferUtils {
    public static final String location="C:\\Users\\1\\Desktop\\demo\\code";
    //获取访问属性
    public static String getVisitType(String visit){
        if(visit.equals("-")) return "private";
        if(visit.equals("+")) return "public";
        if(visit.equals("#")) return "protected";
        if(visit.equals("~")) return "package private";
        return null;
    }
}
