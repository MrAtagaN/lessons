package SpringData.Repository;

import SpringData.Entities.Address;
import SpringData.Entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public class PersonRepository {

    @Autowired
    RowMapper rowMapper;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> getAllUsers() {
        return jdbcTemplate.query("select * from PERSON join ADDRESS on PERSON.address_id = ADDRESS.id", rowMapper);
    }

    public void createUser(Person person) {
        jdbcTemplate.update("insert into PERSON (name, age, phone, address_id, birthday) values (?, ?, ?, ?, ?)", person.getName(), person.getAge(), person.getPhone(), person.getAddress().getId(), person.getBirthday());
    }
}

