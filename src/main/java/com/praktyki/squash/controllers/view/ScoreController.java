package com.praktyki.squash.controllers.view;

import com.praktyki.squash.controllers.forms.ScoreForm;
import com.praktyki.squash.facades.GameFacade;
import com.praktyki.squash.facades.dto.GameDTO;
import com.praktyki.squash.facades.dto.PlayerDTO;
import com.praktyki.squash.model.Game;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/scores")
public class ScoreController {

    @Resource
    GameFacade gameFacade;

    @GetMapping(value = "score/{gameId}")
    public String score(@PathVariable Integer gameId, ModelMap model){
        GameDTO gameDto = gameFacade.getGame(gameId);

        ScoreForm scoreForm = new ScoreForm();
        scoreForm.setPlayer1Name(gameDto.getPlayer1().getName());
        scoreForm.setPlayer2Name(gameDto.getPlayer2().getName());

        model.addAttribute("game", gameDto);
        model.addAttribute("score",scoreForm );

        return "scores/addScore";
    }
    @PostMapping(value = "/addScore")
    public String addScore(@ModelAttribute ScoreForm score){
//        scoreFacade.addScore(score);

        return "redirect:/games/view";
    }
}
