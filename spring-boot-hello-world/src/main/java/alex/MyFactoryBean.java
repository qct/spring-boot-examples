package alex;

import org.springframework.beans.factory.FactoryBean;

/**
 * <p>Created by qct.q on 2017/11/29.
 */
public class MyFactoryBean implements FactoryBean<MyBean> {

    @Override
    public MyBean getObject() throws Exception {
        return new MyBean("aaa");
    }

    @Override
    public Class<?> getObjectType() {
        return MyBean.class;
    }
}
