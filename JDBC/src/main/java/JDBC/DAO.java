package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DAO {

    private static final String URL = "jdbc:mysql://localhost:3306/?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Подключение к базе");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Не найден драйвер");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка при создании соединения");
        }


    }

//    private static Connection getConnection(String url, String username, String password) {
//        Connection connection = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            connection = DriverManager.getConnection(url, username, password);
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("Ошибка при создании соединения");
//        }
//
//        System.out.println("Подключение к базе");
//        return connection;
//    }

    /**
     * Создание базы данных testBase, если нет
     */
    public void createDataBase() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            System.out.println("создание базы данных, если нет");
            String querry = "create database if not exists testBase ";
            statement.execute(querry);
        }
    }




}
