package alex;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
public class FlywayApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testDefaultSettings() throws Exception {
        assertThat(this.jdbcTemplate.queryForObject("SELECT COUNT(*) from PERSON",
            Integer.class)).isEqualTo(1);
    }
}
