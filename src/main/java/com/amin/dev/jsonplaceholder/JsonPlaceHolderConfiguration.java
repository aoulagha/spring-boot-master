package com.amin.dev.jsonplaceholder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonPlaceHolderConfiguration {

    @Bean
    CommandLineRunner runner(JsonPlaceHolderClient jsonPlaceHolderClient) {
        return args -> {
            System.out.println(jsonPlaceHolderClient.getPosts());
            System.out.println(jsonPlaceHolderClient.getPost(1));
        };
    }
}
