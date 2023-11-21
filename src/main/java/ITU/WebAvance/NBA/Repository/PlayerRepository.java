package ITU.WebAvance.NBA.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ITU.WebAvance.NBA.Models.Player;
import ITU.WebAvance.NBA.Models.Team;

public interface PlayerRepository extends JpaRepository<Player, String> {
    List<Player> findByTeam(Team team);
}
