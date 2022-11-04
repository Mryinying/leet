package com.zephyr.leet.router;

import com.zephyr.leet.handler.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;

@Configuration
public class UserRouting {

    @Autowired
    private UserHandler userHandler;

    @Bean
    public RouterFunction<ServerResponse> userRouter() {

        return RouterFunctions.nest(
                //相当于controller 下的 request mapping
                RequestPredicates.path("/user"),

                //各个路由节点
                RouterFunctions
                        .route(RequestPredicates.GET("/getuserid"), userHandler::getUserId)
                        .andRoute(RequestPredicates.GET("/getusername"), userHandler::getUserName)
        );

    }
}