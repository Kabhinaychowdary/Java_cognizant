public class PdfDocument implements Document {

    public PdfDocument() {
        System.out.println("A new PDF document has been created");
    }

    @Override
    public void open() {
        System.out.println("PDF document is now open");
    }

    @Override
    public void close() {
        System.out.println("PDF document is now closed");
    }
}