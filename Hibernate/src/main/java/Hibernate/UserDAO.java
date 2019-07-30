package Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

/**
 * TRY CATCH FINALLY
 */
public class UserDAO {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public List<User> getUsersWithName(String name) {
        List<User> result = new ArrayList<>();
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("FROM User u where u.name = :name");
            query.setParameter("name", name);
            result = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }


    public List<User> getAllUsers() {
        List<User> result = new ArrayList<>();
        Session session = null;
        try {
            session = sessionFactory
                    .withOptions()
                    .jdbcTimeZone(TimeZone.getTimeZone("UTC")) //Таймзона, указывается один раз в файле hibernate.cfg.xml
                    .openSession();                            //Здесь для примера
            Query query = session.createQuery("FROM User");
            result = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
        } finally {
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
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void saveOrUpdateListObjects(List<?> list) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            for (Object obj: list) {
                session.saveOrUpdate(obj);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                System.out.println(session.isOpen());
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
        } finally {
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
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


}
