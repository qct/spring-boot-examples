package alex.dao;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/** Created by qct on 2017/10/5. */
@ExtendWith(SpringExtension.class)
@MybatisTest
public class PersonExMapperTest {

    @Autowired
    private PersonExMapper exMapper;

    @Test
    public void queryIds() throws Exception {
        List<Integer> ids = exMapper.queryIds();

        Assertions.assertEquals(1, ids.size());
    }
}
