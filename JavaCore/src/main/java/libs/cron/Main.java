package libs.cron;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
public class Main {

    public static Logger LOG = LoggerFactory.getLogger(libs.slf4j.Main.class);

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


    /**
     * 1.Seconds
     *
     * 2.Minutes
     *
     * 3.Hours
     *
     * 4.Day-оф-Месяц
     *
     * 5.Month
     *
     * 6.Day-недельного
     *
     * 7.Year(необязательное поле)
     */
    @Scheduled(cron="* * * * * *", zone="Europe/Istanbul")
    public void doScheduledWork() {
        LOG.info("DO SCHEDULED WORK");
    }
}
