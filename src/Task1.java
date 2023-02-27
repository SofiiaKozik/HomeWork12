
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Task1 {

    public void gettime() {

        final int initialDelayTimeService = 0;
        final int periodTimeService = 1;
        final int initialDelayFiveSecondsService = 5;
        final int periodFiveSecondsService = 5;

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        executorService.scheduleAtFixedRate(
                () -> System.out.println("Time: " + new Date()),
                initialDelayTimeService,
                periodTimeService,
                TimeUnit.SECONDS
        );

        executorService.scheduleAtFixedRate(
                () -> System.out.println("5 seconds have passed"),
                initialDelayFiveSecondsService,
                periodFiveSecondsService,
                TimeUnit.SECONDS
        );
    }
}
