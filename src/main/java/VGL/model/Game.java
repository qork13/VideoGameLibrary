package VGL.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Entity
public class Game {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NonNull
	private String title;
	@NonNull
	private String genre;
	@NonNull
	private int players;
	
	public Game(String title, String genre, int players) {
		super();
		this.title = title;
		this.genre = genre;
		this.players = players;
	}
	
	
	
	

}
