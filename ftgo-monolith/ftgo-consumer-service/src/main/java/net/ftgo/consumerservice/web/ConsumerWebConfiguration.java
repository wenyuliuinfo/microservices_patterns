package main.java.net.ftgo.consumerservice.web;

import main.java.net.ftgo.consumerservice.domain.ConsumerConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan
@Import(ConsumerConfiguration.class)
public class ConsumerWebConfiguration {
    
}
