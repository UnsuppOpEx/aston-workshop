package aston.task3.adapter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PrinterAdapterTest {
    private PrinterAdapter adapter;
    private LegacyPrinter legacyPrinter;


    @BeforeEach
    void setUp() {
        legacyPrinter = Mockito.mock(LegacyPrinter.class);
        adapter = Mockito.spy(new PrinterAdapter(legacyPrinter));
    }

    @Test
    void whenPrintWasCalledWithText_thenCallingMethodPrintByAdapterClassWithExpectedText() {
        String text = "Print legacy document";
        adapter.print(text);

        Mockito.verify(adapter, Mockito.times(1)).print(text);
    }
}
