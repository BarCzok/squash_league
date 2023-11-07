package com.praktyki.squash.controllers.view;

import com.praktyki.squash.controllers.forms.PlayerForm;
import com.praktyki.squash.controllers.forms.ScoreForm;
import com.praktyki.squash.facades.PlayerFacade;
import com.praktyki.squash.facades.dto.GameDTO;
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
    @GetMapping(value = "/addPlayer")
    public String score(@PathVariable Integer playerId, ModelMap model){
        PlayerDTO playerDto = new PlayerDTO();

        PlayerForm playerForm = new PlayerForm();
        playerForm.setId(playerDto.getId());
        playerForm.setName(playerDto.getName());
        playerForm.setAdress(playerDto.getAdress());
        playerForm.setPhoneNumber(playerDto.getPhoneNumber());


        model.addAttribute("player",playerForm );

        return "scores/addScore";
    }
}
