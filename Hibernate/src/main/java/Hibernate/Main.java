package Hibernate;


import java.time.LocalDateTime;
import java.util.Date;

/**
 * SQLite
 */
public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setAge(31);
        user.setName("AtagaN");
        user.setBirthday(LocalDateTime.now());
        user.setState(User.State.MALE);

        UserDAO userDAO = new UserDAO();
        userDAO.saveUser(user);



        HibernateUtil.getSessionFactory().close();
    }
}
