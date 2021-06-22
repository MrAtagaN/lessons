package Hibernate;

import Hibernate.dao.UserDAO;
import Hibernate.entities.User;
import Hibernate.entities.animal.Cat;
import Hibernate.entities.animal.Dog;
import Hibernate.entities.autos.Auto;
import Hibernate.entities.autos.Bmw;
import Hibernate.entities.autos.Tesla;
import Hibernate.entities.bank_details.CreditCard;
import Hibernate.entities.bank_details.DebitCard;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDateTime;

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
        session.persist(user);       // переводим объект в состояние persistent
        session.save(user);  // обект в состоянии persistent, save не меняет состояние
        user.setName("Mike_merge");
        session.merge(user);

        User user2 = new User();
        user2.setName("Jonn");
        user2.setBankDetails(new DebitCard("Jonn_owner"));
        int id = (int) session.save(user2);  // сохраняем объект и получаем id
        System.out.println("user2 id = " + id);

        User user3 = new User();
        user3.setName("Lena");
        user3.setState(User.State.FEMALE);
        CreditCard creditCard = new CreditCard("Lena_owner");
        user3.setBankDetails(creditCard);
        session.saveOrUpdate(user3);

        User user4 = new User();
        user4.setName("Anna, save with merge");
        session.merge(user4); // если объект в состоянии transient merge сохраняет его в базу, update кидает exception


        session.flush(); // объекты хранящиеся в сессии инсертятся в базу сессия очищается от объектоа находящихся в ней
                         // (при откате вставленные в базу объекты удалятся из базы )
        transaction.commit(); // сохраняются обекты привязанные к сессии и переводятся в состояние detached
        session.close();      // объекты соъраняются при  transaction.commit() и при session.close()

        // НАЧИНАЕМ НОВУЮ СЕССИЮ
        Session session2 = HibernateUtil.getSessionFactory().openSession();
        transaction = session2.beginTransaction();

        //   session2.persist(user); будет брошен Exceptoin т.к. объект в состоянии detached
        //   session2.save(user);    объект будет сохранём в базе (появится дублирующая строка)

        user2.setName("Jonn_name_after_update");
        session2.update(user2);  //находим по id обект и сохраняем новые поля в базу, переводим объект в состояние persistent
        user2.setName("Jonn_name_after_update_and_state_persistent"); // без session.update(user2)
        // состояние объекта было бы detached и изменение в базе не проихошло


        // сохраняем объекты для примера стратегий наследования
        Tesla tesla = new Tesla();
        tesla.setColor("White");
        tesla.setBattaryCharge(500);
        session2.merge(tesla);

        Bmw bmw = new Bmw();
        bmw.setColor("Black");
        bmw.setGasTankValume(60);
        session2.merge(bmw);

        Cat cat = new Cat();
        cat.setCanClimbing(true);
        cat.setName("Barsik");
        session2.merge(cat);

        Dog dog = new Dog();
        dog.setCanGuard(false);
        dog.setName("Bobik");
        session2.persist(dog);


        transaction.commit();
        session2.close();


        HibernateUtil.getSessionFactory().close();
    }
}
