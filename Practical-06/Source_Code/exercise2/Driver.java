package exercise2;

/**
 * Practical 06 - Exercise 2 (Driver)
 * Student Name: Krupal Parmar
 * Student ID: 25CS057
 * Course: CEUE203 - Object-Oriented Programming
 *
 * Problem Statement:
 * Notification senders: a functional interface Notifier with send(String); make
 * email and SMS senders as lambdas, hold them in an array, and broadcast one message
 * through all. Add a marker interface Urgent and send twice for senders marked urgent.
 */
public class Driver {
    public static void main(String[] args) {
        System.out.println("=== Practical 06 - Exercise 2: Notification Broadcast System ===");

        // Email sender defined as a lambda expression
        Notifier emailSender = message ->
            System.out.println("[EMAIL GATEWAY] Sending to user@example.com: " + message);

        // SMS sender defined as a lambda expression
        Notifier smsSender = message ->
            System.out.println("[SMS GATEWAY] Dispatching to +91-9876543210: " + message);

        // Urgent push notification channel implementing the Urgent marker interface
        Notifier urgentPushSender = new UrgentPushNotifier("Ops-Critical-Line");

        // Hold all senders in an array
        Notifier[] channels = new Notifier[] {
            emailSender,
            smsSender,
            urgentPushSender
        };

        String broadcastMessage = "Critical server temperature alert - immediate action required!";
        System.out.println("\nBroadcasting Message: \"" + broadcastMessage + "\"\n");

        for (int i = 0; i < channels.length; i++) {
            Notifier sender = channels[i];
            System.out.println("Channel " + (i + 1) + " [" + sender.getClass().getSimpleName() + "]:");

            // Check if sender implements the Urgent marker interface
            if (sender instanceof Urgent) {
                System.out.println("  (URGENT MARKER DETECTED: Dispatching high-priority redundancy - Sending 2 times)");
                sender.send(broadcastMessage);
                sender.send(broadcastMessage);
            } else {
                sender.send(broadcastMessage);
            }
            System.out.println();
        }

        System.out.println("Broadcast completed across all channels.");
    }
}

