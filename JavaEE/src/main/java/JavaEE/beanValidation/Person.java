package JavaEE.beanValidation;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Person {
    @NotNull
    private String name;
    @Min(4)
    private String adress;
    private String email;

    public Person(@NotNull String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
