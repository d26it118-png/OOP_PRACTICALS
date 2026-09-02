interface Switchable {

    void on();

    void off();

    // Default method
    default void toggle() {
        on();
    }
}

class Fan implements Switchable {

    public void on() {
        System.out.println("Fan is ON");
    }

    public void off() {
        System.out.println("Fan is OFF");
    }
}

class Light implements Switchable {

    public void on() {
        System.out.println("Light is ON");
    }

    public void off() {
        System.out.println("Light is OFF");
    }
}

// Functional Interface
interface SwitchPermission {

    boolean canSwitchOn(Switchable device, int hour);
}

public class RemoteControl {

    public static void main(String[] args) {

        Fan fan = new Fan();
        Light light = new Light();

        // Array of Switchable devices
        Switchable[] devices = { fan, light };

        System.out.println("Toggling Devices:");

        // Loop through devices
        for (Switchable device : devices) {
            device.toggle();
        }

        System.out.println();

        int hour = 10;

        // Using Anonymous Class
        SwitchPermission permission1 = new SwitchPermission() {

            public boolean canSwitchOn(Switchable device, int hour) {

                if (hour >= 8 && hour <= 18) {
                    return true;
                }

                return false;
            }
        };

        System.out.println("Using Anonymous Class:");

        if (permission1.canSwitchOn(fan, hour)) {
            System.out.println("Fan can be switched ON");
        } else {
            System.out.println("Fan cannot be switched ON");
        }

        // Using Lambda Expression
        SwitchPermission permission2 = (device, time) -> time >= 8 && time <= 18;

        System.out.println();

        System.out.println("Using Lambda:");

        if (permission2.canSwitchOn(light, hour)) {
            System.out.println("Light can be switched ON");
        } else {
            System.out.println("Light cannot be switched ON");
        }
    }
}