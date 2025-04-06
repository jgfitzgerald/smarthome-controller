public class Fan implements Appliance {

    private int speed;

    public Fan() {
        this.speed = 0;
    }

    @Override
    public void turnOn() {
        this.speed = 1;
    }

    @Override
    public void turnOff() {
        this.speed = 0;
    }

    @Override
    public void toggle() {
        if (this.speed == 2) {
            this.speed = 0;
        } else {
            this.speed++;
        }
    }

    @Override
    public boolean isOn() {
        return this.speed != 0;
    }

    public int getSpeed() {
        return this.speed;
    }
}
