package com.praktyki.squash.controllers.view;

import com.praktyki.squash.facades.RoundFacade;
import com.praktyki.squash.facades.dto.RoundDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
@Controller
@RequestMapping(value = "/rounds")
public class RoundControler {
    @Resource
    RoundFacade roundFacade;

    @GetMapping(value = "/view/{roundId}")
    public String home(ModelMap model, @PathVariable Integer roundId){
        model.addAttribute("games", roundFacade.getGamesForRound(roundId));
        RoundDTO roundDto = roundFacade.getRoundById(roundId);
        model.addAttribute("roundName", roundDto.getName());
        return "rounds/view";
    }
}
