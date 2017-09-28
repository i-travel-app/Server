package de.rest.entity;

import javax.persistence.*;

@Entity
public class Summary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;
    @Column
    private Integer id_weather;
    @Column
    private Integer id_sex;
    @Column
    private Integer id_tip;
    @Column
    private Integer id_d1;
    @Column
    private Integer id_d2;
    @Column
    private Integer id_d3;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_weather() {
        return id_weather;
    }

    public void setId_weather(Integer id_weather) {
        this.id_weather = id_weather;
    }

    public Integer getId_sex() {
        return id_sex;
    }

    public void setId_sex(Integer id_sex) {
        this.id_sex = id_sex;
    }

    public Integer getId_tip() {
        return id_tip;
    }

    public void setId_tip(Integer id_tip) {
        this.id_tip = id_tip;
    }

    public Integer getId_d1() {
        return id_d1;
    }

    public void setId_d1(Integer id_d1) {
        this.id_d1 = id_d1;
    }

    public Integer getId_d2() {
        return id_d2;
    }

    public void setId_d2(Integer id_d2) {
        this.id_d2 = id_d2;
    }

    public Integer getId_d3() {
        return id_d3;
    }

    public void setId_d3(Integer id_d3) {
        this.id_d3 = id_d3;
    }
}
