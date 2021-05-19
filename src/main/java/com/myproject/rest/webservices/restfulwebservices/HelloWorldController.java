package com.myproject.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(value = "/hello")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(value = "/hello-world")
    public HelloWorldBean helloWorldBean(){
        return  new HelloWorldBean("Hello World");
    }
}
