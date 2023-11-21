package ITU.WebAvance.NBA.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ITU.WebAvance.NBA.Models.Saison;
import ITU.WebAvance.NBA.Repository.SaisonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SaisonService {
    private final SaisonRepository saisonRepository;

    @Autowired
    public SaisonService(SaisonRepository saisonRepository) {
        this.saisonRepository = saisonRepository;
    }

    public List<Saison> getAllSaisons() {
        return saisonRepository.findAll();
    }

    public Optional<Saison> getSaisonById(String idsaison) {
        return saisonRepository.findById(idsaison);
    }

    public Saison createOrUpdateSaison(Saison saison) {
        return saisonRepository.save(saison);
    }

    public void deleteSaison(String idsaison) {
        saisonRepository.deleteById(idsaison);
    }
}

