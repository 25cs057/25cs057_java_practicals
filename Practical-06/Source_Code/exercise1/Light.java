package exercise1;

public class Light implements Switchable {
    private final String name;
    private boolean state;

    public Light(String name) {
        this.name = name;
        this.state = false;
    }

    @Override
    public void on() {
        this.state = true;
        System.out.println("  [ACTION] " + name + " is now illuminated ON.");
    }

    @Override
    public void off() {
        this.state = false;
        System.out.println("  [ACTION] " + name + " is now turned OFF.");
    }

    @Override
    public boolean isOn() {
        return state;
    }

    @Override
    public String getName() {
        return name;
    }
}

