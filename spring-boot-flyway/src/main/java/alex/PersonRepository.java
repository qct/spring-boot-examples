package alex;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>Created by damon.q on 2017/11/24.
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

}
