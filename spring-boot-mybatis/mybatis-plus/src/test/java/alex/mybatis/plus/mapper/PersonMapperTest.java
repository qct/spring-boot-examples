package alex.mybatis.plus.mapper;

import alex.mybatis.plus.dto.Person;
import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import java.util.List;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * <p>Created by qct on 2023/11/28.
 */
@ExtendWith(SpringExtension.class)
@MybatisPlusTest
@Log
public class PersonMapperTest {

    @Autowired
    private PersonMapper personMapper;

    @Test
    public void testSelect() {
        log.info("----- selectAll method test ------");
        List<Person> people = personMapper.selectList(null);

        Assertions.assertEquals(1, people.size());
        people.forEach(p -> log.info(p.toString()));

    }

}