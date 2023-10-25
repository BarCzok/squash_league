package com.praktyki.squash.controllers;

import com.praktyki.squash.facades.GameFacade;
import com.praktyki.squash.facades.dto.GameDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Resource
    GameFacade gameFacade;


    @GetMapping
    public List<GameDTO> getGames(){
        return gameFacade.getGames();
    }
}
