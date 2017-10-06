package alex.dao;

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
public class PersonExMapperTest {

    @Autowired
    private PersonExMapper exMapper;

    @Test
    public void queryIds() throws Exception {
        List<Integer> ids = exMapper.queryIds();
        System.out.println(ids.size());
    }
}