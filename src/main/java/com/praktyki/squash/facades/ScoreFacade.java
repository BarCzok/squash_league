package com.praktyki.squash.facades;

import com.praktyki.squash.controllers.forms.ScoreForm;
import com.praktyki.squash.facades.dto.ScoreDTO;
import com.praktyki.squash.model.Score;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class ScoreFacade {

    @Resource
    PlayerFacade playerFacade;


    public List<ScoreDTO> convertScores(List<Score> scores) {
        if(scores.isEmpty()){
            return new ArrayList<>();
        }

        ScoreDTO score1 = convertScore(scores.get(0));
        ScoreDTO score2 = convertScore(scores.get(1));

        if(score1.getSets() > score2.getSets()){
            score1.setPointsForWinning(2);
            score2.setPointsForWinning(0);
        }
        else{
            score1.setPointsForWinning(0);
            score2.setPointsForWinning(2);
        }
        score1.setTotalPoints(score1.getPointsForWinning() + score1.getPointsForPlaying() + score1.getPointsForSets() );
        score2.setTotalPoints(score2.getPointsForWinning() + score2.getPointsForPlaying() + score2.getPointsForSets());

        return List.of(score1, score2);
    }

    private ScoreDTO convertScore(Score score) {
        ScoreDTO scoreDto = new ScoreDTO();

        scoreDto.setSets(score.getSets());
        scoreDto.setPointsForPlaying(2);
        scoreDto.setPointsForSets(score.getSets()*2);
        scoreDto.setPlayer(playerFacade.convertPlayer(score.getPlayer()));

        return scoreDto;
    }
}