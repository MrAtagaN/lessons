package core.generics.example2;


public class Phone extends Product implements Comparable<Phone> {

    protected String model;

    @Override
    public int compareTo(Phone o) {
        return 0;
    }
}
