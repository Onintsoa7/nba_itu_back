package ITU.WebAvance.NBA.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ITU.WebAvance.NBA.Models.Shoot;
import ITU.WebAvance.NBA.Repository.ShootRepository;

@Service
public class ShootService {
    private final ShootRepository shootRepository;

    @Autowired
    public ShootService(ShootRepository shootRepository) {
        this.shootRepository = shootRepository;
    }

    public List<Shoot> getAllShoots() {
        return shootRepository.findAll();
    }

    public Optional<Shoot> getShootById(String idshoot) {
        return shootRepository.findById(idshoot);
    }

    public Shoot createOrUpdateShoot(Shoot shoot) {
        return shootRepository.save(shoot);
    }

    public void deleteShoot(String idshoot) {
        shootRepository.deleteById(idshoot);
    }
}
