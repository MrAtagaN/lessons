package core.dateTime;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;


public class Main {

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(localDateTime);

        DateFormat instance = SimpleDateFormat.getInstance();
        instance.format("");
    }
}
