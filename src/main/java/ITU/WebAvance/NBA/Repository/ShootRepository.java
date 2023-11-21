package ITU.WebAvance.NBA.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ITU.WebAvance.NBA.Models.Shoot;

public interface ShootRepository extends JpaRepository<Shoot, String> {
    // Additional custom methods can be added if needed
}
