package com.swabber.controller;

import com.swabber.controller.dto.Message;
import com.swabber.service.HelloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ResponseEntity<?> hello() {
        return new ResponseEntity<>(helloService.getHelloMessage(), HttpStatus.OK);
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public ResponseEntity<?> createMessage(String message) {
        return new ResponseEntity<>(new Message(message), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/hello", method = RequestMethod.PATCH)
    public ResponseEntity<?> updateMessage(String message) {
        return new ResponseEntity<>(new Message(message), HttpStatus.OK);
    }

    @RequestMapping(value = "/hello", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteMessage(String message) {
        return new ResponseEntity<>(new Message(message), HttpStatus.OK);
    }
}
