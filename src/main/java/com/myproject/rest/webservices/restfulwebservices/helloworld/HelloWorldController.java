package com.myproject.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    /*
    *  Using of path variables
    * */
    @GetMapping(value = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariableUse(@PathVariable String name){
        return  new HelloWorldBean(String.format("Hello to, %s",name));
    }
}
