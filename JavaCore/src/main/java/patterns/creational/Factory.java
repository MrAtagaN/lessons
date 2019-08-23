package patterns.creational;

import java.util.Calendar;

public class Factory {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
        System.out.println(calendar.getClass().getCanonicalName());
    }
}
