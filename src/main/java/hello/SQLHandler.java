package hello;


import java.sql.*;
import java.util.ArrayList;

public class SQLHandler {
    private static Connection connection;
    private static ResultSet res;
    private static PreparedStatement ps;
    private static final String url = "jdbc:sqlite:i-travel_test.db";

    public static void insert(String country, String city) throws SQLException {
        ps = connection.prepareStatement("INSERT INTO category (country, city) VALUES (?, ?);");
        ps.setString(1,country);
        ps.setString(2, city);
        ps.executeUpdate();

        ps.close();
    }
    public static int inner(String a, String b) throws SQLException {
        ps = connection.prepareStatement("SELECT dress FROM clothing INNER JOIN summary on id_weather = ? AND id_sex = ? WHERE id_clothing = id_dress;");
        ps.setString(1, a);
        ps.setString(2, b);
        res = ps.executeQuery();
        return res.getInt(1);
    }
    public static ArrayList<String> www(int a, int b) throws SQLException {
        ArrayList<String> clothing = new ArrayList<>();
        ps = connection.prepareStatement("select id_dress from summary where id_weather = ? and id_sex = ?;");
        ps.setInt(1, a);
        ps.setInt(2, b);
        res = ps.executeQuery();
        ps = connection.prepareStatement("select dress from clothing where id_clothing = ?;");
        ps.setString(1, res.getInt(1)+"");
        res = ps.executeQuery();
        while (res.next()){
            clothing.add(res.getString(1));
        }
        return clothing;
    }

    public static String selectIII(String city) throws SQLException {
        ps = connection.prepareStatement("select dress from clothing where id_clothing=?");
        ps.setString(1, city);
        res = ps.executeQuery();
        //list = new ArrayList<>();
        while (res.next()){
            new ArrayList<>().add(res.getString(1));
        }

        return "";
    }

    public static int select(String city) throws SQLException {
        ps = connection.prepareStatement("SELECT id FROM category WHERE city = ?;");
        ps.setString(1, city);
       res = ps.executeQuery();
        return res.getInt(1);
    }


    public static void connect() throws SQLException {
        connection = DriverManager.getConnection(url);
    }
    public static void disconnect() {
        try {
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
