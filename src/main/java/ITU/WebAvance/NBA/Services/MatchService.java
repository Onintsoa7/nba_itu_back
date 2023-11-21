package ITU.WebAvance.NBA.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ITU.WebAvance.NBA.Models.Game;
import ITU.WebAvance.NBA.Repository.MatchRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {
    private final MatchRepository matchRepository;

    @Autowired
    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<Game> getAllMatches() {
        return matchRepository.findAll();
    }

    public Optional<Game> getMatchById(String id) {
        return matchRepository.findById(id);
    }

    public Game saveOrUpdateMatch(Game match) {
        return matchRepository.save(match);
    }

    public void deleteMatch(String id) {
        matchRepository.deleteById(id);
    }
}

