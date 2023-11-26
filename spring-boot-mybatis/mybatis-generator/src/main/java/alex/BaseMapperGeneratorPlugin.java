package alex;

import java.util.List;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;

/** Created by qct on 2017/10/5. */
public class BaseMapperGeneratorPlugin extends PluginAdapter {

    @Override
    public boolean clientGenerated(Interface interfaze, IntrospectedTable introspectedTable) {
        // 主键默认采用java.lang.Integer
        FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType("BaseMapper<"
            + introspectedTable.getBaseRecordType()
            + ","
            + introspectedTable.getExampleType()
            + ",java.lang.Integer"
            + ">");
        FullyQualifiedJavaType imp = new FullyQualifiedJavaType("alex.BaseMapper");

        // 添加 extends MybatisBaseMapper
        interfaze.addSuperInterface(fqjt);

        // 添加import my.mabatis.example.base.MybatisBaseMapper;
        interfaze.addImportedType(imp);

        // 方法不需要
        interfaze.getMethods().clear();
        interfaze.getAnnotations().clear();
        return true;
    }

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }
}
