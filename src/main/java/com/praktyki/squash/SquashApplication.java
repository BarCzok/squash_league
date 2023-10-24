package com.praktyki.squash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SquashApplication implements WebMvcConfigurer {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SquashApplication.class, args);

        TestUczenData testData = context.getBean(TestUczenData.class);

        testData.createTestData();
        testData.readTestData();
        testData.updateTestData();
        testData.readTestData();
        testData.deleteTestData();
        testData.readTestData();

    }


}
