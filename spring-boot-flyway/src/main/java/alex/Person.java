package alex;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * <p>Created by damon.q on 2017/11/24.
 */
@Entity
public class Person {

    @Id
    @SequenceGenerator(name = "person_generator", sequenceName = "person_sequence", allocationSize = 1)
    @GeneratedValue(generator = "person_generator")
    private Long id;
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    @Override
    public String toString() {
        return "Person [firstName=" + this.firstName + ", lastName=" + this.lastName
            + "]";
    }
}
