public class ExcelDocument implements Document {

    public ExcelDocument() {
        System.out.println("A new Excel document has been created");
    }

    @Override
    public void open() {
        System.out.println("Excel document is now open");
    }

    @Override
    public void close() {
        System.out.println("Excel document is now closed");
    }
}