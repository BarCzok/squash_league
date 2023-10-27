package com.praktyki.squash.controllers.view;

import com.praktyki.squash.controllers.forms.ScoreForm;
import com.praktyki.squash.facades.GameFacade;
import com.praktyki.squash.facades.ScoreFacade;
import com.praktyki.squash.facades.dto.GameDTO;
import com.praktyki.squash.facades.dto.PlayerDTO;
import com.praktyki.squash.model.Game;
import com.praktyki.squash.model.Score;
import com.praktyki.squash.repository.ScoreRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/scores")
public class ScoreController {

    @Resource
    GameFacade gameFacade;

    @Resource
    ScoreFacade scoreFacade;

    @Resource
    ScoreRepository scoreRepository;

    @GetMapping(value = "score/{gameId}")
    public String score(@PathVariable Integer gameId, ModelMap model){

        GameDTO gameDto = gameFacade.getGame(gameId);
        model.addAttribute("game", gameDto);
        model.addAttribute("score", new ScoreForm());

        return "scores/addScore";
    }
    @PostMapping(value = "/addScore")
    public String addScore(@ModelAttribute ScoreForm score){

        Score player1Score = new Score();
        player1Score.setSets(score.getPoints1());
        scoreRepository.save(player1Score);

        Score player2Score = new Score();
        player2Score.setSets(score.getPoints2());
        scoreRepository.save(player2Score);

        return "redirect:/games/view";
    }
}
