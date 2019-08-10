package Hibernate;

import Hibernate.entities.User;
import Hibernate.entities.animal.Animal;
import Hibernate.entities.animal.Cat;
import Hibernate.entities.animal.Dog;
import Hibernate.entities.autos.Auto;
import Hibernate.entities.autos.Bmw;
import Hibernate.entities.autos.Tesla;
import Hibernate.entities.bank_details.BankDetails;
import Hibernate.entities.bank_details.CreditCard;
import Hibernate.entities.bank_details.DebitCard;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(User.class);
        cfg.addAnnotatedClass(BankDetails.class);
        cfg.addAnnotatedClass(CreditCard.class);
        cfg.addAnnotatedClass(DebitCard.class);
        cfg.addAnnotatedClass(Auto.class);
        cfg.addAnnotatedClass(Tesla.class);
        cfg.addAnnotatedClass(Bmw.class);
        cfg.addAnnotatedClass(Animal.class);
        cfg.addAnnotatedClass(Cat.class);
        cfg.addAnnotatedClass(Dog.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());

        sessionFactory = cfg.buildSessionFactory(builder.build());
    }


    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
