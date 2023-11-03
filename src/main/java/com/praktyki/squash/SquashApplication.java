package com.praktyki.squash;

import com.praktyki.squash.repository.GroupssRepository;
import com.praktyki.squash.repository.RoundRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@SpringBootApplication
public class SquashApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SquashApplication.class, args);

        GroupssRepository groupssRepository = context.getBean(GroupssRepository.class);
        RoundRepository roundRepository = context.getBean(RoundRepository.class);

        TestData testData = context.getBean(TestData.class);

        testData.createPlayers();
        testData.createRound();
        testData.createGroupss();

        testData.createHistories();

        testData.createGames();
        testData.createScores();
        testData.getPlayersByPhoneNr();

//        testData.createGroupTransitions(groupssRepository.findAll().iterator().next(), roundRepository.findAll().iterator().next().getId());
    }
}
