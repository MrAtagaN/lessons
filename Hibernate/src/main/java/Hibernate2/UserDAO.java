package Hibernate2;


import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAO {

    public User findById (int id) {
        return  (User) HibernateUtil.getSessionFactory().openSession().get(User.class, id);
    }

    public void seveUser (User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public void update (User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    public void delete (User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }


}


