package VGL.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Platform {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String platformName;
	@OneToMany(cascade=CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(
			name="games_on_system",
			joinColumns= {@JoinColumn(name="platform.id",
			referencedColumnName="id")},
			inverseJoinColumns= {@JoinColumn(name="game.id",
			referencedColumnName="id", unique=true)}
			)			
	private List<Game> listOfGames;
	
	public Platform(String system) {
		super();
		this.platformName = system;
	}
	
	
}
