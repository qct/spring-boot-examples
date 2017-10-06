package alex.dao;


import alex.dto.Person;
import alex.dto.PersonExample;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>Created by qct on 2017/10/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PersonMapperTest {

    @Autowired
    private PersonMapper mapper;

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