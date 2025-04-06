import java.util.HashMap;
import java.util.Map;

public class SmartHomeController {

    private final Map<String, Appliance> appliances;

    // Instantiate the SmartHomeController with default appliances
    // Light, Fan, and Air Conditioner
    public SmartHomeController() {
        this.appliances = new HashMap<>();

        Fan fan = new Fan();
        Light light = new Light();
        AirConditioner airConditioner = new AirConditioner();

        this.appliances.put("Fan", fan);
        this.appliances.put("Light", light);
        this.appliances.put("Air Conditioner", airConditioner);
    }

    public void turnOn(String key) {
        this.appliances.get(key).turnOn();
    }

    public void turnOff(String key) {
        this.appliances.get(key).turnOff();

    }

    public void toggle(String key) {
        this.appliances.get(key).toggle();
    }

    // This process turns all devices off for scheduled maintenance.
    // This method would be triggered automatically on January 1st at 1:00am
    // using a scheduled task (e.g., via ScheduledExecutorService or external cron).
    public void updateSystem() {
        for (Appliance a : this.appliances.values()) {
            a.turnOff();
        }
    }

    public Map<String, Appliance> getAppliances() {
        return appliances;
    }
}
