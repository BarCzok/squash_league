package com.praktyki.squash.controllers;

import com.praktyki.squash.TestData;
import com.praktyki.squash.model.Groupss;
import com.praktyki.squash.repository.GroupssRepository;
import com.praktyki.squash.repository.RoundRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Controller
public class HomeController {

	@Resource
	TestData testData;

	@Resource
	GroupssRepository groupssRepository;

	@Resource
	RoundRepository roundRepository;

	@GetMapping(value = "/home")
	public String home(ModelMap model){

		testData.createPlayers();
		testData.createRound();
		testData.createGroupss();

		testData.createHistories();

		testData.createGames();
//        testData.createScores();
		testData.getPlayersByPhoneNr();

		int roundId = roundRepository.findAll().iterator().next().getId();

		for (Groupss groupss : groupssRepository.findAll()) {
			testData.createGroupTransitions(groupss, roundId);
		}

		return "home";
	}
}
