package com.praktyki.squash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SquashApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SquashApplication.class, args);

        TestData testData = context.getBean(TestData.class);

        testData.createPlayers();
        testData.createGroupss();
        testData.createRound();
        testData.createHistories();

        testData.createGames();
//        testData.createScores();
    }
}
