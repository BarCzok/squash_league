package com.praktyki.squash.controllers.view;

import com.praktyki.squash.facades.GameFacade;
import com.praktyki.squash.facades.dto.GameDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/games")
public class GameController {

    @Resource
    GameFacade gameFacade;

    @GetMapping(value = "/view")
    public String home(ModelMap model){
        model.addAttribute("games", gameFacade.getGames());
        return "games/view";
    }
}
