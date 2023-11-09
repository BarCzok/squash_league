package com.praktyki.squash.controllers.view;

import com.praktyki.squash.controllers.forms.ScoreForm;
import com.praktyki.squash.facades.GameFacade;
import com.praktyki.squash.facades.RoundFacade;
import com.praktyki.squash.facades.ScoreFacade;
import com.praktyki.squash.facades.dto.GameDTO;
import com.praktyki.squash.model.Score;
import com.praktyki.squash.repository.GameRepository;
import com.praktyki.squash.repository.PlayersRepository;
import com.praktyki.squash.repository.ScoreRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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
    RoundFacade roundFacade;

    @Resource
    ScoreFacade scoreFacade;

    @Resource
    ScoreRepository scoreRepository;

    @Resource
    PlayersRepository playersRepository;

    @Resource
    GameRepository gameRepository;

    @GetMapping(value = "score/{gameId}")
    public String score(@PathVariable Integer gameId, ModelMap model){
        GameDTO gameDto = gameFacade.getGame(gameId);

        ScoreForm scoreForm = new ScoreForm();
        scoreForm.setPlayer1Id(gameDto.getPlayer1().getId());
        scoreForm.setPlayer2Id(gameDto.getPlayer2().getId());

        scoreForm.setPlayer1Name(gameDto.getPlayer1().getName());
        scoreForm.setPlayer2Name(gameDto.getPlayer2().getName());

        scoreForm.setGameId(gameDto.getId());


        model.addAttribute("score",scoreForm );

        return "scores/addScore";
    }
    @PostMapping(value = "/addScore")
    public String addScore(@ModelAttribute ScoreForm scoreForm, ModelMap model){
        if(scoreForm.getPoints1() + scoreForm.getPoints2() != 5){
            model.addAttribute("score",scoreForm );
            model.addAttribute("errorMsg","Incorrect data" );

            return "scores/addScore";
        }

//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User principal = (User) auth.getPrincipal();
//        if(scoreForm.getPlayer1Name() != principal.getUsername() ||
//                scoreForm.getPlayer2Name() != principal.getUsername()){
//            model.addAttribute("score",scoreForm );
//            model.addAttribute("haker","NIE TWOJ MECZ bratku" );
//
//            return "scores/addScore";
//        }


        Score player1Score = new Score();
        player1Score.setSets(scoreForm.getPoints1());
        player1Score.setPlayer(playersRepository.findById(scoreForm.getPlayer1Id()).get());
        player1Score.setGame(gameRepository.findById(scoreForm.getGameId()).get());
        scoreRepository.save(player1Score);

        Score player2Score = new Score();
        player2Score.setSets(scoreForm.getPoints2());
        player2Score.setPlayer(playersRepository.findById(scoreForm.getPlayer2Id()).get());
        player2Score.setGame(gameRepository.findById(scoreForm.getGameId()).get());
        scoreRepository.save(player2Score);

        return "redirect:/rounds/"+ player1Score.getGame().getRound().getId() +"/view";
    }
}