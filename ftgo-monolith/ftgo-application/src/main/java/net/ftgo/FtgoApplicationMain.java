package main.java.net.ftgo;

import net.ftgo.consumerservice.main.ConsumerServiceConfiguration;
import net.ftgo.orderservice.main.OrderServiceConfiguration;
import net.ftgo.restaurantservice.RestaurantServiceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@Import({ConsumerServiceConfiguration.class,
        OrderServiceConfiguration.class,
        RestaurantServiceConfiguration.class})
public class FtgoApplicationMain {

    public static void main(String[] args) {
        SpringApplication.run(FtgoApplicationMain.class, args);
    }
    
}
