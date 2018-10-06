package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by AtagaN on 29.08.2018.
 */
public class DAO {

    public static Connection getConnection(String url, String username, String password) throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Ошибка при создании соединения");
            e.printStackTrace();
            connection.close();
        }

        System.out.println("Подключение к базе");
        return connection;
    }

}
