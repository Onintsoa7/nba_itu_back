package ITU.WebAvance.NBA.Models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idgame",nullable = false,columnDefinition = "default 'GAME'||nextval('game_seq')")
    private String id;
    @ManyToOne
    @JoinColumn(name = "idteam1",referencedColumnName = "idteam")
    private Team team1;
    @ManyToOne
    @JoinColumn(name = "idteam2",referencedColumnName = "idteam")
    private Team team2;
    @ManyToOne
    @JoinColumn(name = "saison",referencedColumnName = "idsaison")
    private Saison saison;
    @Column(name = "dategame")
    private Timestamp dateGame;
    @Column(name = "typegame")
    private int typeGame;
    
    public Game(String id, Team team1, Team team2, Timestamp dateGame, int typeGame) {
        this.id = id;
        this.team1 = team1;
        this.team2 = team2;
        this.dateGame = dateGame;
        this.typeGame = typeGame;
    }
    public Game() {
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Team getTeam1() {
        return team1;
    }
    public void setTeam1(Team team1) {
        this.team1 = team1;
    }
    public Team getTeam2() {
        return team2;
    }
    public void setTeam2(Team team2) {
        this.team2 = team2;
    }
    public Timestamp getDateGame() {
        return dateGame;
    }
    public void setDateGame(Timestamp dateGame) {
        this.dateGame = dateGame;
    }
    public int getTypeGame() {
        return typeGame;
    }
    public void setTypeGame(int typeGame) {
        this.typeGame = typeGame;
    }
    public Saison getSaison() {
        return saison;
    }
    public void setSaison(Saison saison) {
        this.saison = saison;
    }

}
