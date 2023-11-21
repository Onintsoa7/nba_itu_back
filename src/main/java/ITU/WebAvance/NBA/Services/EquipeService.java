package ITU.WebAvance.NBA.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ITU.WebAvance.NBA.Models.Team;
import ITU.WebAvance.NBA.Repository.EquipeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EquipeService {
    private EquipeRepository equipeRepository;

    @Autowired
    public EquipeService(EquipeRepository teamRepository) {
        this.equipeRepository = teamRepository;
    }

    public List<Team> getAllTeams() {
        return equipeRepository.findAll();
    }

    public Optional<Team> getTeamById(String idteam) {
        return equipeRepository.findById(idteam);
    }

    public Team createOrUpdateTeam(Team team) {
        return equipeRepository.save(team);
    }

    public void deleteTeam(String idteam) {
        equipeRepository.deleteById(idteam);
    }
}
