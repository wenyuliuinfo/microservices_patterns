package main.java.net.ftgo.consumerservice.web;

import main.java.net.ftgo.consumerservice.api.web.CreateConsumerRequest;
import main.java.net.ftgo.consumerservice.api.web.CreateConsumerResponse;
import main.java.net.ftgo.consumerservice.domain.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/consumers")
public class ConsumerController {
    
    @Autowired
    private ConsumerService consumerService;

    @RequestMapping(method = RequestMethod.POST)
    public CreateConsumerResponse create(@RequestBody CreateConsumerRequest request) {
        return new CreateConsumerResponse(consumerService.create(request.getName()).getId());
    }

    @RequestMapping(method = RequestMethod.GET, path="/{consumerId}") 
    public ResponseEntity<GetConsumerResponse> get(@PathVariable long consumerId){
        return consumerService.findById(consumerId)
                .map(consumer -> new ResponseEntity<>(new GetConsumerResponse(consumer.getName()), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
