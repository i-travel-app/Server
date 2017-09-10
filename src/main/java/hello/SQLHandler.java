package hello;

import java.sql.*;

import java.util.ArrayList;

/**
 * Обрабатываем обращения к БД
 */
public class SQLHandler {
    private static Connection connection;
    private static ResultSet res;
    private static PreparedStatement ps;
    private static final String url = "jdbc:sqlite:i-travel_test.db";

    /**
     * Добавляем данные в БД
     */
    public static int insertData(int id, String dress) throws SQLException {
        int res = 0;
        ps = connection.prepareStatement("INSERT INTO clothing (id_clothing, dress) VALUES (?, ?);");
        ps.setInt(1, id);
        ps.setString(2, dress);
        res = ps.executeUpdate();
        ps.close();
        return res;
    }

    /**
     * Удаляем данные из БД
     */
    //TODO: Удалить после открытого релиза
    public static int deleteData(String dress) throws SQLException {
        int res = 0;
        ps = connection.prepareStatement("DELETE FROM clothing WHERE dress = ?;");
        ps.setString(1, dress);
        res = ps.executeUpdate();
        ps.close();
        return res;
    }

    /**
     * Обращаемся к БД с тремя параметрами, на выходе набор одежды
     */
    public static ArrayList<String> requestData(int weather, int sex, int tip) throws SQLException {
        ArrayList<String> clothing = new ArrayList<>();
        ps = connection.prepareStatement("SELECT id_dress FROM summary WHERE id_weather = ? AND id_sex = ? AND id_tip = ?;");
        ps.setInt(1, weather);
        ps.setInt(2, sex);
        ps.setInt(3, tip);
        res = ps.executeQuery();
        ps = connection.prepareStatement("SELECT dress FROM clothing WHERE id_clothing = ?;");
        ps.setString(1, res.getInt(1) + "");
        res = ps.executeQuery();
        while (res.next()) {
            clothing.add(res.getString(1));
        }
        return clothing;
    }

    /**
     * Создаем соединение с БД
     */
    public static void connect() throws SQLException {
        connection = DriverManager.getConnection(url);
    }

    /**
     * Отключаемся от БД
     */
    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
