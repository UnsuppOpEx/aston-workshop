package aston.task3.decorator;

public class SmsDecoratorNotifier implements Notifier {
    private Notifier wrapper;

    public SmsDecoratorNotifier(Notifier wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public void notify(String message) {
        wrapper.notify(message);
        System.out.println("SMS Notifier: " + message);
    }
}
