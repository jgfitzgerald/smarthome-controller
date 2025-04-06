import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class AirConditionerTest {

    @Test
    @DisplayName("Turn on the AC")
    void turnOn() {
        AirConditioner ac = new AirConditioner();
        ac.turnOn();
        assertTrue(ac.isOn(), "AC should always be on after calling turnOn()");
    }

    @Test
    @DisplayName("Turn off the AC")
    void turnOff() {
        AirConditioner ac = new AirConditioner();
        assertFalse(ac.isOn(), "AC is off by default");
        ac.turnOn();
        ac.turnOff();
        assertFalse(ac.isOn(), "AC is off after turnOff() is called.");
    }

    @Test
    @DisplayName("Toggle should cycle through OFF → COOL → HEAT → OFF")
    void toggleCyclesThroughModes() {
        AirConditioner ac = new AirConditioner();

        // Initial state: OFF
        assertEquals(AirConditioner.Mode.OFF, ac.getMode());

        // First toggle: OFF --> COOL
        ac.toggle();
        assertEquals(AirConditioner.Mode.COOL, ac.getMode());

        // Second toggle: COOL --> HEAT
        ac.toggle();
        assertEquals(AirConditioner.Mode.HEAT, ac.getMode());

        // Third toggle: HEAT --> OFF
        ac.toggle();
        assertEquals(AirConditioner.Mode.OFF, ac.getMode());
    }
}