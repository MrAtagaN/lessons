package Hibernate;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


        User user2 = new User();
        user2.setName("aaa");
        User user3 = new User();
        user3.setName("bbb");

        List<User> list = new ArrayList<>();
        list.add(user2);
        list.add(user3);

        UserDAO userDAO = new UserDAO();
        userDAO.saveUser(user);
        userDAO.saveOrUpdateListObjects(list);

        System.out.println(userDAO.getUsersWithName("AtagaN").get(0).getAge());

        HibernateUtil.getSessionFactory().close();
    }
}
