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
	@NonNull
	private boolean checkedOut;
	@NonNull
	private String platform;
	@NonNull
	private int quantity;
	
	public Game(String title, String genre, int players, boolean checkedOut, String platform, int quantity) {
		super();
		this.title = title;
		this.genre = genre;
		this.players = players;
		this.checkedOut = checkedOut;
		this.platform = platform;
		this.quantity = quantity;

	}
	
	public Game(String title, String genre, int players, int quantity) {
		super();
		this.title = title;
		this.genre = genre;
		this.players = players;
		
	}
	public Game(String title, String genre, int players, boolean checkedOut) {
		super();
		this.title = title;
		this.genre = genre;
		this.players = players;
		this.checkedOut = checkedOut;
	}
	public Game(String title, String genre, int players) {
		super();
		this.title = title;
		this.genre = genre;
		this.players = players;
	}
	
	
	
	

}
