package VGL.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import VGL.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
	
	@Query(nativeQuery = true, value="SELECT g.* FROM game g WHERE g.quantity >= 1")
	List<Game> findByAvailability(boolean checkedOut);
	
	@Query(nativeQuery = true, value="SELECT g.* FROM game g WHERE g.checked_out = true")
	List<Game> findByCheckedOut(boolean checkedOut);
	
	
}
