package libs.cron;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Если не использовать @Async и @EnableAsync, то методы будут работать последовательно. Но даже в этом
 * случае он зависает.
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
        Thread.sleep(1000000);
        LOG.info("DO SCHEDULED WORK: cron = \"* * * * * *\"");
    }


    @Scheduled(fixedRate = 1000)
    @Async
    public void doScheduledWork() {
        LOG.info("DO SCHEDULED WORK: fixedRate = 1000");
    }
}
