package ITU.WebAvance.NBA.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ITU.WebAvance.NBA.Models.Team;

public interface EquipeRepository extends JpaRepository<Team, String> {
    // Additional custom methods can be added if needed
}
