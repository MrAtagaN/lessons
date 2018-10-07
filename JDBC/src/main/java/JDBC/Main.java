package JDBC;

import java.sql.*;


public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";


    /**
     * Создает базу testBase, если нет
     * Удаляет в ней таблицу products(id, name, price), если есть
     * Создает таблицу products(id, name, price)
     * Делает вставки, изменения, получение результатов через Statement, PreparedStatemet, Batch
     * Транзакции
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //объект для запросов
        try (Connection connection = DAO.getConnection(URL, USERNAME, PASSWORD); Statement statement = connection.createStatement()) {
            String querry;

            //создание базы данных, если нет
            querry = "create database if not exists testBase ";
            statement.execute(querry);
            System.out.println(querry);

            //удаление таблицы, если есть
            querry = "drop table if exists testBase.products ";
            statement.execute(querry);
            System.out.println(querry);

            /**
             * Statement
             */
            //создание таблицы
            querry = "create table testBase.products (ID int NOT NULL AUTO_INCREMENT primary key , name varchar(20) not null, price integer)";
            statement.execute(querry);
            System.out.println(querry);

            /**
             *  Batch
             */
            //вставка в таблицу
            querry = "insert into testBase.products (id, name, price) values (1, 'cheese', 192)";
            statement.addBatch(querry);
            System.out.println(querry);

            querry = "insert into testBase.products (name, price) values (\"meet\", 234)";
            statement.addBatch(querry);
            System.out.println(querry);

            querry = "insert into testBase.products (name, price) values (\"milk\", 47)";
            statement.addBatch(querry);
            System.out.println(querry);

            querry = "insert into testBase.products (name, price) values (\"cola\", 99)";
            statement.addBatch(querry);
            System.out.println(querry);

            statement.executeBatch();
            statement.clearBatch();

            //обновление таблицы
            querry = "update testBase.products set price=77 where name='cola'";
            statement.executeUpdate(querry);
            System.out.println(querry);

            //извлечение данных
            querry = "select * from testBase.products";
            ResultSet resultSet = statement.executeQuery(querry);
            System.out.println(querry);

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                System.out.println(name + ", " + price);
            }

            //удаление строк
            querry = "delete from testBase.products where price > 100";
            statement.executeUpdate(querry);
            System.out.println(querry);

            /**
             * PreparedStatemet
             */

            //вставка данных через PreparedStatemet
            querry = "insert into testBase.products (name, price) values (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setInt(2, 232);
            preparedStatement.setString(1, "burger");
            preparedStatement.execute();
            preparedStatement.close();

            //обновление таблицы через PreparedStatemet
            querry = "update testBase.products set price = ? where name = 'burger'";
            PreparedStatement preparedStatement2 = connection.prepareStatement(querry);
            preparedStatement2.setInt(1, 255);
            preparedStatement2.execute();
            System.out.println(querry);
            preparedStatement2.close();

            //извлечение данных через PreparedStatemet
            querry = "select * from testBase.products where price > ?";
            PreparedStatement preparedStatement3 = connection.prepareStatement(querry);
            preparedStatement3.setInt(1, 10);
            ResultSet resultSet2 = preparedStatement3.executeQuery();
            System.out.println(querry);

            while (resultSet2.next()) {
                String name = resultSet2.getString("name");
                String price = resultSet2.getString("price");
                System.out.println(name + ", " + price);
            }
            preparedStatement3.close();

            /**
             * Транзакции
             */
            connection.setAutoCommit(false);
            Savepoint savepoint = connection.setSavepoint();

            querry = "insert into testBase.products (name, price) values ('eggs', 434)";
            statement.execute(querry);
            System.out.println(querry);

            connection.rollback(savepoint);
            System.out.println("rollback    " + querry);

            connection.commit();

        }
    }
}
