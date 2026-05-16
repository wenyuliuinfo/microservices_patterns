package main.java.net.ftgo.consumerservice.main;

import main.java.net.eventstore.examples.customersandorders.commonswagger.CommonSwaggerConfiguration;
import main.java.net.ftgo.consumerservice.web.ConsumerWebConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EntityScan
@Import({{ConsumerWebConfiguration.class, CommonSwaggerConfiguration.class}})
public class ConsumerServiceConfiguration {
    
}
