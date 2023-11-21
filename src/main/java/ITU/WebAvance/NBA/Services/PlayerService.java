package ITU.WebAvance.NBA.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ITU.WebAvance.NBA.Models.Player;
import ITU.WebAvance.NBA.Repository.PlayerRepository;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> getPlayerById(String idplayer) {
        return playerRepository.findById(idplayer);
    }

    public Player createOrUpdatePlayer(Player player) {
        return playerRepository.save(player);
    }

    public void deletePlayer(String idplayer) {
        playerRepository.deleteById(idplayer);
    }
}