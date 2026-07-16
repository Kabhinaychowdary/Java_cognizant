public class Main {

    public static void runTest() {

        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordFile = wordFactory.createDocument();
        wordFile.open();
        wordFile.close();
        

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfFile = pdfFactory.createDocument();
        pdfFile.open();
        pdfFile.close();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelFile = excelFactory.createDocument();
        excelFile.open();
        excelFile.close();
    }

    public static void main(String[] args) {

        System.out.println("FACTORY METHOD PATTERN DEMO");
        System.out.println();

        runTest();
    }
}