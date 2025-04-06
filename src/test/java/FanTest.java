import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FanTest {

    @Test
    @DisplayName("Turn on the fan")
    void turnOn() {
        Fan fan = new Fan();
        fan.turnOn();
        assertTrue(fan.isOn(), "Fan should always be on after calling turnOn()");
    }

    @Test
    @DisplayName("Turn off the fan")
    void turnOff() {
        Fan fan = new Fan();
        assertFalse(fan.isOn(), "Fan is off by default");
        fan.turnOn();
        fan.turnOff();
        assertFalse(fan.isOn(), "Fan is off after turnOff() is called.");
    }

    @Test
    @DisplayName("Toggle the fan")
    void toggle() {
        Fan fan = new Fan();
        assertEquals(0, fan.getSpeed(), "Fan speed is 0 by default.");
        fan.toggle();
        assertEquals(1, fan.getSpeed(), "Fan speed is increased by one, max 2.");
        fan.toggle();
        assertEquals(2, fan.getSpeed(), "Fan speed is increased by one, max 2.");
        fan.toggle();
        assertEquals(0, fan.getSpeed(), "Fan speed wraps around to 0.");

    }
}