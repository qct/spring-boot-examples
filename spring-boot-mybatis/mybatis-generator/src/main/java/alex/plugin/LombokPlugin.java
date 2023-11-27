package alex.plugin;

import java.util.List;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

/**
 * <p>Created by qct on 2023/11/26.
 */
public class LombokPlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        // @Data
        topLevelClass.addImportedType("lombok.Data");
        topLevelClass.addAnnotation("@Data");

        // @Builder
        topLevelClass.addImportedType("lombok.Builder");
        topLevelClass.addAnnotation("@Builder");

        // @NoArgsConstructor
        topLevelClass.addImportedType("lombok.NoArgsConstructor");
        topLevelClass.addAnnotation("@NoArgsConstructor");

        // @AllArgsConstructor
        topLevelClass.addImportedType("lombok.AllArgsConstructor");
        topLevelClass.addAnnotation("@AllArgsConstructor");
        return super.modelBaseRecordClassGenerated(topLevelClass, introspectedTable);
    }

    @Override
    public boolean modelGetterMethodGenerated(Method method,
        TopLevelClass topLevelClass,
        IntrospectedColumn introspectedColumn,
        IntrospectedTable introspectedTable,
        ModelClassType modelClassType) {
        return false;
    }

    @Override
    public boolean modelSetterMethodGenerated(Method method,
        TopLevelClass topLevelClass,
        IntrospectedColumn introspectedColumn,
        IntrospectedTable introspectedTable,
        ModelClassType modelClassType) {
        return false;
    }
}
