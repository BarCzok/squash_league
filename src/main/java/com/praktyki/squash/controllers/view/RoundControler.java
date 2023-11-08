package com.praktyki.squash.controllers.view;

import com.praktyki.squash.facades.RoundFacade;
import com.praktyki.squash.facades.dto.GameDTO;
import com.praktyki.squash.facades.dto.GroupDTO;
import com.praktyki.squash.facades.dto.PlayerDTO;
import com.praktyki.squash.facades.dto.RoundDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
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

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User principal = (User) auth.getPrincipal();

        model.addAttribute("user", principal.getUsername());

        return "rounds/view";
    }
    @GetMapping (value = "/xd/{roundId}")
    public String xd(ModelMap model, @PathVariable Integer roundId){
        roundFacade.closeRound(roundId);

        return "redirect:/rounds/view";
    }
}
