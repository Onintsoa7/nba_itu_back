package ITU.WebAvance.NBA.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ITU.WebAvance.NBA.Models.Saison;

public interface SaisonRepository extends JpaRepository<Saison, String> {
    
}
