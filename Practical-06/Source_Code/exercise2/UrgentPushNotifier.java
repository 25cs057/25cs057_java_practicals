package exercise2;

/**
 * High-priority push notifier implementing both Notifier and the Urgent marker interface.
 */
public class UrgentPushNotifier implements Notifier, Urgent {
    private final String channelName;

    public UrgentPushNotifier(String channelName) {
        this.channelName = channelName;
    }

    @Override
    public void send(String message) {
        System.out.println("[PUSH NOTIFICATION - " + channelName + "] ALERT: " + message);
    }
}

