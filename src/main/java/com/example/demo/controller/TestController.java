package com.example.demo.controller;

import com.example.demo.utils.Traceable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {


    @Traceable
    @RequestMapping(value = "/hello")
    public ResponseEntity<String> hello(){
        System.out.println("Hello World!");
        return new ResponseEntity<String>("Hello World!", HttpStatus.OK);
    }

    @Traceable
    @RequestMapping(value = "/greet/{username}")
    public ResponseEntity<String> greetings(@Validated @PathVariable(value = "username") String username){
        System.out.println("Good Morning " + username + "!!");
        return new ResponseEntity<String>("Good Morning " + username + "!!", HttpStatus.OK);
    }

}
