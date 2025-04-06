import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LightTest {

    @Test
    @DisplayName("Turn on the lights")
    void turnOn() {
        Light light = new Light();
        light.turnOn();
        assertTrue(light.isOn(), "Light should always be on after calling turnOn()");
    }

    @Test
    @DisplayName("Turn off the lights")
    void turnOff() {
        Light light = new Light();
        light.turnOff();
        assertFalse(light.isOn(), "Light should always be off after calling turnOn()");
    }

    @Test
    @DisplayName("Toggling light switch")
    void toggle() {
        Light light = new Light();

        // Light is initially off, toggle should turn it on
        light.toggle();
        assertTrue(light.isOn(), "Light should be on after first toggle");

        // Toggle again, should turn off
        light.toggle();
        assertFalse(light.isOn(), "Light should be off after second toggle");
    }
}