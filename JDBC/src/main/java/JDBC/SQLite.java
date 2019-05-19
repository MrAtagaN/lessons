package JDBC;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * База SQLite  lessons.db
 */
public class SQLite {

    private static final String FS = File.separator;
    private static final String URL = "jdbc:sqlite:JDBC" + FS + "src" + FS + "main" + FS + "resources" + FS + "lessons.db";

    private static Connection connection;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection(URL);

        dropTableIfExists();
        createTable();
    }


    /**
     * Удаление таблицы products, если есть
     */
    public static void dropTableIfExists() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String query = "drop table if exists products";
            statement.execute(query);
            System.out.println(query);
        }
    }

    /**
     * Создание таблицы products(id, name, price)
     */
    public static void createTable() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String query = "create table products (ID int, name varchar(20) not null, price integer)";
            statement.execute(query);
            System.out.println(query);
        }
    }
}
