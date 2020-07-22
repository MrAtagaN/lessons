package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlRootElement(name = "goods")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "good", propOrder={"count", "name"})
public class Goods implements Serializable {


    @XmlElement(required = true)
    private int count;

    @XmlElement(required = true)
    private String name;


    public Goods() {
    }

    public Goods(int count, String name) {
        this.count = count;
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "count=" + count +
                ", name='" + name + '\'' +
                '}';
    }
}
