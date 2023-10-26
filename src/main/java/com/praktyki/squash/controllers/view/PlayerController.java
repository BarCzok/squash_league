package com.praktyki.squash.controllers.view;

import com.praktyki.squash.facades.PlayerFacade;
import com.praktyki.squash.facades.dto.PlayerDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/players")
public class PlayerController {

    @Resource
    PlayerFacade playerFacade;

    @GetMapping(value = "/{playerId}")
    public String home(@PathVariable Integer playerId, ModelMap model){
        PlayerDTO playerDto = playerFacade.getPlayer(playerId);

        model.addAttribute("player", playerDto);

        return "players/playerDetails";
    }
}
