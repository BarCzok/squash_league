package com.praktyki.squash.facades;

import com.praktyki.squash.facades.dto.RoundDTO;
import com.praktyki.squash.model.Round;
import com.praktyki.squash.repository.RoundRepository;

import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class RoundFacade {

    @Resource
    RoundRepository roundRepository;



    public List<RoundDTO> getRound(){
        Iterable<Round> rounds = roundRepository.findAll();

        return (List<RoundDTO>) convertRound(rounds);
    }

    private List<RoundDTO> convertRound(Iterable<Round> rounds) {
        List<RoundDTO> roundDtos = new ArrayList<>();

        rounds.forEach(x -> roundDtos.add(convertRound(x)));

        return roundDtos;
    }

    public RoundDTO convertRound(Round rounds) {
        RoundDTO roundDto = new RoundDTO();

        roundDto.setId(rounds.getId());
        roundDto.setName(rounds.getName());

        return roundDto;
    }
}