package alex;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import alex.MyRestController.Customer;
import alex.MyRestController.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * <p>Created by qct on 2017/11/27.
 */
@Configuration
public class RoutingConfiguration {

    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction(UserHandler userHandler) {
        return route(GET("/{user}").and(accept(MediaType.APPLICATION_JSON)), userHandler::getUser)
            .andRoute(GET("/{user}/customers").and(accept(MediaType.APPLICATION_JSON)), userHandler::getUserCustomers);
    }

    @Component
    public static class UserHandler {
        Mono<ServerResponse> getUser(ServerRequest request) {
            long user = Long.parseLong(request.pathVariable("user"));
            Mono<User> xia = Mono.just(new User(user, "xia"));
            return ServerResponse.ok().body(fromPublisher(xia, User.class));
        }

        Mono<ServerResponse> getUserCustomers(ServerRequest request) {
            long user = Long.parseLong(request.pathVariable("user"));
            List<Customer> customers = new ArrayList<>();
            customers.add(new Customer(user, "Cai"));
            customers.add(new Customer(user, "Dai"));
            Flux<Customer> customerFlux = Flux.fromIterable(customers);
            return ServerResponse.ok().body(fromPublisher(customerFlux, Customer.class));
        }
    }
}
