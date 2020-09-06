package core.generics.example2;


public class Phone extends Product<Phone> {

    protected String model;

    @Override
    public int compareTo(Phone o) {
        return 0;
    }
}
