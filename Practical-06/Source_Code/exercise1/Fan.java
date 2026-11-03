package exercise1;

public class Fan implements Switchable {
    private final String name;
    private boolean state;

    public Fan(String name) {
        this.name = name;
        this.state = false;
    }

    @Override
    public void on() {
        this.state = true;
        System.out.println("  [ACTION] " + name + " is now spinning ON.");
    }

    @Override
    public void off() {
        this.state = false;
        System.out.println("  [ACTION] " + name + " is now powered OFF.");
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

