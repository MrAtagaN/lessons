package SpringData.Repository;

import SpringData.Entities.Address;
import SpringData.Entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

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

    public int getRowList() {
        MapSqlParameterSource params = getMapSqlParametersForUpdate();
        return namedParameterJdbcTemplate.update("update PERSON set age = 28  where name = :name", params);
    }


    private final RowMapper<Person> rowMapper = (resultSet, i) -> {
        Person person = new Person();

        person.setName(resultSet.getString("name"));
        person.setAge(resultSet.getInt("age"));
        person.setPhone(resultSet.getInt("phone"));
        person.setBirthday(resultSet.getDate("birthday"));

        Address address = new Address();
        address.setCountry(resultSet.getString("country"));
        address.setCity(resultSet.getString("city"));
        address.setStreet(resultSet.getString("street"));
        address.setHome(resultSet.getInt("home"));

        person.setAddress(address);
        return person;
    };

    private MapSqlParameterSource getMapSqlParametersForUpdate() {
        MapSqlParameterSource result = new MapSqlParameterSource();

        result.addValue("name", "AtagaN");

        return result;
    }
}

