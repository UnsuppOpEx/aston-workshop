package aston.task3.decorator;

public class EmailDecoratorNotifier implements Notifier {
    private Notifier wrapper;

    public EmailDecoratorNotifier(Notifier wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public void notify(String message) {
        wrapper.notify(message);
        System.out.println("Email Notifier: " + message);
    }
}
