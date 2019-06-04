package SpringData.Repository;

import SpringData.Entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PersonRepository {

    @Autowired
    RowMapper rowMapper;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> getAllUsers() {
        return jdbcTemplate.query("select * from PERSON", rowMapper);
    }
}

