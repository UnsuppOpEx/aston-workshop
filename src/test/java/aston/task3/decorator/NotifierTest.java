package aston.task3.decorator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class NotifierTest {
    private Notifier systemNotifier;
    private Notifier emailDecoratorNotifier;
    private Notifier smsDecoratorNotifier;

    @BeforeEach
    void setUp() {
        systemNotifier = Mockito.spy(new SystemNotifier());
        emailDecoratorNotifier = Mockito.spy(new EmailDecoratorNotifier(systemNotifier));
        smsDecoratorNotifier = Mockito.spy(new SmsDecoratorNotifier(emailDecoratorNotifier));
    }

    @Test
    void whenNotifyWasCalledWithMessage_thenAllNotifierClassesCallingWithMethodNotify() {
        smsDecoratorNotifier.notify("Hello guys!!!");

        Mockito.verify(systemNotifier, Mockito.times(1)).notify("Hello guys!!!");
        Mockito.verify(emailDecoratorNotifier, Mockito.times(1)).notify("Hello guys!!!");
        Mockito.verify(smsDecoratorNotifier, Mockito.times(1)).notify("Hello guys!!!");
    }
}
