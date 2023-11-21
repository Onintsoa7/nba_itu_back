package ITU.WebAvance.NBA.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ITU.WebAvance.NBA.Models.Game;

@Repository
public interface MatchRepository extends JpaRepository<Game, String> {
    // Additional custom methods if needed
}
