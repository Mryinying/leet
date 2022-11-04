package com.zephyr.leet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pipelineUser")
@AllArgsConstructor
@Data
public class PipelineUser {
    @Id
    private Long id;
    private String message;
}
