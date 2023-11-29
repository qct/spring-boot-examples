package alex.dao;

import alex.dto.Person;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/** Created by qct on 2017/10/5. */
@ExtendWith(SpringExtension.class)
@MybatisTest
public class PersonMapperTest {

    @Autowired
    private PersonMapper mapper;

    @Autowired
    private PersonExMapper exMapper;

    @Test
    public void selectByPrimaryKey() throws Exception {
        Person person = mapper.selectByPrimaryKey(1);

        Assertions.assertEquals(1, person.getId());
    }

    @Test
    public void insertSelective() throws Exception {
        for (int i = 0; i < 10; i++) {
            Person p = new Person();
            p.setName("a" + i);
            p.setAddress("Tokyo" + i);
            p.setAge(22 + i);
            mapper.insertSelective(p);
        }

        List<Integer> ids = exMapper.queryIds();
        Assertions.assertEquals(11, ids.size());

        for (Integer id : ids) {
            Person p = mapper.selectByPrimaryKey(id);
            Assertions.assertNotNull(p);
        }
    }
}
