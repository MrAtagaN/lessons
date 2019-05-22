package JDBC;

import java.io.File;
import java.sql.*;


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
        updateTable();
        deleteFromTable();
        selectFromTable();

    }


    /**
     * Удаление таблицы ADDRESS, если есть
     * Удаление таблицы PERSON, если есть
     * Удаление таблицы WORK, если есть
     */
    public static void dropTableIfExists() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String query = "drop table if exists ADDRESS";
            statement.execute(query);
            System.out.println("DROP TABLE: " + query);

            String query2 = "drop table if exists PERSON";
            statement.execute(query2);
            System.out.println("DROP TABLE: " + query2);

            String query3 = "drop table if exists WORK";
            statement.execute(query3);
            System.out.println("DROP TABLE: " + query3);
        }
    }

    /**
     * Создание таблицы ADDRESS(country, city, street, home)
     * Создание таблицы WORK(name, salary, address_id)
     * Создание таблицы PERSON(name, age, work_id, address_id)
     */
    public static void createTable() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String query = "create table ADDRESS (ID integer primary key, country varchar(20) not null, city varchar(20) not null, street varchar(20) not null, home integer)";
            statement.execute(query);
            System.out.println("CREATE TABLE: " + query);

            String query2 = "create table WORK (ID integer primary key, name varchar(20) not null, salary integer not null, address_id integer, FOREIGN KEY (address_id) REFERENCES address (id))";
            statement.execute(query2);
            System.out.println("CREATE TABLE: " + query2);

            String query3 = "create table PERSON (ID integer primary key, name varchar(20) not null, age integer not null, work_id integer, address_id integer, FOREIGN KEY (work_id) REFERENCES address (id), FOREIGN KEY (address_id) REFERENCES address (id))";
            statement.execute(query3);
            System.out.println("CREATE TABLE: " + query3);
        }
    }

    /**
     * INSERT (Используя executeBatch)
     */
    public static void insertIntoTable() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            //address
            String query = "insert into ADDRESS (country, city, street, home) values ('Russia', 'Moscow', 'Tverskaya', 10)";
            statement.addBatch(query);
            System.out.println("INSERT INTO TABLE: " + query);

            String query2 = "insert into ADDRESS (country, city, street, home) values ('Russia', 'Volgograd', 'Lenina', 5)";
            statement.addBatch(query2);
            System.out.println("INSERT INTO TABLE: " + query2);

            String query6 = "insert into ADDRESS (country, city, street, home) values ('Russia', 'Omsk', 'Stroiteley', 7)";
            statement.addBatch(query6);
            System.out.println("INSERT INTO TABLE: " + query6);

            //work
            String query7 = "insert into WORK (name, salary, address_id) values ('Sberbank', '1000', 1)";
            statement.addBatch(query7);
            System.out.println("INSERT INTO TABLE: " + query7);

            String query8 = "insert into WORK (name, salary, address_id) values ('Gazprom', '1500', 3)";
            statement.addBatch(query8);
            System.out.println("INSERT INTO TABLE: " + query8);

            //person
            String query3 = "insert into PERSON (name, age, work_id, address_id) values ('AtagaN', 25, 1,  1)";
            statement.addBatch(query3);
            System.out.println("INSERT INTO TABLE: " + query3);

            String query4 = "insert into PERSON (name, age, work_id, address_id) values ('Sasha', 30, 2,  2)";
            statement.addBatch(query4);
            System.out.println("INSERT INTO TABLE: " + query4);

            String query5 = "insert into PERSON (name, age, work_id, address_id) values ('Valera (Бомж)', 45, null, 3)";
            statement.addBatch(query5);
            System.out.println("INSERT INTO TABLE: " + query5);

            statement.executeBatch();
            statement.clearBatch();
        }
    }

    /**
     * UPDATE
     */
    public static void updateTable() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String query = "update PERSON set age=29 where name=AtagaN";
            statement.addBatch(query);
            System.out.println("UPDATE TABLE: " + query);
        }
    }

    /**
     * SELECT
     */
    public static void selectFromTable() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String querry = "select * from PERSON";
            ResultSet resultSet = statement.executeQuery(querry);
            System.out.println("SELECT FORM TABLE: " + querry);

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println(name + ", " + age);
            }
        }
    }

    /**
     * ALTER
     */
    public static void alterTable() throws SQLException {
        try (Statement statement = connection.createStatement()) {

        }
    }

    /**
     * DELETE
     */
    public static void deleteFromTable() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String query = "delete from ADDRESS where id = 1";
            statement.addBatch(query);
            System.out.println("DELETE FORM TABLE: " + query);
        }
    }
}
