package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "requset")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "myServiceRequest", propOrder={"someValue", "someInt"})
public class SoapRequset {

    @XmlElement(required = true)
    private String someValue;

    @XmlElement(required = true)
    private int someInt;


    public String getSomeValue() {
        return someValue;
    }

    public void setSomeValue(String someValue) {
        this.someValue = someValue;
    }

    public int getSomeInt() {
        return someInt;
    }

    public void setSomeInt(int someInt) {
        this.someInt = someInt;
    }

    @Override
    public String toString() {
        return "SoapRequset{" +
                "someValue='" + someValue + '\'' +
                ", someInt=" + someInt +
                '}';
    }
}
