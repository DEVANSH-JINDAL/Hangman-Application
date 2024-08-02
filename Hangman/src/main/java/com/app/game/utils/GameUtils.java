package com.app.game.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.SessionScope;

import com.app.game.services.GameService;

@Component
public class GameUtils {

	private int MAX_TRIES = 5;
	
	@Autowired
	ConfigurableApplicationContext applicationContext;
	
	public void reduceTry() {
		
		MAX_TRIES--;
	}
	public int getTriesRemaining() {
		return MAX_TRIES;
	}
	
	public GameService reload() {
		return applicationContext.getBean(GameService.class);
	}
	
	public void resetTries() {
		MAX_TRIES = 5;
	}
}
