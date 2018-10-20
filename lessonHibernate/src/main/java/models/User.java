package models;

import models.Role;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by AtagaN on 12.05.2018.
 */

@Entity
@Table(name="user")
public class User extends Model{

    @Column(name = "age")
    private int age;
    @Column(name= "name")
    private String name;
    @Column(name = "lastName")
    private String lastName;

    @ManyToMany
    @JoinTable(name = "user_and_role",
            joinColumns = {@JoinColumn(name="user_id")},
            inverseJoinColumns = {@JoinColumn(name="role_id")})
    private Set<Role> roles = new HashSet();

    private final static long SerialVersionUID=3;


    public User() {
    }

    public User(long id) {
        super(id);
    }

    public User(int id, int age, String name, String lastName) {
        super(id);

        this.age = age;
        this.name = name;
        this.lastName = lastName;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
