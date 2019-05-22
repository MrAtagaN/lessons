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
        insertIntoTable();

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

            String query2 = "create table PERSON (ID integer primary key, name varchar(20) not null, age integer not null, address_id integer, FOREIGN KEY (address_id) REFERENCES address (id))";
            statement.execute(query2);
            System.out.println("CREATE TABLE: " + query2);
        }
    }

    /**
     *  Вставка данных в таблицы (Используя executeBatch)
     */
    public static void insertIntoTable() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String query = "insert into ADDRESS (country, city, street, home) values ('Russia', 'Moscow', 'Tverskaya', 10)";
            statement.addBatch(query);
            System.out.println("INSERT INTO TABLE: " + query);

            String query2 = "insert into ADDRESS (country, city, street, home) values ('Russia', 'Volgograd', 'Lenina', 5)";
            statement.addBatch(query2);
            System.out.println("INSERT INTO TABLE: " + query2);

            String query3 = "insert into PERSON (name, age, address_id) values ('AtagaN', 25, 1)";
            statement.addBatch(query3);
            System.out.println("INSERT INTO TABLE: " + query3);

            String query4 = "insert into PERSON (name, age, address_id) values ('Sasha', 30, 2)";
            statement.addBatch(query4);
            System.out.println("INSERT INTO TABLE: " + query4);

            statement.executeBatch();
            statement.clearBatch();
        }
    }
}
