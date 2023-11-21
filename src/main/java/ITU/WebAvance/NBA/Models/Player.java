package ITU.WebAvance.NBA.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Player {
    @Id
    private String idplayer;
    private String namePlayer;
    private int numberPlayer;

    @ManyToOne
    @JoinColumn(name = "idteam",referencedColumnName = "idteam")
    private Team team;

    public Player(String idplayer, String namePlayer, int numberPlayer, Team team) {
        this.idplayer = idplayer;
        this.namePlayer = namePlayer;
        this.numberPlayer = numberPlayer;
        this.team = team;
    }

    public Player() {
    }

    public String getIdplayer() {
        return idplayer;
    }

    public void setIdplayer(String idplayer) {
        this.idplayer = idplayer;
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public int getNumberPlayer() {
        return numberPlayer;
    }

    public void setNumberPlayer(int numberPlayer) {
        this.numberPlayer = numberPlayer;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
