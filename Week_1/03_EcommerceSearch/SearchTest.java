import java.util.Arrays;
import java.util.Random;

public class SearchTest {
    public static void main(String[] args) {
        int size = 10000;
        Product[] products = new Product[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            String id = String.format("P%05d", random.nextInt(100000));
            products[i] = new Product(id, "Product_" + id, "Category_" + (i % 5));
        }

        String targetId = products[size / 2].getProductId();

        long startTime = System.nanoTime();
        int linearIndex = SearchAlgorithms.linearSearch(products, targetId);
        long endTime = System.nanoTime();
        long linearDuration = endTime - startTime;

        System.out.println("Linear Search:");
        System.out.println("Target ID: " + targetId);
        System.out.println("Found Index: " + linearIndex);
        System.out.println("Time taken: " + linearDuration + " ns");

        Arrays.sort(products);

        startTime = System.nanoTime();
        int binaryIndex = SearchAlgorithms.binarySearch(products, targetId);
        endTime = System.nanoTime();
        long binaryDuration = endTime - startTime;

        System.out.println("\nBinary Search (on sorted array):");
        System.out.println("Target ID: " + targetId);
        System.out.println("Found Index: " + binaryIndex);
        System.out.println("Time taken: " + binaryDuration + " ns");

        System.out.println("\nPerformance Ratio (Linear / Binary): " + ((double) linearDuration / binaryDuration));
    }
}
