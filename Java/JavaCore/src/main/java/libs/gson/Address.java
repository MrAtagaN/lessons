package libs.gson;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Since;

public class Address {

    private String country;
    private String city;
    @Since(2)
    private String street;
    @SerializedName("home_number")
    private int homeNumber;

    public Address(String country, String city, String street, int homeNumber) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.homeNumber = homeNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(int homeNumber) {
        this.homeNumber = homeNumber;
    }

    @Override
    public String toString() {
        return "{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", home=" + homeNumber +
                '}';
    }
}
