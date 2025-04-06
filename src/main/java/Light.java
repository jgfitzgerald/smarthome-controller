public class Light implements Appliance {

    private boolean isOn;

    public Light() {
        this.isOn = false;
    }

    @Override
    public void turnOn() {
        this.isOn = true;
    }

    @Override
    public void turnOff() {
        this.isOn = false;
    }

    @Override
    public void toggle() {
        this.isOn = !this.isOn;
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

}
