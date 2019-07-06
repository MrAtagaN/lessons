package Hibernate2;


import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@BatchSize(size = 10) //аннотация Hibernate, объекты загружаются пачками (среднее между ленивой и не ленивой загрузкой)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    //двунаправленая связь, т.е. у Auto есть ссылка на User, а у User есть ссылка на Auto
    //чтобы Hibernate понимал эту связь, нужно указывать mappedBy, в котором указать имя атрибута ссылающегося на данный объект
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Auto> autos;


    public User() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addAuto(Auto auto) {
        auto.setUser(this);
        autos.add(auto);
    }

    public void removeAuto(Auto auto) {
        autos.remove(auto);
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Auto> getAutos() {
        return autos;
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }
}
