package com.zephyr.leet.controller;

import com.zephyr.leet.model.PipelineUser;
import com.zephyr.leet.repository.PipelineUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/pipelineUser")
public class PipelineUserController {

    private PipelineUserRepository pipelineUserRepository;

    @Autowired
    public void setPipelineUserRepository(PipelineUserRepository pipelineUserRepository) {
        this.pipelineUserRepository = pipelineUserRepository;
    }

    @PostMapping("")
    public Mono<Void> saveUser(@RequestBody Flux<PipelineUser> userFlux) {
        return pipelineUserRepository.insert(userFlux).then();
    }

    @GetMapping(path = "/get", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<PipelineUser> getUser() {
        return pipelineUserRepository.findAll();
    }
}