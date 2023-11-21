package ITU.WebAvance.NBA.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ITU.WebAvance.DTO.ResponseData;
import ITU.WebAvance.NBA.Models.Saison;
import ITU.WebAvance.NBA.Services.SaisonService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/saisons")
public class SaisonController {
    private final SaisonService saisonService;

    @Autowired
    public SaisonController(SaisonService saisonService) {
        this.saisonService = saisonService;
    }

    @GetMapping
    public ResponseData getAllSaisons() {
        ResponseData response = new ResponseData();
        try {
            List<Saison> saisons = saisonService.getAllSaisons();
            response.setData(saisons);
        } catch (Exception e) {
            e.printStackTrace();
            response.setError(e.getMessage());
        }
        return response;
    }

    @GetMapping("/{id}")
    public ResponseData getSaisonById(@PathVariable String id) {
        ResponseData response = new ResponseData();
        try {
            Optional<Saison> saison = saisonService.getSaisonById(id);
            if (saison != null) {
                response.addData(saison.get());
            } else {
                response.setError("Saison not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setError(e.getMessage());
        }
        return response;
    }

    @PostMapping
    public ResponseData createSaison(@RequestBody Saison saison) {
        ResponseData response = new ResponseData();
        try {
            Saison savedSaison = saisonService.createOrUpdateSaison(saison);
            response.addData(savedSaison);
        } catch (Exception e) {
            e.printStackTrace();
            response.setError(e.getMessage());
        }
        return response;
    }
}
