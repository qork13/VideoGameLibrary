package VGL.controller;

import org.springframework.context.annotation.Bean;

import VGL.model.Game;

public class BeanConfiguration {

	@Bean
	public Game game() {
		Game bean = new Game( "title", "genre", 1, 1);
		return bean;
	}

}
