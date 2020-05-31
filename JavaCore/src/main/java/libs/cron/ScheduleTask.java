package libs.cron;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Если не использовать @Async и @EnableAsync, то методы @Scheduled будут работать последовательно,
 * даже если находятся в разных бинах.
 * Но даже с @Async и @EnableAsync выполнение тасок зависает, если закончатся нити в Executor.
 */
@Component
public class ScheduleTask {

    private static Logger LOG = LoggerFactory.getLogger(ScheduleTask.class);

    /**
     * 1.Seconds
     * 2.Minutes
     * 3.Hours
     * 4.Day-оф-Месяц
     * 5.Month
     * 6.Day-недельного
     * 7.Year(необязательное поле)
     */
    @Scheduled(cron="* * * * * *", zone="Europe/Istanbul")
    @Async
    public void doScheduledWork2() throws InterruptedException {
        LOG.info("First method start");
        Thread.sleep(1000000); // Долгая работа работа
        LOG.info("First method END !");
    }


    @Scheduled(fixedRate = 1000)
    @Async
    public void doScheduledWork() {
        LOG.info("Second method start");
    }
}
