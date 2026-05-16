package main.java.net.ftgo.consumerservice.web;

import main.java.net.ftgo.common.PersonName;
import main.java.net.ftgo.consumerservice.api.web.CreateConsumerResponse;

public class GetConsumerResponse extends CreateConsumerResponse {
    
    private PersonName name;

    public PersonName getName() {
        return name;
    }

    public GetConsumerResponse(PersonName name) {
        this.name = name;
    }
    
}
