package com.praktyki.squash;

import com.praktyki.squash.model.Uczen;
import com.praktyki.squash.model.Klasa;
import com.praktyki.squash.repository.UczenRepository;
import com.praktyki.squash.repository.KlasaRepository;
import org.springframework.stereotype.Component;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
@Component
public class TestUczenData {
    @Resource(name = "uczenRepository")
    private UczenRepository uczenRepository;

    @Resource(name = "klasaRepository")
    private KlasaRepository klasaRepository;

    public void createTestData(){
        System.out.println("Tworzenie danych: ");
        Uczen uczen1 = new Uczen();
        uczen1.setName("Wojtek");
        uczenRepository.save(uczen1);

        Uczen uczen2 = new Uczen();
        uczen2.setName("Bartek");
        uczenRepository.save(uczen2);

        Uczen uczen3 = new Uczen();
        uczen3.setName("Marcin");
        uczenRepository.save(uczen3);

        Klasa klasa1 = new Klasa();
        klasa1.setNrSali(11);
        klasaRepository.save(klasa1);

        Klasa klasa2 = new Klasa();
        klasa2.setNrSali(22);
        klasaRepository.save(klasa2);

        uczen1.setKlasa(klasa1);
        uczen2.setKlasa(klasa1);

        uczen3.setKlasa(klasa2);

        uczenRepository.saveAll(List.of(uczen1, uczen2, uczen3));
    }

    public void readTestData(){
        System.out.println("Wyświetlanie danych:");
        Iterable<Uczen> uczniowie = uczenRepository.findAll();

        Iterator<Uczen> iteratorUczen = uczniowie.iterator();
        while(iteratorUczen.hasNext()){
            Uczen uczen = iteratorUczen.next();

            System.out.println(uczen.getName() + " " + uczen.getId() + " nr sali: " + uczen.getKlasa().getNrSali());
            }
        }

    public void updateTestData(){
        System.out.println("Update danych: ");
        Optional<Uczen> uczenOptional = uczenRepository.findById(1);
        Uczen uczen = uczenOptional.get();
        uczen.setName("Kuba");
        uczenRepository.save(uczen);
    }

    public void deleteTestData() {
        System.out.println("Usuwanie danych: ");
        uczenRepository.deleteAll();
    }


}
