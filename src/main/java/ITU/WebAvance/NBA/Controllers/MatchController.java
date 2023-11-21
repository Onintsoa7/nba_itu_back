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
import ITU.WebAvance.NBA.Models.Game;
import ITU.WebAvance.NBA.Services.MatchService;

@RestController
@RequestMapping("/matches")
public class MatchController {
    private final MatchService gameService;

    @Autowired
    public MatchController(MatchService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseData getAllGames() {
        ResponseData response = new ResponseData();
        try {
            response.setData(gameService.getAllMatches());
        } catch (Exception e) {
            e.printStackTrace();
            response.setError(e.getMessage());
        }
        return response;
    }

    @GetMapping("/{id}")
    public ResponseData getGameById(@PathVariable String id) {
        ResponseData response = new ResponseData();
        try {
            Game game = gameService.getMatchById(id).orElse(null);
            if (game != null) {
                response.addData(game);
            } else {
                response.setError("Game not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setError(e.getMessage());
        }
        return response;
    }

    @PostMapping
    public ResponseData createGame(@RequestBody Game game) {
        ResponseData response = new ResponseData();
        try {
            Game savedGame = gameService.saveOrUpdateMatch(game);
            System.out.println(savedGame.getId());
            response.addData(savedGame);
        } catch (Exception e) {
            e.printStackTrace();
            response.setError(e.getMessage());
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseData deleteGame(@PathVariable String id) {
        ResponseData response = new ResponseData();
        try {
            gameService.deleteMatch(id);
            response.addData("Game deleted successfully");
        } catch (Exception e) {
            e.printStackTrace();
            response.setError(e.getMessage());
        }
        return response;
    }

}
