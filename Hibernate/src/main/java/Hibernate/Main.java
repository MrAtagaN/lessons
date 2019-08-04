package Hibernate;

import Hibernate.dao.UserDAO;
import Hibernate.entities.User;
import Hibernate.entities.bank_details.CreditCard;
import Hibernate.entities.bank_details.DebitCard;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * SQLite
 */
public class Main {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        User user = new User();
        user.setAge(31);
        user.setName("Mike");
        user.setBirthday(LocalDateTime.now());
        user.setState(User.State.MALE);
        session.persist(user);  //Переводим объект в состояние persistent


        User user2 = new User();
        user2.setName("Jonn");
        user2.setBankDetails(new DebitCard("Jonn_owner"));

        long id = (long) session.save(user2);  //Сохраняем объект и получаем id


        transaction.commit();  //Сохраняются обекты привязанные к сессии и переводятся в состояние detached
        session.close();


//
//            User user = new User();
//            user.setAge(31);
//            user.setName("Mike");
//            user.setBirthday(LocalDateTime.now());
//            user.setState(User.State.MALE);
//
//
//            User user2 = new User();
//            user2.setName("Jonn");
//            user2.setBankDetails(new DebitCard("Jonn_owner"));


        User user3 = new User();
        user3.setName("Lena");
        user3.setState(User.State.FEMALE);
        CreditCard creditCard = new CreditCard("Lena_owner");
        user3.setBankDetails(creditCard);


        List<User> list = new ArrayList<>();
        list.add(user2);
        list.add(user3);

        UserDAO userDAO = new UserDAO();
        userDAO.saveUser(user);
        userDAO.saveUser(user2);
        userDAO.saveUser(user3);
        ///  userDAO.saveOrUpdateListObjects(list);


        //  System.out.println(userDAO.getUsersWithName("Mike").get(0).getAge());

        HibernateUtil.getSessionFactory().close();
    }
}
