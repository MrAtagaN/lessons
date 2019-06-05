package SpringData.Repository;

import SpringData.Entities.Address;
import SpringData.Entities.Person;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class PersonMapper implements RowMapper<Person> {

    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
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
    }
}
