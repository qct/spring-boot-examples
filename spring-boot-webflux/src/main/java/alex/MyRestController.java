package alex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * <p>Created by qct on 2017/11/27.
 */
//@RestController
//@RequestMapping("/users")
public class MyRestController {

    @GetMapping("/{user}")
    public Mono<User> getUser(@PathVariable Long user) {
        return Mono.just(new User(user, "Kim"));
    }

    @GetMapping("/{user}/customers")
    Flux<Customer> getUserCustomers(@PathVariable Long user) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(user, "Aby"));
        customers.add(new Customer(user, "Bay"));
        return Flux.fromIterable(customers);
    }

    static class User {

        private long id;
        private String userName;

        User(long id, String userName) {
            this.id = id;
            this.userName = userName;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }

    static class Customer {

        private long userId;
        private String customerName;

        Customer(long userId, String customerName) {
            this.userId = userId;
            this.customerName = customerName;
        }

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }
    }
}
