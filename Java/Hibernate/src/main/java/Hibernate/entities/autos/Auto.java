package Hibernate.entities.autos;

import com.sun.istack.internal.NotNull;


import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "MODEL_AUTO")
public abstract class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;



    @NotNull
    @Column(nullable = false)
    private String color;


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
