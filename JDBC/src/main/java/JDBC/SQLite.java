package JDBC;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * База SQLite  lessonsJDBC.db
 */
public class SQLite {

    private static final String FS = File.separator;
    private static final String URL = "jdbc:sqlite:JDBC" + FS + "src" + FS + "main" + FS + "resources" + FS + "lessonsJDBC.db";
    private static Connection connection;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection(URL);
        System.out.println("Подключение к базе");

        dropTableIfExists();
        createTable();
    }


    /**
     * Удаление таблицы ADDRESS, если есть
     * Удаление таблицы PERSON, если есть
     */
    public static void dropTableIfExists() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String query = "drop table if exists ADDRESS";
            statement.execute(query);
            System.out.println("DROP TABLE: " + query);

            String query2 = "drop table if exists PERSON";
            statement.execute(query2);
            System.out.println("DROP TABLE: " + query2);
        }
    }

    /**
     * Создание таблицы ADDRESS(country, city, street, home)
     * Создание таблицы PERSON(name, age, address)
     */
    public static void createTable() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String query = "create table ADDRESS (ID integer primary key, country varchar(20) not null, city varchar(20) not null, street varchar(20) not null, home integer)";
            statement.execute(query);
            System.out.println("CREATE TABLE: " + query);

            String query2 = "create table PERSON (ID integer primary key, name varchar(20) not null, age integer not null, address integer, FOREIGN KEY (address) REFERENCES address (id))";
            statement.execute(query2);
            System.out.println("CREATE TABLE: " + query2);
        }
    }
}
