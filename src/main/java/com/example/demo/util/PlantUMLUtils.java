package com.example.demo.util;

import com.example.demo.entity.ClassAttribute;
import com.example.demo.entity.ClassMethod;
import net.sourceforge.plantuml.creole.command.Command;
import net.sourceforge.plantuml.cucadiagram.Display;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlantUMLUtils {
    //匹配属性的字符串
   private static final Pattern FIELD_PATTERN=Pattern.compile("^\\s*([+#\\-])\\s*(\\S+):\\s*(\\S+)");

   //匹配方法的正则表达式
   private static final Pattern METHOD_PATTERN=Pattern.compile("^\\s*([+#\\-])\\s*([a-zA-Z0-9_]+)\\s*\\(([^)]*)\\)\\s*(?:\\:([^\s]+)\\s*)?",Pattern.MULTILINE);
//   匹配函数的正则表达式

   private static final Pattern PARAM_PATTERN=Pattern.compile("\\s*(?:([a-zA-Z0-9_]+)\\s*\\:\\s*([^\\s,]+)\\s*(?:,\\s*)?)+");

    //处理类表中的属性
    public static List<ClassAttribute> getFields(Display fields, String class_id){
        if(fields.size()>0){
        List<ClassAttribute> attributes=new ArrayList<>();
        int num=0;
        for(CharSequence field:fields){
            ClassAttribute attribute=new ClassAttribute();
            Matcher matcher=FIELD_PATTERN.matcher(field.toString());
            if(matcher.find()){
            String access=matcher.group(1);
            attribute.setId(num);
            if(!access.isEmpty()) attribute.setAccess(TransferUtils.getVisitType(access));
            else if(access.isEmpty()) attribute.setAccess("private");
            attribute.setName(matcher.group(2));
            attribute.setType(matcher.group(3));
            num++;
            attribute.setClass_id(class_id);
            attributes.add(attribute);
            }
        }
        return attributes;
        }
        return null;
    }

    //处理类表中的方法，返回列表
    public static List<ClassMethod> getMethods(Display methods,String class_id){
        if(methods.size()>0){
        List<ClassMethod> methodArrayList=new ArrayList<>();
        int num=0;
        Matcher matcher1;
        for(CharSequence method:methods){
//            System.out.println(method);
            ClassMethod classMethod=new ClassMethod();
            classMethod.setId(IdUtils.getPrimaryKey());
            matcher1=METHOD_PATTERN.matcher(method.toString());
            if(matcher1.find()){
                System.out.println(matcher1.group(1)+matcher1.group(2)+matcher1.group(3));
                    String access=matcher1.group(1);
                    classMethod.setAccess("public");
                    if(!access.isEmpty()) classMethod.setAccess(TransferUtils.getVisitType(access));
                    classMethod.setClass_id(class_id);

                    classMethod.setReturn_type(matcher1.group(4));
                    String param=PlantUMLUtils.getParam(matcher1.group(3));
                    System.out.println("params:"+param+"\n");
                    classMethod.setParam(param);
                    classMethod.setName(matcher1.group(2));
                    num++;
//                    System.out.println(classMethod.getAccess()+classMethod.getName()+classMethod.getParamType()+classMethod.getReturn_type());
                    methodArrayList.add(classMethod);
            }
        }
        return  methodArrayList;
        }
        return null;
    }



    public static String getParam(String param){
        String params="";
        Map<String,String> map=new HashMap<>();
        Matcher matcher=PARAM_PATTERN.matcher(param);
        while (matcher.find()){
            String paramName = matcher.group(1);
            String paramType = matcher.group(2);
            map.put(paramName, paramType);
        }
        int num=0;
        // 输出结果
        for (Map.Entry<String, String> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
            if(num<map.size()-1) {
//                if(params.isEmpty()) params=entry.getValue()+" "+entry.getKey()+",";
                params=params+entry.getValue()+" "+entry.getKey()+",";num++;
            }
            else if(num==(map.size()-1)) {
//                if(params.isEmpty()) params=entry.getValue()+" "+entry.getKey();
               params=params+entry.getValue()+" "+entry.getKey();
                break;
            }
        }
        return params;
    }



}
