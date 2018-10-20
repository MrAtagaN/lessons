import models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Created by AtagaN on 11.05.2018.
 */
public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        System.out.println("connection succsess");


        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();

            User user1 = new User(2, 23, "aaa","bbb");
            User user2 = new User(5,32,"ccc","ddd");
            User user3 = new User(2,32,"asd","asd");

            session.save(user1);
            session.save(user2);
            session.save(user3);


            user1.setAge(10);
            session.save(user1);

            session.remove(user2);

            session.save(user1);

            transaction.commit();
        }
        catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            System.out.println("Error");
            e.printStackTrace();
        }
        finally {
            session.close();
            sessionFactory.close();
        }

    }
}
