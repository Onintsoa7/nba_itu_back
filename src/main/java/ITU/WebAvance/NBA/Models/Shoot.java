package ITU.WebAvance.NBA.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Shoot {
    @Id
    private String idshoot;
    @Column(name = "nameshoot ")
    private String nameShoot;
    @Column(name = "valueshoot")
    private int valueShoot;

    public Shoot(String idshoot, String nameShoot, int valueShoot) {
        this.idshoot = idshoot;
        this.nameShoot = nameShoot;
        this.valueShoot = valueShoot;
    }

    public Shoot() {
    }
    
    public String getIdshoot() {
        return idshoot;
    }
    public void setIdshoot(String idshoot) {
        this.idshoot = idshoot;
    }
    public String getNameShoot() {
        return nameShoot;
    }
    public void setNameShoot(String nameShoot) {
        this.nameShoot = nameShoot;
    }
    public int getValueShoot() {
        return valueShoot;
    }
    public void setValueShoot(int valueShoot) {
        this.valueShoot = valueShoot;
    }

    // Getters, setters, constructors, etc.
}
