package com.plekhanov.cron;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Если не использовать @Async и @EnableAsync, то методы @Scheduled будут работать последовательно,
 * даже если находятся в разных бинах.
 * Но даже с @Async и @EnableAsync выполнение тасок будет ждать свободных нитей в Executor.
 */
@Component
public class ScheduleTask {

    private static Logger LOG = LoggerFactory.getLogger(ScheduleTask.class);

    AtomicInteger atomicInteger = new AtomicInteger();

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
    public void doLongScheduledWork() throws InterruptedException {
        Thread.sleep(10000); // Долгая работа
        int count = atomicInteger.incrementAndGet();
        LOG.info("{} slow method end" , count);
    }


    @Scheduled(fixedRate = 1000)
    @Async
    public void doScheduledWork() {
        LOG.info("fast method end");
    }
}
