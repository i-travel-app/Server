package hello.entity;

/**
 * Создаем сущьность для обработки запроса к БД
 */
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

    public int getId_weather() {
        return id_weather;
    }

    public int getId_sex() {
        return id_sex;
    }
}
