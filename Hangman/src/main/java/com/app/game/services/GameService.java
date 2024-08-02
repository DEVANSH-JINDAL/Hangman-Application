package com.app.game.services;


import java.util.Random;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

//@Scope("prototype")
@Service
@SessionScope
public class GameService {
	
	private String[] randomWords = {"hello", "world", "testing", "trial", "java", "game"};

	Random random = new Random();
	String finalWord = null;
	char[] wordArr = null;
	
	public GameService() {
		reset();
		
	}
	public void reset() {
		finalWord = randomWords[random.nextInt(randomWords.length)];
		wordArr = new char[finalWord.length()];
		System.out.println(finalWord);
	}
	
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		for(int i=0; i<wordArr.length; i++) {
			if(wordArr[i] == '\u0000') {
				str.append('_');
			}
			else {
				str.append(wordArr[i]);
			}
			str.append(" ");
		}
		return str.toString();
	}
	
	public boolean addGuessed(char ch) {
		
		System.out.println(ch);
		boolean check = false;
		for(int i=0; i<finalWord.length(); i++) {
			if(finalWord.charAt(i) == ch) {
				check = true;
				wordArr[i] = ch;
			}
		}
		System.out.println(new String(wordArr));
		
		return check;
		
	}
	
	
	
	

}
