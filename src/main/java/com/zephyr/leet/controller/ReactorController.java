package com.zephyr.leet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/test")
public class ReactorController {

    @GetMapping("/helloWorld")
    public Mono<String> helloWorld(){
        return Mono.just("hello world");
    }
}