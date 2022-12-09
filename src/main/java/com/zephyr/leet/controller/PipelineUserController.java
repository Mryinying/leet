package com.zephyr.leet.controller;

import com.zephyr.leet.model.PipelineUser;
import com.zephyr.leet.repository.PipelineUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/pipelineUser")
public class PipelineUserController {

    private PipelineUserRepository pipelineUserRepository;

    @Autowired
    public void setPipelineUserRepository(PipelineUserRepository pipelineUserRepository) {
        this.pipelineUserRepository = pipelineUserRepository;
    }

    @PostMapping
    public Mono<Void> saveUser(@RequestBody Flux<PipelineUser> userFlux) {
        return pipelineUserRepository.insert(userFlux).then();
    }

    @GetMapping(path = "/get", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<PipelineUser> getUser() {
        Flux<PipelineUser> all = pipelineUserRepository.findAll();
        all.subscribe( s -> log.info("consume::: " + s + Thread.currentThread()),
                throwable -> log.info("exception:::: " + throwable + Thread.currentThread()),
                () -> log.info("done all the things " + Thread.currentThread()));


        all.log().subscribe( s -> log.info("log consume::: " + s + Thread.currentThread()),
                throwable -> log.info("log exception:::: " + throwable + Thread.currentThread()),
                () -> log.info("log done all the things " + Thread.currentThread()));
        return all;
    }
}