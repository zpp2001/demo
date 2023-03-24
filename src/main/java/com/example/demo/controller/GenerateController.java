package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.entity.Class;
import com.example.demo.service.*;
import com.example.demo.util.TransferUtils;
import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.spire.doc.Document;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/generate")
public class GenerateController {
    @Autowired
    private ClassService classService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private AttributeService attributeService;
    @Autowired
    private MethodService methodService;
    @Autowired
    private InterfaceService interfaceService;
    //    代码生成
    @RequestMapping("/code")
    public void generateCode(String projectID) throws IOException, TemplateException {
        //处理类
        Configuration configuration=new Configuration();
        FileTemplateLoader ftl=new FileTemplateLoader(new File("templates"));
        configuration.setTemplateLoader(ftl);
        String project=projectService.getProjectName(projectID).getName();
        System.out.println("project:"+project);
        Template template=configuration.getTemplate("ClassTemplates.ftl");
        Template interfaceTemplate=configuration.getTemplate("InterfaceTemplates.ftl");
        Map<String,Object> dataModel=new HashMap<>();
        File file=new File(TransferUtils.location+"\\"+project);
        file.mkdirs();
        //获取类的信息
        List<Class> classList=classService.getClass(projectID);
        List<Interface> interfaces=interfaceService.getInterface(projectID);
        for(Class classEntity:classList){
            System.out.println("class name:"+classEntity.getName());
            dataModel.put("project",project);
            dataModel.put("className",classEntity.getName());
            //解析类的属性
            List<ClassAttribute> attributes=attributeService.getAttributes(classEntity.getId());
            for(ClassAttribute attribute:attributes) System.out.println("attributes:"+attribute.getName());
            dataModel.put("fields",attributes);
            //解析类的方法
            List<ClassMethod> methods=methodService.getMethods(classEntity.getId());
            for(ClassMethod method:methods) System.out.println("methods:"+method.getName()+":"+method.getReturn_type());
            dataModel.put("methods",methods);
            String str= TransferUtils.location +"\\"+project+"\\"+classEntity.getName()+".java";
            System.out.println(str);
            template.process(dataModel,new FileWriter(new File(str)));
        }
        for(Interface interfaceEntity:interfaces){
            dataModel.put("project",project);
            dataModel.put("interfaceName",interfaceEntity.getName());
            List<ClassAttribute> attributes=attributeService.getAttributes(interfaceEntity.getId());
            dataModel.put("fields",attributes);
            List<ClassMethod> methods=methodService.getMethods(interfaceEntity.getId());
            dataModel.put("methods",methods);
            String str= TransferUtils.location +"\\"+project+"\\"+interfaceEntity.getName()+".java";
            interfaceTemplate.process(dataModel,new FileWriter(new File(str)));
        }
    }

    //从数据库读取信息插入word
    @RequestMapping("/word")
    public void generateWord(MultipartFile file){

    }
}
