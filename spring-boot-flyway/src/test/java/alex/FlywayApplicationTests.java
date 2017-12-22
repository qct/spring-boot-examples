package alex;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlywayApplicationTests  {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testDefaultSettings() throws Exception {
        assertThat(this.jdbcTemplate.queryForObject("SELECT COUNT(*) from PERSON",
            Integer.class)).isEqualTo(1);
    }
}
