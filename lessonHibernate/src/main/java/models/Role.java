package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by AtagaN on 12.05.2018.
 */
@Entity
@Table(name="role")
public class Role extends Model{

    @Column(name = "title")
    private String title;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet();

    private final static long SerialVersionUID=1;



    public Role() {
    }

    public Role(long id) {
        super(id);
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
