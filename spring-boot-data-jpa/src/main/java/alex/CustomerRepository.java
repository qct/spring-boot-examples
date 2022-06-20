package alex;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/** Created by qct on 2017/11/22. */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}
