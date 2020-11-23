package VGL.controller;



import org.springframework.context.annotation.Bean;


import VGL.model.Game;
import VGL.model.Platform;

public class BeanConfiguration {

	@Bean
	public Game game() {
		Game bean = new Game( "title", "genre", 1, 0);
		return bean;
	}
	
	@Bean
	public Platform platform() {
		Platform bean = new Platform("system");
		return bean;
	}
	

}
