package alex.dao;

import alex.dto.Person;
import alex.dto.PersonExample;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/** Created by qct on 2017/10/5. */
@ExtendWith(SpringExtension.class)
@MybatisTest
public class PersonMapperTest {

    @Autowired private PersonMapper mapper;

    @Test
    public void selectByExample() throws Exception {
        List<Person> people = mapper.selectByExample(new PersonExample());
        System.out.println(people.size());
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        Person person = mapper.selectByPrimaryKey(5);
        System.out.println(person);
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
    }
}
