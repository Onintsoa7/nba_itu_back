package ITU.WebAvance.NBA.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ITU.WebAvance.DTO.ResponseData;
import ITU.WebAvance.NBA.Models.Player;
import ITU.WebAvance.NBA.Services.PlayerService;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public ResponseData getAllPlayers() {
        ResponseData response = new ResponseData();
        try {
            response.setData(playerService.getAllPlayers());
        } catch (Exception e) {
            e.printStackTrace();
            response.setError(e.getMessage());
        }
        return response;
    }

    @GetMapping("/{id}")
    public ResponseData getPlayerById(@PathVariable String id) {
        ResponseData response = new ResponseData();
        try {
            Player player = playerService.getPlayerById(id).orElse(null);
            if (player != null) {
                response.addData(player);
            } else {
                response.setError("Player not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setError(e.getMessage());
        }
        return response;
    }

    @PostMapping
    public ResponseData createPlayer(@RequestBody Player player) {
        ResponseData response = new ResponseData();
        try {
            Player savedPlayer = playerService.createOrUpdatePlayer(player);
            response.addData(savedPlayer);
        } catch (Exception e) {
            e.printStackTrace();
            response.setError(e.getMessage());
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseData deletePlayer(@PathVariable String id) {
        ResponseData response = new ResponseData();
        try {
            playerService.deletePlayer(id);
            response.addData("Player deleted successfully");
        } catch (Exception e) {
            e.printStackTrace();
            response.setError(e.getMessage());
        }
        return response;
    }
}
