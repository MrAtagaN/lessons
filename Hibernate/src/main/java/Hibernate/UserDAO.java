package Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * HQL
 */
public class UserDAO {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


    public List<Hibernate2.User> getAllUsers() {
        List<Hibernate2.User> result = new ArrayList();
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("FROM User");
            result = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Hibernate2.User findById(int id) { //Query query = session.createQuery("FROM user");
        Hibernate2.User result = null;
        try (Session session = sessionFactory.openSession()) {
            result = session.get(Hibernate2.User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public void saveUser(User user) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }


    public void update(User user) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }


    public void delete(User user) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }


}
