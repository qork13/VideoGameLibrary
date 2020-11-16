package VGL.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import VGL.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
	
}
