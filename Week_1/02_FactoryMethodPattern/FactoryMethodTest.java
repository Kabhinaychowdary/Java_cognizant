public class FactoryMethodTest {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        Document doc1 = wordFactory.createDocument();
        Document doc2 = pdfFactory.createDocument();
        Document doc3 = excelFactory.createDocument();

        doc1.open();
        doc1.save();
        doc1.close();

        System.out.println();

        doc2.open();
        doc2.save();
        doc2.close();

        System.out.println();

        doc3.open();
        doc3.save();
        doc3.close();
    }
}
