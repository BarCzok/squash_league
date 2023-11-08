package com.praktyki.squash.controllers.view;

import com.praktyki.squash.controllers.forms.PlayerForm;
import com.praktyki.squash.controllers.forms.ScoreForm;
import com.praktyki.squash.facades.PlayerFacade;
import com.praktyki.squash.facades.dto.GameDTO;
import com.praktyki.squash.facades.dto.PlayerDTO;
import com.praktyki.squash.model.Player;
import com.praktyki.squash.model.Score;
import com.praktyki.squash.repository.PlayersRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/players")
public class PlayerController {

    @Resource
    PlayerFacade playerFacade;

    @Resource
    PlayersRepository playersRepository;

    @GetMapping(value = "/{playerId}")
    public String home(@PathVariable Integer playerId, ModelMap model){
        PlayerDTO playerDto = playerFacade.getPlayer(playerId);

        model.addAttribute("player", playerDto);

        return "players/playerDetails";
    }

    @GetMapping(value ="/newPlayer")
    public String home(ModelMap model){

        PlayerForm playerform = new PlayerForm();
        model.addAttribute("player", playerform);

        return "players/addPlayer";
    }

    @PostMapping(value = "/addPlayer")
    public String addPlayer(@ModelAttribute PlayerForm playerForm, ModelMap model){

        Player player = new Player();
        player.setName(playerForm.getName());
        player.setAdress(playerForm.getAdress());
        player.setPhoneNumber(playerForm.getPhoneNumber());
        playersRepository.save(player);

        return "redirect:/rounds/view";
    }
}
