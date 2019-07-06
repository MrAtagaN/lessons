package SpringData.Repository;

import SpringData.Entities.Cat;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public class CatRepository {

    @Autowired
    private SessionFactory sessionFactory;


    public void saveCat(Cat cat ) {
        sessionFactory.getCurrentSession().save(cat);
    }
}
