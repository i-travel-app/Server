package hello.entity;

import javax.persistence.*;

//@Entity
//@Table (name = "clothing")
//@NamedQuery(name = "Clothing.findAll", query = "SELECT p FROM Clothing p")
public class Clothing {

//    @Column(nullable=true)
    private int id_clothing;

//    @Column(nullable = true)
    private String dress;

    public Clothing() {
    }

    public int getId_clothing() {
        return id_clothing;
    }

    public void setId_clothing(int id_clothing) {
        this.id_clothing = id_clothing;
    }

    public String getDress() {
        return dress;
    }

    public void setDress(String dress) {
        this.dress = dress;
    }
}
