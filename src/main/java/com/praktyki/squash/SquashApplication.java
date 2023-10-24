package com.praktyki.squash;

import com.praktyki.squash.model.Uczen;
import com.praktyki.squash.repository.UczenRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@SpringBootApplication
public class SquashApplication implements WebMvcConfigurer {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SquashApplication.class, args);

TestData testData = context.getBean(TestData.class);

testData.createTestData();

    }


}
