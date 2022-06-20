package alex;

import static alex.jooq.tables.Customer.CUSTOMER;

import alex.jooq.tables.records.CustomerRecord;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * default description.
 *
 * @author qct
 * @date 2018/3/5
 * @since 1.0
 */
@SpringBootApplication
public class JooqApplication implements CommandLineRunner {

    @Autowired private DSLContext create;

    public static void main(String[] args) {
        SpringApplication.run(JooqApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Result<CustomerRecord> records =
                create.selectFrom(CUSTOMER).where(CUSTOMER.FIRST_NAME.like("%e%")).fetch();
        records.forEach(System.out::print);
    }
}
