package ITU.WebAvance.NBA.Models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import ITU.WebAvance.NBA.Repository.PlayerRepository;

@Entity
public class Team {
    @Id
    private String idteam;
    @Column(name = "nameteam")
    private String nameTeam;
    private String arena;
    private int conference;

    @Transient
    List<Player> players;

    public Team(String idteam, String nameTeam, String arena, int conference) {
        this.idteam = idteam;
        this.nameTeam = nameTeam;
        this.arena = arena;
        this.conference = conference;
    }

    public Team() {
    }

    public String getIdteam() {
        return idteam;
    }
    public void setIdteam(String idteam) {
        this.idteam = idteam;
    }
    public String getNameTeam() {
        return nameTeam;
    }
    public void setNameTeam(String nameTeam) {
        this.nameTeam = nameTeam;
    }
    public String getArena() {
        return arena;
    }
    public void setArena(String arena) {
        this.arena = arena;
    }
    public int getConference() {
        return conference;
    }
    public void setConference(int conference) {
        this.conference = conference;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(PlayerRepository repo) {
        this.players = repo.findByTeam(this);
    }
}

