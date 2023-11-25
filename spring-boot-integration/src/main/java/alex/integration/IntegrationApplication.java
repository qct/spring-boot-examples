package alex.integration;

import alex.integration.cafe.Delivery;
import alex.integration.cafe.Drink;
import alex.integration.cafe.DrinkType;
import alex.integration.cafe.Order;
import alex.integration.cafe.OrderItem;
import com.google.common.util.concurrent.Uninterruptibles;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.aggregator.CorrelationStrategy;
import org.springframework.integration.aggregator.MessageGroupProcessor;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.dsl.AggregatorSpec;
import org.springframework.integration.dsl.Channels;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlowDefinition;
import org.springframework.integration.dsl.MessageChannelSpec;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.dsl.PublishSubscribeSpec;
import org.springframework.integration.dsl.RouterSpec;
import org.springframework.integration.router.MethodInvokingRouter;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.integration.store.MessageGroup;
import org.springframework.integration.stream.CharacterStreamWritingMessageHandler;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

@SpringBootApplication
public class IntegrationApplication {

    private AtomicInteger hotDrinkCounter = new AtomicInteger();
    private AtomicInteger coldDrinkCounter = new AtomicInteger();

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = SpringApplication.run(IntegrationApplication.class, args);

        Cafe cafe = context.getBean(Cafe.class);
        for (int i = 0; i < 100; i++) {
            Order order = new Order(i);
            order.addItem(DrinkType.LATTE, 2, false);
            order.addItem(DrinkType.MOCHA, 3, true);
            cafe.placeOrder(order);
        }

