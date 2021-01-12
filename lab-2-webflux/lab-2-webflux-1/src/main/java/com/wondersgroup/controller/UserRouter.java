package com.wondersgroup.controller;

import com.wondersgroup.vo.UserVO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2021/1/12 12:20
 * @description: 函数式编程
 */
@Configuration
public class UserRouter {

    /**
     *  获取用户列表
     * @return 用户列表
     */
    @Bean
    public RouterFunction<ServerResponse> userListRouterFunction(){
        return route(GET("/users2/list"),
                new HandlerFunction<ServerResponse>() {
                    @Override
                    public Mono<ServerResponse> handle(ServerRequest serverRequest) {
                        // 查询列表
                        List<UserVO> result = new ArrayList<>();
                        result.add(new UserVO().setId(1).setUsername("yudaoyuanma"));
                        result.add(new UserVO().setId(2).setUsername("woshiyutou"));
                        result.add(new UserVO().setId(3).setUsername("chifanshuijiao"));
                        // 返回列表
                        return ok().bodyValue(result);
                    }
                }
        );
    }

    /**
     *  根据编号查询用户
     * @return 用户信息
     */
    @Bean
    public RouterFunction<ServerResponse>userGetRouterFunction(){
        return route(GET("/users2/get"),
                new HandlerFunction<ServerResponse>() {
                    @Override
                    public Mono<ServerResponse> handle(ServerRequest serverRequest) {
                        // 获得编号
                        Integer id = serverRequest.queryParam("id")
                                .map(s -> StringUtils.isEmpty(s) ? null : Integer.valueOf(s)).get();
                        // 查询用户
                        UserVO user = new UserVO().setId(id).setUsername(UUID.randomUUID().toString());
                        // 返回列表
                        return ok().bodyValue(user);
                    }
                }
        );
    }

    @Bean
    public RouterFunction<ServerResponse> demoRouterFunction() {
        return route(GET("/users2/demo"), request -> ok().bodyValue("demo"));
    }
}
