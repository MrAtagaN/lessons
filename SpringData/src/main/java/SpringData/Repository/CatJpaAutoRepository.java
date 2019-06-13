package SpringData.Repository;

import SpringData.Entities.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface CatJpaAutoRepository extends JpaRepository<Cat, Long> {

    List<Cat> findCatsByName(String name);

    @Query("select c from Cat c where c.age = :age")
    Cat findCatByAge(@Param("age")int age);
}
