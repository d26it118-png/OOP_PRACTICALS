// Functional Interface
interface Notifier {

    void send(String message);
}

// Marker Interface
interface Urgent {
}

// Email sender
class EmailSender implements Notifier, Urgent {

    public void send(String message) {
        System.out.println("Email: " + message);
    }
}

// SMS sender
class SMSSender implements Notifier {

    public void send(String message) {
        System.out.println("SMS: " + message);
    }
}

public class NotificationSender {

    public static void main(String[] args) {

        // Email and SMS using lambda
        Notifier email = (message) ->
                System.out.println("Email: " + message);

        Notifier sms = (message) ->
                System.out.println("SMS: " + message);

        // Array of Notifiers
        Notifier[] senders = {email, sms};

        String message = "Your class starts at 10 AM.";

        System.out.println("Normal Broadcast:");

        // Send message to all senders
        for (Notifier sender : senders) {
            sender.send(message);
        }

        System.out.println();
        System.out.println("Urgent Notification:");

        // Urgent sender
        Urgent urgentEmail = new Urgent() {
        };

        Notifier urgentSender = (msg) ->
                System.out.println("URGENT Email: " + msg);

        // Send urgent message twice
        urgentSender.send(message);
        urgentSender.send(message);
    }
}