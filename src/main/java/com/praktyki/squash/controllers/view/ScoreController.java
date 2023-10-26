package com.praktyki.squash.controllers.view;

import com.praktyki.squash.facades.GameFacade;
import com.praktyki.squash.facades.dto.GameDTO;
import com.praktyki.squash.facades.dto.PlayerDTO;
import com.praktyki.squash.model.Game;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/scores")
public class ScoreController {

    @Resource
    GameFacade gameFacade;

    @GetMapping(value = "addScore/{gameId}")
    public String addScore(@PathVariable Integer gameId, ModelMap model){

        GameDTO gameDto = gameFacade.getGame(gameId);
        model.addAttribute("game", gameDto);

        return "scores/addScore";
    }
}
