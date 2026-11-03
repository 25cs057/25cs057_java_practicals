package exercise1;

/**
 * Functional Interface to evaluate whether a device is permitted to turn on
 * during a specific hour of the day (0-23).
 */
@FunctionalInterface
public interface DeviceScheduler {
    boolean canSwitchOn(Switchable device, int hour);
}

