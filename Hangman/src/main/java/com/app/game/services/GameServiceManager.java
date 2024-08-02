package com.app.game.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class GameServiceManager {
	
	private final GameService gameService;
	
	@Autowired
	public GameServiceManager(GameService gameService) {
		this.gameService = gameService;
	}
	
	public GameService getGameService() {
		return gameService;
	}

}
