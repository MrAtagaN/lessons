package SpringData.Repository;

import SpringData.Entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Методы jdbcTemplate:
 * <p>
 * execute - выполнить sql запрос
 * update - возвращает количество измененных строк
 * queryForObject - возвращает один объект или кидает Exception
 * batchUpdate
 * query - возвращает List объектов
 * queryForList - возвращает List<Map<String, Object>>. Sql возвращает несколько строк  (Используется для поиска нескольких объектов)
 * queryForMap - возвращает map, (название колонки - значение). Sql должен вернуть одну строку (Используется для поиска одного объекта)
 */
@Repository
public class PersonRepository {

    @Autowired
    RowMapper rowMapper;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Person findPersonById(int id) {
        return (Person) jdbcTemplate.queryForObject("select * from PERSON join ADDRESS on PERSON.address_id = ADDRESS.id where PERSON.id = ?", rowMapper, id);
    }

    public List<Person> findAllUsers() {
        return jdbcTemplate.query("select * from PERSON join ADDRESS on PERSON.address_id = ADDRESS.id", rowMapper);
    }

    public void createUser(Person person) {
        jdbcTemplate.update("insert into PERSON (name, age, phone, address_id, birthday) values (?, ?, ?, ?, ?)", person.getName(), person.getAge(), person.getPhone(), person.getAddress().getId(), person.getBirthday());
    }

    public List<Person> findUsersByName(String name) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", name);
        return namedParameterJdbcTemplate.query("select * from PERSON join ADDRESS on PERSON.address_id = ADDRESS.id where name = :name", map, rowMapper);
    }
}

