package com.praktyki.squash.controllers.view;

import com.praktyki.squash.controllers.forms.ScoreForm;
import com.praktyki.squash.facades.GameFacade;
import com.praktyki.squash.facades.ScoreFacade;
import com.praktyki.squash.facades.dto.GameDTO;
import com.praktyki.squash.model.Score;
import com.praktyki.squash.repository.PlayersRepository;
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

    @Resource
    PlayersRepository playersRepository;

    @GetMapping(value = "score/{gameId}")
    public String score(@PathVariable Integer gameId, ModelMap model){
        GameDTO gameDto = gameFacade.getGame(gameId);

        ScoreForm scoreForm = new ScoreForm();
        scoreForm.setPlayer1Id(gameDto.getPlayer1().getId());
        scoreForm.setPlayer2Id(gameDto.getPlayer2().getId());

        model.addAttribute("game", gameDto);
        model.addAttribute("score",scoreForm );

        return "scores/addScore";
    }
    @PostMapping(value = "/addScore")
    public String addScore(@ModelAttribute ScoreForm score){

        Score player1Score = new Score();
        player1Score.setSets(score.getPoints1());
        player1Score.setGame(score.getGameId());
        scoreRepository.save(player1Score);

        Score player2Score = new Score();
        player2Score.setSets(score.getPoints2());
        player2Score.setGame(score.getGameId());
        scoreRepository.save(player2Score);

        return "redirect:/games/view";
    }
}
