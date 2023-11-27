package alex.plugin;

import java.util.List;
import java.util.Optional;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

/**
 * <p>Created by qct on 2023/11/26.
 */
public class OptionalPlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean clientBasicSelectOneMethodGenerated(Method method, Interface interfaze,
        IntrospectedTable introspectedTable) {
        method.getReturnType().ifPresent(returnType -> {
            FullyQualifiedJavaType type = new FullyQualifiedJavaType(Optional.class.getName());
            type.addTypeArgument(returnType);
            method.setReturnType(type);
        });
        return true;
    }

    @Override
    public boolean clientSelectByPrimaryKeyMethodGenerated(Method method, Interface interfaze,
        IntrospectedTable introspectedTable) {
        method.getReturnType().ifPresent(returnType -> {
            FullyQualifiedJavaType type = new FullyQualifiedJavaType(Optional.class.getName());
            type.addTypeArgument(returnType);
            method.setReturnType(type);
        });
        return true;
    }

    @Override
    public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass,
        IntrospectedTable introspectedTable) {
        return false;
    }
}