        System.out.println("Hit 'Enter' to terminate");
        System.in.read();
        context.close();
    }

    @Bean(name = PollerMetadata.DEFAULT_POLLER)
    public PollerMetadata poller() {
        return Pollers.fixedDelay(1000L).getObject();
    }

    @Bean
    public IntegrationFlow orders() {
        return new IntegrationFlow() {
            @Override
            public void configure(IntegrationFlowDefinition<?> f) {
                f.split(Order.class, Order::getItems)
                        .channel(channels -> channels.executor(Executors.newCachedThreadPool()))
                        .<OrderItem, Boolean>route(
                                OrderItem::isIced, new Consumer<RouterSpec<Boolean, MethodInvokingRouter>>() {
                                    @Override
                                    public void accept(
                                            RouterSpec<Boolean, MethodInvokingRouter>
                                                    booleanMethodInvokingRouterRouterSpec) {
                                        booleanMethodInvokingRouterRouterSpec
                                                .subFlowMapping(true, new IntegrationFlow() {
                                                    @Override
                                                    public void configure(IntegrationFlowDefinition<?> flow) {
                                                        flow.channel(channels -> channels.queue(10))
                                                                .publishSubscribeChannel(
                                                                        new Consumer<PublishSubscribeSpec>() {
                                                                            @Override
                                                                            public void accept(
                                                                                    PublishSubscribeSpec
                                                                                            publishSubscribeSpec) {
                                                                                publishSubscribeSpec
                                                                                        .subscribe(
                                                                                                new IntegrationFlow() {
                                                                                                    @Override
                                                                                                    public void
                                                                                                            configure(
                                                                                                                    IntegrationFlowDefinition<
                                                                                                                                    ?>
                                                                                                                            flow) {
                                                                                                        flow.handle(
                                                                                                                new MessageHandler() {
                                                                                                                    @Override
                                                                                                                    public
                                                                                                                    void
                                                                                                                            handleMessage(
                                                                                                                                    Message<
                                                                                                                                                    ?>
                                                                                                                                            message)
                                                                                                                                    throws
                                                                                                                                            MessagingException {
                                                                                                                        Uninterruptibles
                                                                                                                                .sleepUninterruptibly(
                                                                                                                                        1,
                                                                                                                                        TimeUnit
                                                                                                                                                .SECONDS);
                                                                                                                    }
                                                                                                                });
                                                                                                    }
                                                                                                })
                                                                                        .subscribe(
                                                                                                new IntegrationFlow() {
                                                                                                    @Override
                                                                                                    public void
                                                                                                            configure(
                                                                                                                    IntegrationFlowDefinition<
                                                                                                                                    ?>
                                                                                                                            flow) {
                                                                                                        flow.<OrderItem,
                                                                                                                        String>
                                                                                                                        transform(
                                                                                                                                new GenericTransformer<
                                                                                                                                        OrderItem,
                                                                                                                                        String>() {
                                                                                                                                    @Override
                                                                                                                                    public
                                                                                                                                    String
                                                                                                                                            transform(
                                                                                                                                                    OrderItem
                                                                                                                                                            source) {
                                                                                                                                        return Thread
                                                                                                                                                        .currentThread()
                                                                                                                                                        .getName()
                                                                                                                                                + " prepared cold drink #"
                                                                                                                                                + coldDrinkCounter
                                                                                                                                                        .incrementAndGet()
                                                                                                                                                + " for order #"
                                                                                                                                                + source.getOrder()
                                                                                                                                                        .getNumber()
                                                                                                                                                + ": "
                                                                                                                                                + source;
                                                                                                                                    }
                                                                                                                                })
                                                                                                                .handle(
                                                                                                                        new MessageHandler() {
                                                                                                                            @Override
                                                                                                                            public
                                                                                                                            void
                                                                                                                                    handleMessage(
                                                                                                                                            Message<
                                                                                                                                                            ?>
                                                                                                                                                    message)
                                                                                                                                            throws
                                                                                                                                                    MessagingException {
                                                                                                                                System
                                                                                                                                        .out
                                                                                                                                        .println(
                                                                                                                                                message
                                                                                                                                                        .getPayload());
                                                                                                                            }
                                                                                                                        });
                                                                                                    }
                                                                                                });
                                                                            }
                                                                        });
                                                    }
                                                })
                                                .subFlowMapping(false, new IntegrationFlow() {
                                                    @Override
                                                    public void configure(IntegrationFlowDefinition<?> flow) {
                                                        flow.channel(
                                                                        new Function<
                                                                                Channels, MessageChannelSpec<?, ?>>() {
                                                                            @Override
                                                                            public MessageChannelSpec<?, ?> apply(
                                                                                    Channels channels) {
                                                                                return channels.queue(10);
                                                                            }
                                                                        })
                                                                .publishSubscribeChannel(
                                                                        new Consumer<PublishSubscribeSpec>() {
                                                                            @Override
                                                                            public void accept(
                                                                                    PublishSubscribeSpec
                                                                                            publishSubscribeSpec) {
                                                                                publishSubscribeSpec
                                                                                        .subscribe(
                                                                                                new IntegrationFlow() {
                                                                                                    @Override
                                                                                                    public void
                                                                                                            configure(
                                                                                                                    IntegrationFlowDefinition<
                                                                                                                                    ?>
                                                                                                                            flow) {
                                                                                                        flow.handle(
                                                                                                                new MessageHandler() {
                                                                                                                    @Override
                                                                                                                    public
                                                                                                                    void
                                                                                                                            handleMessage(
                                                                                                                                    Message<
                                                                                                                                                    ?>
                                                                                                                                            message)
                                                                                                                                    throws
                                                                                                                                            MessagingException {
                                                                                                                        Uninterruptibles
                                                                                                                                .sleepUninterruptibly(
                                                                                                                                        5,
                                                                                                                                        TimeUnit
                                                                                                                                                .SECONDS);
                                                                                                                    }
                                                                                                                });
                                                                                                    }
                                                                                                })
                                                                                        .subscribe(
                                                                                                new IntegrationFlow() {
                                                                                                    @Override
                                                                                                    public void
                                                                                                            configure(
                                                                                                                    IntegrationFlowDefinition<
                                                                                                                                    ?>
                                                                                                                            flow) {
                                                                                                        flow.<OrderItem,
                                                                                                                        String>
                                                                                                                        transform(
                                                                                                                                new GenericTransformer<
                                                                                                                                        OrderItem,
                                                                                                                                        String>() {
                                                                                                                                    @Override
                                                                                                                                    public
                                                                                                                                    String
                                                                                                                                            transform(
                                                                                                                                                    OrderItem
                                                                                                                                                            source) {
                                                                                                                                        return Thread
                                                                                                                                                        .currentThread()
                                                                                                                                                        .getName()
                                                                                                                                                + " prepared hot drink #"
                                                                                                                                                + hotDrinkCounter
                                                                                                                                                        .incrementAndGet()
                                                                                                                                                + " for order #"
                                                                                                                                                + source.getOrder()
                                                                                                                                                        .getNumber()
                                                                                                                                                + ": "
                                                                                                                                                + source;
                                                                                                                                    }
                                                                                                                                })
                                                                                                                .handle(
                                                                                                                        new MessageHandler() {
                                                                                                                            @Override
                                                                                                                            public
                                                                                                                            void
                                                                                                                                    handleMessage(
                                                                                                                                            Message<
                                                                                                                                                            ?>
                                                                                                                                                    message)
                                                                                                                                            throws
                                                                                                                                                    MessagingException {
                                                                                                                                System
                                                                                                                                        .out
                                                                                                                                        .println(
                                                                                                                                                message
                                                                                                                                                        .getPayload());
                                                                                                                            }
                                                                                                                        });
                                                                                                    }
                                                                                                });
                                                                            }
                                                                        });
                                                    }
                                                })
                                                .defaultOutputToParentFlow();
                                    }
                                })
                        .<OrderItem, Drink>transform(new GenericTransformer<OrderItem, Drink>() {
                            @Override
                            public Drink transform(OrderItem source) {
                                return new Drink(
                                        source.getOrder().getNumber(),
                                        source.getDrinkType(),
                                        source.isIced(),
                                        source.getShots());
                            }
                        })
                        .aggregate(new Consumer<AggregatorSpec>() {
                            @Override
                            public void accept(AggregatorSpec aggregatorSpec) {
                                aggregatorSpec
                                        .outputProcessor(new MessageGroupProcessor() {
                                            @Override
                                            public Object processMessageGroup(MessageGroup group) {
                                                return new Delivery(group.getMessages().stream()
                                                        .map(message -> {
                                                            return (Drink) message.getPayload();
                                                        })
                                                        .collect(Collectors.toList()));
                                            }
                                        })
                                        .correlationStrategy(new CorrelationStrategy() {
                                            @Override
                                            public Object getCorrelationKey(Message<?> message) {
                                                return ((Drink) message.getPayload()).getOrderNumber();
                                            }
                                        });
                            }
                        })
                        .handle(CharacterStreamWritingMessageHandler.stdout());
            }
        };
    }

    @MessagingGateway
    public interface Cafe {

        @Gateway(requestChannel = "orders.input")
        void placeOrder(Order order);
    }
}
