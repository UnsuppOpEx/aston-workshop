package aston.task3.adapter;

public class PrinterAdapter implements Printer {
    private LegacyPrinter legacyPrinter;

    public PrinterAdapter(LegacyPrinter legacyPrinter) {
        this.legacyPrinter = legacyPrinter;
    }

    @Override
    public void print(String message) {
        legacyPrinter.printLegacyFormat(message);
    }
}
