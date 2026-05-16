package main.java.net.ftgo.consumerservice.domain;

import main.java.net.ftgo.domain.DomainConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DomainConfiguration.class)
public class ConsumerConfiguration {
    
    @Bean
    public ConsumerService consumerService() {
        return new ConsumerService();
    }
}
