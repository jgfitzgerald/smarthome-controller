import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SmartHomeControllerTest {

    private SmartHomeController controller;

    @BeforeEach
    void setUp() {
        controller = new SmartHomeController();
    }

    @Test
    @DisplayName("All appliances should be initialized")
    void appliancesShouldBeInitialized() {
        controller.turnOn("Fan"); // should not throw
        controller.turnOn("Light"); // should not throw
        controller.turnOn("Air Conditioner"); // should not throw
    }

    @Test
    @DisplayName("Turn on Light should set it to on")
    void turnOnLight() {
        controller.turnOn("Light");

        Light light = (Light) getPrivateAppliance("Light");
        assertTrue(light.isOn());
    }

    @Test
    @DisplayName("Turn off Light should set it to off")
    void turnOffLight() {
        controller.turnOn("Light");
        controller.turnOff("Light");

        Light light = (Light) getPrivateAppliance("Light");
        assertFalse(light.isOn());
    }

    @Test
    @DisplayName("Toggle Fan should change state")
    void toggleFan() {
        Fan fan = (Fan) getPrivateAppliance("Fan");
        boolean initialState = fan.isOn();

        controller.toggle("Fan");

        assertNotEquals(initialState, fan.isOn());
    }

    @Test
    @DisplayName("Toggle Air Conditioner should change its mode")
    void toggleAirConditioner() {
        AirConditioner ac = (AirConditioner) getPrivateAppliance("Air Conditioner");
        AirConditioner.Mode initialMode = ac.getMode();

        controller.toggle("Air Conditioner");

        assertNotEquals(initialMode, ac.getMode());
    }

    @Test
    @DisplayName("updateSystem should turn off all appliances")
    void updateSystemShouldTurnOffAllAppliances() {
        controller.turnOn("Fan");
        controller.turnOn("Light");
        controller.turnOn("Air Conditioner");

        controller.updateSystem();

        assertFalse(((Fan) getPrivateAppliance("Fan")).isOn());
        assertFalse(((Light) getPrivateAppliance("Light")).isOn());
        assertEquals(AirConditioner.Mode.OFF, ((AirConditioner) getPrivateAppliance("Air Conditioner")).getMode());
    }

    // Access appliances through SmartHomeController
    private Appliance getPrivateAppliance(String name) {
        try {
            var field = SmartHomeController.class.getDeclaredField("appliances");
            field.setAccessible(true);
            @SuppressWarnings("unchecked")
            Map<String, Appliance> map = (Map<String, Appliance>) field.get(controller);
            return map.get(name);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
