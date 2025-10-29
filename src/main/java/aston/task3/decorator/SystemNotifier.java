package aston.task3.decorator;

public class SystemNotifier implements Notifier {
    @Override
    public void notify(String message) {
        System.out.println("System Notifier: " + message);
    }
}
