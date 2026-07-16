public class WordDocument implements Document {

    public WordDocument() {
        System.out.println("A new Word document has been created");
    }

    @Override
    public void open() {
        System.out.println("Word document is now open");
    }

    @Override
    public void close() {
        System.out.println("Word document is now closed");
    }
}