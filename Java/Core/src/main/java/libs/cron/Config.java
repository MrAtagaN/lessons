package libs.cron;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import java.util.concurrent.Executor;

@Configuration
public class Config {


    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();

        // запустится  4 долгих процесса, после чего задачи будут ждать, когда освободится нить
        threadPoolTaskScheduler.setPoolSize(4);

        threadPoolTaskScheduler.setThreadNamePrefix("ThreadPoolTaskScheduler-");
        return threadPoolTaskScheduler;
    }


}
