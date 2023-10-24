package com.praktyki.squash;

import com.praktyki.squash.model.Uczen;
import com.praktyki.squash.repository.UczenRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
@Component
public class TestData {
    @Resource(name = "uczenRepository")
    private UczenRepository uczenRepository;

    public void createTestData(){
        Uczen uczen = new Uczen();
        uczen.setName("Wojtek");
        uczenRepository.save(uczen);
    }
}
