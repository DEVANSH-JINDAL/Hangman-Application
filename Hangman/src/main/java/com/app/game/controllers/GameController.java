package com.app.game.controllers;

import java.applet.AppletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.game.services.GameService;
import com.app.game.services.GameServiceManager;
import com.app.game.utils.GameUtils;

@Controller
public class GameController {
	
	@Autowired 
	ConfigurableApplicationContext  applicationContext;
	
	@Autowired
	GameServiceManager gameServiceManager;
	
	@Autowired
	GameService gameService;
	
	
	@Autowired
	private GameUtils gameUtils;
	
	@GetMapping("/game-home")
	public String getGameController(@RequestParam(value ="guessedChar", required = false) String guessedChar , Model model) {
		//GameService gameService = gameServiceManager.getGameService();
		
		if(guessedChar!=null && guessedChar.length()>0) {
		boolean check = gameService.addGuessed(guessedChar.charAt(0));
		if(check == false) {
			gameUtils.reduceTry();
		}
		}
		
		String word = gameService.toString();
		model.addAttribute("wordToDisplay", word);
		model.addAttribute("tries", gameUtils.getTriesRemaining());
		
		
		
		return "game-home-page"; 
	}
	
	@GetMapping("/reload")
	public String reload() {
		//gameService = applicationContext.getBean(GameService.class);
		gameService.reset();
		gameService = gameUtils.reload();
		gameUtils.resetTries();
		return "redirect:/game-home";
	}

}
