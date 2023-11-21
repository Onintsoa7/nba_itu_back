package ITU.WebAvance.NBA.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ITU.WebAvance.DTO.ResponseData;
import ITU.WebAvance.NBA.Models.Team;
import ITU.WebAvance.NBA.Services.EquipeService;

@RestController
@RequestMapping("/equipes")
public class EquipeController {
    private final EquipeService equipeService;

    @Autowired
    public EquipeController(EquipeService equipeService) {
        this.equipeService = equipeService;
    }

    @GetMapping
    public ResponseData getAllEquipes() {
        ResponseData response = new ResponseData();
        try {
            List<Team> equipes = equipeService.getAllTeams();
            response.setData(equipes);
        } catch (Exception e) {
            e.printStackTrace();
            response.setError(e.getMessage());
        }
        return response;
    }

    @GetMapping("/{id}")
    public ResponseData getEquipeById(@PathVariable String id) {
        ResponseData response = new ResponseData();
        try {
            Optional<Team> equipe = equipeService.getTeamById(id);
            if (equipe.isPresent()) {
                response.addData(equipe.get());
            } else {
                response.setError("Equipe not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setError(e.getMessage());
        }
        return response;
    }

    @PostMapping
    public ResponseData createEquipe(@RequestBody Team equipe) {
        ResponseData response = new ResponseData();
        try {
            Team savedEquipe = equipeService.createOrUpdateTeam(equipe);
            response.addData(savedEquipe);
        } catch (Exception e) {
            e.printStackTrace();
            response.setError(e.getMessage());
        }
        return response;
    }
}
