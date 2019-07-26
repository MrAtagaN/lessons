package Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class UserDAO {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


    public List<User> getAllUsers() {
        List<User> result = new ArrayList();
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("FROM User");
            result = query.list();
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                session.close();
            }
        }
        return result;
    }


    public User findById(int id) {
        User result = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            result = session.get(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                session.close();
            }
        }
        return result;
    }


    public void saveUser(User user) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            if (session != null) {
                session.close();
            }
        }
    }


    public void update(User user) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            if (session != null) {
                session.close();
            }
        }
    }


    public void delete(User user) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            if (session != null) {
                session.close();
            }
        }
    }


}
