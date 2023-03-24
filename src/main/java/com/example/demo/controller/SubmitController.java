package com.example.demo.controller;
import com.example.demo.entity.*;
import com.example.demo.entity.Class;
import com.example.demo.entity.Enum;
import com.example.demo.service.*;
import com.example.demo.util.IdUtils;
import com.example.demo.util.PlantUMLUtils;
import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import net.sourceforge.plantuml.SourceFileReader;
import net.sourceforge.plantuml.classdiagram.ClassDiagram;
import net.sourceforge.plantuml.cucadiagram.Bodier;
import net.sourceforge.plantuml.cucadiagram.ILeaf;
import net.sourceforge.plantuml.cucadiagram.LeafType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.List;

@RestController
@RequestMapping("/submit")
public class SubmitController {
    @Autowired
    ProjectService projectService;
    @Autowired
    ClassService classService;
    @Autowired
    InterfaceService interfaceService;
    @Autowired
    EnumService enumService;
    @Autowired
    AttributeService attributeService;
    @Autowired
    MethodService methodService;

    //类图上传
    @PostMapping("/upload")
    public void uploadClassFile(String name, MultipartFile file) {
        if(!(file.isEmpty())){
            //项目上传
        Project project=new Project();
        project.setName(name);
        String project_id=IdUtils.getPrimaryKey();
        project.setId(project_id);
        projectService.setProject(project);
        //类图文件处理
            try (InputStream inputStream=file.getInputStream()){
                //转为file
                File convFile=new File(file.getOriginalFilename());
                convFile.createNewFile();
                FileOutputStream fos=new FileOutputStream(convFile);
                fos.write(file.getBytes());
                fos.close();
                SourceFileReader reader=new SourceFileReader(convFile);
                ClassDiagram diagram=(ClassDiagram) reader.getBlocks().get(0).getDiagram();
                //遍历所有类图节点
                //类图
                for(ILeaf leaf:diagram.getLeafsvalues()){
                    if(leaf.getLeafType().equals(LeafType.CLASS)){
                    //插入class表
                    Class classEntity=new Class();
                    String classId=IdUtils.getPrimaryKey();
                    classEntity.setId(classId);
                    classEntity.setProject_id(project_id);
                    classEntity.setName(leaf.getCode().getName());
                    classService.updateClass(classEntity);
//                     System.out.println(leaf.getBodier().getRawBody());
                    //开始处理类的属性和方法
                        Bodier bodier =leaf.getBodier();
                        List<ClassAttribute> attributes=PlantUMLUtils.getFields(bodier.getFieldsToDisplay(),classId);
                        List<ClassMethod> methods=PlantUMLUtils.getMethods(bodier.getMethodsToDisplay(),classId);
                       if(attributes!=null){
                           for(ClassAttribute attribute:attributes)
                           attributeService.updateAttribute(attribute);
                       }
                       if(methods!=null){
                           for(ClassMethod method:methods) {
                            System.out.println("id:"+method.getId()+" name:"+method.getName()+"return:"+method.getReturn_type()+"param:"+method.getReturn_type());
                            methodService.updateMethods(method);}
                       }
                    }
                    //接口
                    else if(leaf.getLeafType().equals(LeafType.INTERFACE)){
                        Interface interfaceEntity=new Interface();
                        String interfaceId=IdUtils.getPrimaryKey();
                        interfaceEntity.setName(leaf.getCode().getName());
                        interfaceEntity.setProject_id(project_id);
                        interfaceEntity.setId(interfaceId);
                        interfaceService.updateInterface(interfaceEntity);
                        Bodier bodier=leaf.getBodier();
                        List<ClassAttribute> attributes=PlantUMLUtils.getFields(bodier.getFieldsToDisplay(),interfaceId);
                        List<ClassMethod> methods=PlantUMLUtils.getMethods(bodier.getMethodsToDisplay(),interfaceId);
//                        if(attributes!=null){
//                            for(ClassAttribute attribute:attributes)
//                                attributeService.updateAttribute(attribute);
//                        }
//                        if(methods!=null){
//                            for(ClassMethod method:methods) {
//                                System.out.println("id:"+method.getId()+" name:"+method.getName()+"return:"+method.getReturn_type()+"param:"+method.getReturn_type());
//                                methodService.updateMethods(method);}
//                        }
                    }
                    else if(leaf.getLeafType().equals(LeafType.ENUM)){
                        Enum enumEntity=new Enum();
                        enumEntity.setId(IdUtils.getPrimaryKey());
                        enumEntity.setName(leaf.getCode().getName());
                        enumEntity.setProject_id(project_id);
                        enumService.updateEnum(enumEntity);
                    }

                }

//                String text=new BufferedReader((new InputStreamReader(inputStream))).lines().collect(Collectors.joining("\n"));
//                SourceStringReader reader=new SourceStringReader("@startuml\n"+text+"\n@enduml\n");
//                System.out.println(text);
            }catch (IOException e){}
        }

    }

}
