package ITU.WebAvance.NBA.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Saison {
    @Id
    private String idsaison;
    @Column(name = "anneedebut")
    private int anneeDebut;
    @Column(name = "anneefin")
    private int anneeFin;

    public Saison(String idsaison, int anneeDebut, int anneeFin) {
        this.idsaison = idsaison;
        this.anneeDebut = anneeDebut;
        this.anneeFin = anneeFin;
    }

    public Saison() {
    }

    public String getIdsaison() {
        return idsaison;
    }
    public void setIdsaison(String idsaison) {
        this.idsaison = idsaison;
    }
    public int getAnneeDebut() {
        return anneeDebut;
    }
    public void setAnneeDebut(int anneeDebut) {
        this.anneeDebut = anneeDebut;
    }
    public int getAnneeFin() {
        return anneeFin;
    }
    public void setAnneeFin(int anneeFin) {
        this.anneeFin = anneeFin;
    }

}
