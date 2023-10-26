package com.praktyki.squash;

import com.praktyki.squash.facades.GameFacade;
import com.praktyki.squash.facades.GroupFacade;
import com.praktyki.squash.facades.PlayerFacade;
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
        testData.createGames();
//        testData.createScores();
        testData.createGroupss();


    }
}
