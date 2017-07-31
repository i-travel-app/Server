package hello.entity;


public class Summary {
    private int id_weather;
    private int id_sex;
    private int id_dress;
    private int id_tip;

    public Summary() {
    }

    public int getId_tip() {
        return id_tip;
    }

    public void setId_tip(int id_tip) {
        this.id_tip = id_tip;
    }

    public int getId_weather() {
        return id_weather;
    }

    public void setId_weather(int id_weather) {
        this.id_weather = id_weather;
    }

    public int getId_sex() {
        return id_sex;
    }

    public void setId_sex(int id_sex) {
        this.id_sex = id_sex;
    }

    public int getId_dress() {
        return id_dress;
    }

    public void setId_dress(int id_dress) {
        this.id_dress = id_dress;
    }
}
