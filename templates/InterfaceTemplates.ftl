package ${project};

public interface ${interfaceName}{

<#list fields as field>
    ${field.access} ${field.type} ${field.name};
</#list>
<#list methods as method>
    ${method.access} <#if method.return_type??>${method.return_type}</#if> ${method.name} (<#if (method.param??)>${method.param}</#if>);
</#list>
}