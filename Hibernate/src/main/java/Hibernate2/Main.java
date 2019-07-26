package Hibernate2;

import java.util.Arrays;

/**
 * Postgres
 */
public class Main {

    public static void main(String[] args) {

        User userMasha = new User();
        userMasha.setName("Masha");
        userMasha.setAge(34);

        Auto lada = new Auto();
        lada.setColor("Red");
        lada.setModel("Lada");
        lada.setUser(userMasha);

        Auto mersedes = new Auto();
        mersedes.setColor("Black");
        mersedes.setModel("Mersedes");
        mersedes.setUser(userMasha);

        userMasha.setAutos(Arrays.asList(lada, mersedes));

        UserDAO userDAO = new UserDAO();
        userDAO.saveUser(userMasha);



        HibernateUtil.getSessionFactory().close();
    }
}
