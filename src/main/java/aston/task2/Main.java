package aston.task2;

public class Main {
    public static void main(String[] args) throws FileExecutorProcessException {
        FileExecutorProcess processor = new FileExecutorProcess();

        processor.executeProcess(FileOperationType.WRITE, "Harry Potter and the Sorcerer's Stone");

        String content = processor.executeProcess(FileOperationType.READ, null);
        System.out.println(content);
    }
}
