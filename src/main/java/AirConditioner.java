public class AirConditioner implements Appliance {

    private Mode thermostatMode;

    public AirConditioner() {
        this.thermostatMode = Mode.OFF;
    }

    public enum Mode {
        OFF, COOL, HEAT;

        public Mode toggle() {
            return switch (this) {
                case OFF -> COOL;
                case COOL -> HEAT;
                case HEAT -> OFF;
            };
        }
    }

    @Override
    public void turnOn() {
        this.thermostatMode = Mode.COOL;
    }

    @Override
    public void turnOff() {
        this.thermostatMode = Mode.OFF;
    }

    @Override
    public void toggle() {
        this.thermostatMode = this.thermostatMode.toggle();
    }

    @Override
    public boolean isOn() {
        return thermostatMode != Mode.OFF;
    }

    public Mode getMode() {
        return thermostatMode;
    }
}
