package SpringData.Repository;

import SpringData.Entities.Cat;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;


@Repository
@Transactional
public class CatJpaRepositoryImpl {

    @PersistenceUnit
    @Qualifier("entityManagerFactory")
    EntityManagerFactory entityManagerFactory;

    @PersistenceContext()
    EntityManager entityManager;

    public void saveCat(Cat cat) {
        entityManager.persist(cat);
        //entityManagerFactory.createEntityManager().persist(cat);
    }
}
