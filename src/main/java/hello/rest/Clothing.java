package hello.rest;

import javax.persistence.*;

/**
 * Создаем сущьность для добавления и удаления данных
 */
@Entity
public class Clothing {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String dress;
    @Column
    private Integer id_element;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDress() {
        return dress;
    }

    public void setDress(String dress) {
        this.dress = dress;
    }

    public Integer getId_element() {
        return id_element;
    }

    public void setId_element(Integer id_element) {
        this.id_element = id_element;
    }
}
