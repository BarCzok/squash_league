package com.praktyki.squash.controllers.view;

import com.praktyki.squash.facades.RoundFacade;
import com.praktyki.squash.facades.dto.GameDTO;
import com.praktyki.squash.facades.dto.GroupDTO;
import com.praktyki.squash.facades.dto.PlayerDTO;
import com.praktyki.squash.facades.dto.RoundDTO;
import com.praktyki.squash.model.Round;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/rounds")
public class RoundControler {
    @Resource
    RoundFacade roundFacade;

    @GetMapping(value = "/view")
    public String home(ModelMap model){
        List<RoundDTO> rounds = roundFacade.getRounds();
        model.addAttribute("rounds", rounds);
        return "rounds/allrounds";
    }

    @GetMapping(value = "/{roundId}/view")
    public String home(ModelMap model, @PathVariable Integer roundId,
                       @RequestParam(value = "foo", required = false) String foo){
        String valueFoo = foo;
        Map<GroupDTO, List<GameDTO>> gamesForRound = roundFacade.getGamesForRound(roundId);
        Map<GroupDTO, List<PlayerDTO>> playersForRound = roundFacade.getPlayersInGroups(roundId);
        model.addAttribute("games", gamesForRound);
        model.addAttribute("players", playersForRound);
        RoundDTO roundDto = roundFacade.getRoundById(roundId);
        model.addAttribute("roundName", roundDto.getName());
        return "rounds/view";
    }

    @GetMapping(value = "/view/{roundId}")
    public String home(ModelMap model, @PathVariable Integer roundId){

        Map<GroupDTO, List<GameDTO>> gamesForRound = roundFacade.getGamesForRound(roundId);
        Map<GroupDTO, List<PlayerDTO>> playersForRound = roundFacade.getPlayersInGroups(roundId);
        model.addAttribute("games", gamesForRound);
        model.addAttribute("players", playersForRound);
        RoundDTO roundDto = roundFacade.getRoundById(roundId);
        model.addAttribute("roundName", roundDto.getName());
        return "rounds/view";
    }
}
