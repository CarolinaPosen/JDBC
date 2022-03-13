package by.mikhalevich.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Connect {

    public static final String URL = "jdbc:postgresql://localhost:5432/demo";
    public static final String USER = "postgres";
    public static final String PASSWORD = "admin";
    public static final String ALL_AIRCRAFTS = "select aircraft_code, model, range from aircrafts a";
    public static final String AIRCRAFT_CODE = "aircraft_code";
    public static final String MODEL = "model";
    public static final String RANGE = "range";

    public static void main(String[] args) {

//        Connection -> Statement -> ResultSet:
//        ЗАКРЫТИЕ ПРОИСХОДИТ В ОБРАТНОМ ПОРЯДКЕ в блоке try-with-resource либо в секции finaly
        try (
                Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(ALL_AIRCRAFTS);
                ResultSet rs = ps.executeQuery();
        ) {

            List<Aircraft> aircrafts = new ArrayList<>();
            while (rs.next()) {
                aircrafts.add(new Aircraft(
                        rs.getString(AIRCRAFT_CODE),
                        rs.getString(MODEL),
                        rs.getInt(RANGE)
                ));
            }

            print(aircrafts);

        } catch (SQLException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }

    private static void print(List<Aircraft> aircrafts) {
        for (Aircraft aircraft : aircrafts) {
            System.out.println(aircraft.toString());
        }
    }

    private static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        }
}
