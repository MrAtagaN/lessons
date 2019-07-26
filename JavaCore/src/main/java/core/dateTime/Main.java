package core.dateTime;

import java.sql.Timestamp;
import java.time.LocalDateTime;


public class Main {

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
    }
}
