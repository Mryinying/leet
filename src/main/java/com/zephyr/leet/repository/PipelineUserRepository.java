package com.zephyr.leet.repository;

import com.zephyr.leet.model.PipelineUser;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface PipelineUserRepository extends ReactiveMongoRepository<PipelineUser, Long> {

}
