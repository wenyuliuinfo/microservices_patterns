package test.java.net.ftgo;

import net.ftgo.consumerservice.main.ConsumerServiceConfiguration;
import net.ftgo.orderservice.main.OrderServiceConfiguration;
import net.ftgo.restaurantservice.RestaurantServiceConfiguration;
import net.ftgo.endtoendtests.common.AbstractEndToEndTests;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=FtgoApplicationTest.Config.class, webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FtgoApplicationTest extends AbstractEndToEndTests {

    @Configuration
    @EnableAutoConfiguration
    @ComponentScan
    @Import({ConsumerServiceConfiguration.class,
        OrderServiceConfiguration.class,
        RestaurantServiceConfiguration.class})
    public class Config {
    }

    @LocalServerPort
    private int port;

    @Override
    public String getHost() {
        return "localhost";
    }

    @Override
    public int getApplicationPort() {
        return port;
    }
    
}
