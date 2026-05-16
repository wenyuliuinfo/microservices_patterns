package main.java.net.ftgo.consumerservice.api.web;

import main.java.net.ftgo.common.*;

public class CreateConsumerResponse {
    
    private long consumerId;

    public long getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(long consumerId) {
        this.consumerId = consumerId;
    }

    public CreateConsumerResponse() {}

    public CreateConsumerResponse(long consumerId) {
        this.consumerId = consumerId;
    }
}
