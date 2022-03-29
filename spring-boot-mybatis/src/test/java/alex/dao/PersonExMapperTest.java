package alex.dao;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <p>Created by qct on 2017/10/5.
 */
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