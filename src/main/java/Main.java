import java.time.*;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        SmartHomeController controller = new SmartHomeController();

        // Simulate using the system
        controller.turnOn("Light");
        controller.toggle("Air Conditioner");

        // Start the precise yearly maintenance scheduler
        scheduleNextUpdate(controller);
    }

    private static void scheduleNextUpdate(SmartHomeController controller) {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        Runnable maintenanceTask = new Runnable() {
            @Override
            public void run() {
                System.out.println("Running system update at: " + ZonedDateTime.now());
                controller.updateSystem();

                // Schedule the next updater
                scheduleNextUpdate(controller);
            }
        };

        // Calculate delay until next Jan 1st 1:00am
        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime nextRun = ZonedDateTime.of(
                now.getYear(), 1, 1, 1, 0, 0, 0, now.getZone()
        );

        if (now.isAfter(nextRun)) {
            nextRun = nextRun.plusYears(1);
        }

        long delay = Duration.between(now, nextRun).toMillis();

        System.out.println("Scheduling next update for: " + nextRun);

        scheduler.schedule(maintenanceTask, delay, TimeUnit.MILLISECONDS);
    }
}
