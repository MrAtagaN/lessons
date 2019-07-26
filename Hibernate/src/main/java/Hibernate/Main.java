package Hibernate;


/**
 * SQLite
 */
public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setAge(31);
        user.setName("AtagaN");

        UserDAO userDAO = new UserDAO();
        userDAO.saveUser(user);



        HibernateUtil.getSessionFactory().close();
    }
}
